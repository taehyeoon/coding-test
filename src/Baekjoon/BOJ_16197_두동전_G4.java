package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-04-27 13:00
종료 시간 : 24-04-27 13:57
실행 시간 : 176ms
메 모 리 : 17108KB
*/

public class BOJ_16197_두동전_G4 {

    static class State {
        int[] c1, c2; // i, j, 1 or 0

        public State(int[] c1, int[] c2) {
            this.c1 = c1;
            this.c2 = c2;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int H, W;
    static boolean[][] map;
    static int[][] coins;
    static int[][] delta = {{-1,0}, {0,1}, {1,0}, {0,-1}};

    private static void input() throws IOException{
        st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        map = new boolean[H][W];
        coins = new int[2][];
        int coinIdx = 0;
        for (int i = 0; i < H; i++) {
            String str = br.readLine();
            for (int j = 0; j < W; j++) {
                char c = str.charAt(j);
                if(c == 'o'){
                    coins[coinIdx++] = new int[]{i, j};
                    map[i][j] = true;
                }else if(c == '.'){
                    map[i][j] = true;
                }
            }
        }
    }

    private static int[] moveCoin(int[] c, int dir){

        int ni = c[0] + delta[dir][0];
        int nj = c[1] + delta[dir][1];

        if(ni < 0 || nj < 0 || ni >= H || nj >= W){
            return new int[]{-1, -1, 0};
        }

        if(map[ni][nj]) return new int[]{ni, nj, 1};
        else return c;

    }
    public static void main(String[] args) throws IOException {

        input();

        Set<String> visited = new HashSet<>();
        visited.add(String.format("%d,%d,%d,%d", coins[0][0], coins[0][1], coins[1][0], coins[1][1]));


        Queue<State> q = new ArrayDeque<>();
        int[] c1 = new int[]{coins[0][0], coins[0][1], 1};
        int[] c2 = new int[]{coins[1][0], coins[1][1], 1};
        State initState = new State(c1, c2);
        q.offer(initState);

        for (int pushCnt = 1; pushCnt <= 10; pushCnt++) {

            int qSize = q.size();

            for (int iter = 0; iter < qSize; iter++) {

                State cur = q.poll();

                for (int i = 0; i < 4; i++) {
                    int[] n1 = moveCoin(cur.c1, i);
                    int[] n2 = moveCoin(cur.c2, i);

                    // 동전이 겹쳐짐
                    if(n1[0] == n2[0] && n1[1] == n2[1]) continue;

                    int fallResult = n1[2] + n2[2];

                    // 둘중에 하나만 떨어짐
                    if(fallResult == 1){
                        System.out.println(pushCnt);
                        return;
                    }

                    // 둘다 떨어짐
                    if(fallResult == 0) continue;
                    String visitStr = String.format("%d,%d,%d,%d", n1[0], n1[1], n2[0], n2[1]);
                    if(visited.contains(visitStr)) continue;

                    visited.add(visitStr);
                    q.offer(new State(n1, n2));
                }
            }
        }

        System.out.println(-1);
    }
}