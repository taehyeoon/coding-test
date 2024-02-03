package Baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
시작 시간 : 24-02-03 12:35
종료 시간 : 24-02-03 14:00
실행 시간 : 332ms / 실패
메 모 리 : 12136KB

고려사항
dfs를 사용해서 이동가능한 모든 경로를 탐색하는 문제였습니다
모든 도시를 방문하고나서 다시 출발점으로 돌아올 수 있는지 확인해야하기 때문에
재귀에 시작지점을 항상 넘겨주어야합니다.
depth를 통해 모든 도시를 방문했는지 체크하고 cost를 이용하여, 현재 도시까지
소요된 비용을 저장합니다.
출발점이 명시되어있지 않기 때문에 모든 도시에서 출발하는 경우를 고려해야합니다
dfs를 생각한대로 얼마나 구체적으로 구현할 수 있는지가 관건이었습니다.
*/

public class BOJ_10971_외판원순회2_S2 {

    static int N, ans = Integer.MAX_VALUE;
    static int[][] edge;
    static boolean[] isVisited;
    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        edge = new int[N][N];
        isVisited = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                edge[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            Arrays.fill(isVisited, false);
            isVisited[i] = true;
            dfs(i, i,0,0);
        }

        System.out.println(ans);
    }

    private static void dfs(int start, int now, int depth, int cost) {

        if(depth == N-1){
            if(edge[now][start] != 0){
                ans = Math.min(ans, cost+edge[now][start]);
            }
            return;
        }

        for(int i = 0; i < N; i++){
            if(edge[now][i] != 0 && !isVisited[i]){

                isVisited[i] = true;
                dfs(start, i, depth+1, cost + edge[now][i]);
                isVisited[i] = false;
            }
        }
    }
}