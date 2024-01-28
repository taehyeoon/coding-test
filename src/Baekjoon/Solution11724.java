package Baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
백준 연결요소의개수 11724 S2
시작 시간 : 24-01-28 16:20
종료 시간 : 24-01-28 16:50
실행시간 : 1024ms

고려사항
BFS탐색을 통해 연결요소의 개수를 체크하였습니다.
BFS 1회당 한개의 연결요소로 처리하였습니다.

주의 : BFS탐색 시 큐에 방문 예정인 노드가 있는 경우,
해당 노드를 중복해서 큐에 넣지 않는 것이 중요합니다.
 */

public class Solution11724 {
    static int N, M, ans;
    static ArrayList<Integer>[] nodes;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nodes = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) nodes[i] = new ArrayList<>();
        visited = new boolean[N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            nodes[a].add(b);
            nodes[b].add(a);
        }

        int nextIdx = 1;
        while(true){
            ans++;

            Queue<Integer> q = new LinkedList<>();
            q.add(nextIdx);

            while(!q.isEmpty()){
                int cur = q.poll();
                visited[cur] = true;

                for(int next : nodes[cur]){
                    if(visited[next]) continue;
                    if(q.contains(next)) continue;
                    q.add(next);
                }
            }

            int[] check = checkAllVisit();
            if(check[0] == 1) break;
            nextIdx = check[1];
        }
        System.out.println(ans);
    }

    private static int[] checkAllVisit() {
        for (int i = 1; i <= N; i++) {
            if(!visited[i]) return new int[]{0, i}; // 0: 아직 모두 방문하지 않았음, i : 다음에 방문할 노드 번호
        }
        return new int[]{1,0}; // 1: 모든 노드 방문 완료
    }
}