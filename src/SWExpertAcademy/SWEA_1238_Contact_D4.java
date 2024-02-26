package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
실행 시간 : 112ms
메모리 : 18688KB
*/

public class SWEA_1238_Contact_D4 {

	static class Node{
		int val;
		Node next;

		public Node(int val, Node next) {
			this.val = val;
			this.next = next;
		}
	}

	static Map<Integer, Node> map = new HashMap<>();

	private static int bfs(int s) {
		Queue<Integer> q = new ArrayDeque<>();
		ArrayList<Integer> visited = new ArrayList<>();
		ArrayList<Integer> lastAdded = new ArrayList<>();

		q.offer(s);
		visited.add(s);

		while (!q.isEmpty()) {

			lastAdded.clear();

			for (int i = 0, size = q.size(); i < size; i++) {
				int cur = q.poll();
				lastAdded.add(cur);
				for (Node node = map.get(cur); node != null; node = node.next) {

					if (visited.contains(node.val)) continue;

					visited.add(node.val);
					q.offer(node.val);
				}
			}

		}

		lastAdded.sort(Collections.reverseOrder());
		return lastAdded.get(0);
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int tc = 1; tc <= 10; tc++){
			map = new HashMap<>();
			st = new StringTokenizer(br.readLine());
			int dataNum = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < dataNum / 2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
                map.put(from, new Node(to, map.getOrDefault(from, null)));
			}

			System.out.println("#"+tc+" " + bfs(start));
		}
	}
}
