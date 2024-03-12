package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
시작 시간 : 24-03-12 18:30
종료 시간 : 24-03-12 19:00
실행 시간 : 248ms
메 모 리 : 20756KB
*/

public class BOJ_2116_주사위쌓기_G5 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, ans;
    static int[][] dice;
    static int[] opposite = new int[]{5, 3, 4, 1, 2, 0};

    static public void input() throws IOException{
        N = Integer.parseInt(br.readLine());
        dice = new int[N][6];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 6; j++) {
                dice[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void calcMax(int cnt, int sum, int up){

        if(cnt == N){
            ans = Math.max(ans, sum);
            return;
        }

        int bottomIdx = -1;
        for (int i = 0; i < 6; i++) {
            if(dice[cnt][i] == up) {
                bottomIdx = i;
                break;
            }
        }
        int topIdx = opposite[bottomIdx];

        int max = 0;
        for (int i = 0; i < 6; i++) {
            if(i == bottomIdx || i == topIdx) continue;
            max = Math.max(max, dice[cnt][i]);
        }

        calcMax(cnt+1, sum+max, dice[cnt][topIdx]);
    }
    public static void main(String[] args) throws IOException {

        input();
        for (int upIdx = 0; upIdx < 6; upIdx++) {
            for (int sideIdx = 0; sideIdx < 6; sideIdx++) {

                if(sideIdx == upIdx || sideIdx == opposite[upIdx]) continue;
                calcMax(1, dice[0][sideIdx], dice[0][upIdx]);

            }
        }

        System.out.println(ans);
    }
}