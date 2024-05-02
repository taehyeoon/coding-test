package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-05-02 16:00
종료 시간 : 24-05-03 00:13
실행 시간 : 536ms / 실패
메 모 리 : 40880KB
*/

public class BOJ_2412_암벽등반_G4 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, T;
    static List<Integer>[] holds = new List[200_001];

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= 200_000; i++) {
            holds[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            holds[y].add(x);
        }

        for (int i = 0; i <= 200_000; i++) {
            Collections.sort(holds[i]);
        }

        int move = 0;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});

        while (!q.isEmpty()) {
            move++;
            int qSize = q.size();

            for (int iter = 0; iter < qSize; iter++) {

                int[] cur = q.poll();
                int cx = cur[0], cy = cur[1];

                for (int dy = -2; dy <= 2; dy++) {
                    int ny = cy+dy;
                    if(ny < 0 || ny > 200_000) continue;
                    for (int i = 0; i < holds[ny].size(); i++) {
                        int nx = holds[ny].get(i);

                        if(cx+2 < nx) break;
                        else if(cx-2 > nx) continue;

                        if(ny == T){
                            System.out.println(move);
                            return;
                        }
                        holds[ny].remove(i);
                        q.add(new int[]{nx, ny});
                        i--;
                    }

                }
            }

        }

        System.out.println(-1);
    }
}