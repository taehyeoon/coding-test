package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-02-18 01:35
종료 시간 : 24-02-18 12:35
실행 시간 : 512ms / 실패
메 모 리 : 127524KB

고려사항
3차원 check배열을 통해서 벽을 부수고 이동했을 때의 최단거리와
부수지않고 이동했을 때의 최단거리를 구하는 문제였습니다
check 배열에는 출발지점부터 해당 칸까지 이동한 거리를 저장하고 있습니다
*/

public class BOJ_2206_벽부수고이동하기_G3 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int H, W;
    static int[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        map = new int[H][W];

        for (int i = 0; i < H; i++) {
            String line = br.readLine();
            for (int j = 0; j < W; j++) {
                map[i][j] = line.charAt(j)-'0';
            }
        }
    }

    private static int solve(){
        if(H == 1 && W == 1) {
            return 1;
        }

        // BFS
        int[][][] check = new int[2][H][W];
        // [0, n, m] : 벽 안부수고 지나가는 방문노드 경로
        // [1, n, m] : 벽 부수고 지나가는 방문노드 경로

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0,0});
        check[0][0][0] = 1; // 시작칸에서는 벽을 안부쉈으니까 {"0", 0, 0}에 1 저장

        while (true) {
            int[] node = q.poll();
            int w = node[0];
            int ci = node[1];
            int cj = node[2];

            for (int i = 0; i < 4; i++) {
                int ni = ci + dx[i];
                int nj = cj + dy[i];

                if(ni < 0 || nj < 0 || ni >= H || nj >= W) continue;

                // 다음 칸이 벽이 아닌 경우
                if(map[ni][nj] == 0){
                    if(check[w][ni][nj] == 0){ // check 값이 0이라는 의미 = 아직 방문한적이 없다는 의미
                        // 아직 방문 안한 노드이기 때문에 w가 1이든 0이든 상관없이 전진
                        check[w][ni][nj] = check[w][ci][cj]+1;
                        q.offer(new int[]{w, ni, nj});

                        if(ni == H-1 && nj == W-1) return check[w][ni][nj];
                    }
                }else{ // 다음칸이 벽인 경우
                    if(w == 0){ // 이전까지 벽을 부순 적이 없는 경우
                        if(check[1][ni][nj] == 0){ // ni,nj노드를 방문한 적이 없는 경우
                            q.offer(new int[]{1,ni, nj});
                            check[1][ni][nj] = check[0][ci][cj] + 1;
                            if(ni == H-1 && nj == W-1) return check[1][ni][nj];
                        }
                    }
                }
            }
            if(q.isEmpty()) return -1;
        }


    }
    public static void main(String[] args) throws IOException {

        input();
        bw.write(solve() + "");
        bw.close();
        br.close();
    }
}
