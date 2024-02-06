package Baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
시작 시간 : 24-02-05 22:00
종료 시간 : 24-02-05 00:10
실행 시간 : 1656ms
메 모 리 : 31416KB

고려사항
컨베이어 벨트가 회전한 뒤, 오른쪽 끝에서 떨어지는 로봇을 고려하지 못해
풀이 시간이 오래 걸렸습니다.
빡구현 문제를 푸는 경우, 각 기능을 메소드로 빼는 것이 좋을 것같다고 생각하였습니다.
*/

public class BOJ_20055_컨베이어벨트위의로봇_G5 {

	static class Node{
		int durability;
		boolean hasRobot;

		public Node(int durability, boolean hasRobot) {
			this.durability = durability;
			this.hasRobot = hasRobot;
		}
	}

	static int N, K, level, zeroCnt = 0;
	static int putIdx, popIdx;
	static List<Node> belt = new LinkedList<>();
	public static void main(String[] args) throws IOException {

		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		putIdx = 2*N-1; popIdx = N;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 2*N; i++) {
			belt.add(new Node(Integer.parseInt(st.nextToken()), false));
		}
		Collections.reverse(belt);

		// N번째 인덱스가 drop 위치
		// last 인덱스가 put 위치
		while(zeroCnt < K){
			// process 1 : 컨베이어 벨트 회전
			Node last = belt.remove(0);
			belt.add(last);

			belt.get(popIdx).hasRobot = false;

			// process 2 : 로봇 이동
			// 내리는 지점 왼쪽칸 부터 왼쪽 끝까지 탐색
			for(int beltIdx = popIdx+1; beltIdx <= putIdx; beltIdx++){

				if(belt.get(beltIdx).hasRobot // 현재 위치에 로봇이 있고,
						&& belt.get(beltIdx-1).durability >= 1 // 오른쪽 칸에 내구도가 1이상이고.
						&& !belt.get(beltIdx-1).hasRobot){ // 오른쪽 칸에 로봇이 없는 경우
					belt.get(beltIdx).hasRobot = false;
					belt.get(beltIdx-1).hasRobot = true;
					belt.get(beltIdx-1).durability--;
				}
			}

			// process 3 : 마지막 로봇 삭제, 로봇 추가 및 내구도 0 체크
			belt.get(popIdx).hasRobot = false;

			// process 0 : 로봇 배치
			if(belt.get(putIdx).durability > 0) {
				belt.get(putIdx).hasRobot = true;
				belt.get(putIdx).durability--;
			}

			int count = 0;

			for(Node n : belt){
				if(n.durability == 0) count++;
			}
			level++;

			if(count >= K) {
				break;
			}

		}

		System.out.println(level);
	}
}