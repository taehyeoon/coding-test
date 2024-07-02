package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
시작 시간 : 24-0
종료 시간 : 24-0
실행 시간 : ms
메 모 리 : KB
*/

public class BOJ_14466_소가길을건너간이유6_G3 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, K, R;
    static int[][] dirMap;
    static int[][] cowMap;
    static List<int[]> cowList = new ArrayList<>();

    static int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 상 우 하 좌

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        dirMap = new int[N][N]; // 0 0 0 0 <- 좌 하 우 상 모두 이동 가능
        cowMap = new int[N][N];

        int ai, aj, bi, bj;
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            ai = Integer.parseInt(st.nextToken()) - 1;
            aj = Integer.parseInt(st.nextToken()) - 1;
            bi = Integer.parseInt(st.nextToken()) - 1;
            bj = Integer.parseInt(st.nextToken()) - 1;

            for (int j = 0; j < 4; j++) {
                if (bi == ai + delta[j][0] && bj == aj + delta[j][1]) {
                    dirMap[ai][aj] |= 1 << j;
                    dirMap[bi][bj] |= 1 << (j+2) % 4;
                    break;
                }
            }
        }

        cowList.add(null); // 0번째 사용x
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            cowMap[x][y] = i + 1;
            cowList.add(new int[]{x,y});
        }

    }

    public static void main(String[] args) throws IOException {

        input();

        int meetCnt = 0;
        for (int i = 1; i < K + 1; i++) {

            int[] start = cowList.get(i);
            int curCowNum = i;
            Queue<int[]> q = new ArrayDeque<>();
            boolean[][] visited = new boolean[N][N];
            visited[start[0]][start[1]] = true;
            q.add(start);

            while (!q.isEmpty()) {

                int ci = q.peek()[0];
                int cj = q.peek()[1];
                q.poll();

                for (int j = 0; j < 4; j++) {
                    int ni = ci + delta[j][0];
                    int nj = cj + delta[j][1];

                    if(ni < 0 || nj < 0 || ni >= N || nj >= N) continue;
                    if(visited[ni][nj]) continue;
                    if((dirMap[ci][cj] & (1 << j)) != 0) continue; // 길이 있으면 안감

                    if(cowMap[ni][nj] > curCowNum){
                        meetCnt++;
                    }
                    visited[ni][nj] = true;
                    q.add(new int[]{ni, nj});
                }
            }
        }

        System.out.println((K*(K-1))/2 - meetCnt);
    }
}