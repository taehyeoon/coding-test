package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
시작 시간 : 24-04-09 20:54
종료 시간 : 24-04-09 21:11
실행 시간 : 160ms / 실패
메 모 리 : 18624KB
*/

public class BOJ_10026_모노미노도미노2_G2 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static boolean[][] map = new boolean[11][11];
    static int score;

    private static void place(int t, int x, int y){
        switch (t){
            case 1:
                for (int i = 6; i <= 10; i++) {
                    if (map[i][y]) {
                        map[i-1][y] = true;
                        break;
                    }
                }
                for (int j = 6; j <= 10; j++) {
                    if (map[x][j]) {
                        map[x][j-1] = true;
                        break;
                    }
                }
                break;

            case 2:
                for (int i = 6; i <= 10; i++) {
                    if (map[i][y] || map[i][y+1]) {
                        map[i-1][y] = true;
                        map[i-1][y+1] = true;
                        break;
                    }
                }
                for (int j = 6; j <= 10; j++) {
                    if (map[x][j]) {
                        map[x][j-1] = true;
                        map[x][j-2] = true;
                        break;
                    }
                }
                break;

            case 3:
                for (int i = 6; i <= 10; i++) {
                    if (map[i][y]) {
                        map[i-1][y] = true;
                        map[i-2][y] = true;
                        break;
                    }
                }
                for (int j = 6; j <= 10; j++) {
                    if (map[x][j] || map[x+1][j]) {
                        map[x][j-1] = true;
                        map[x+1][j-1] = true;
                        break;
                    }
                }
                break;
        }
    }

    private static void eraseLine(){
        int cnt = 4;
        int row = 9, col = 9;

        while (cnt-- > 0) {
            if (map[row][0] && map[row][1] && map[row][2] && map[row][3]) {
                score++;
                for (int i = row; i > 3; i--) {
                    for (int j = 0; j < 4; j++) {
                        map[i][j] = map[i-1][j];
                    }
                }
                row++;
            }

            if (map[0][col] && map[1][col] && map[2][col] && map[3][col]) {
                score++;
                for (int j = col; j > 3; j--) {
                    for (int i = 0; i < 4; i++) {
                        map[i][j] = map[i][j-1];
                    }
                }
                col++;
            }
            row--;
            col--;
        }
    }
    private static void push(){
        int greenPush = 0, bluePush = 0;
        for (int i = 4; i < 6; i++) {
            if (map[i][0] || map[i][1] || map[i][2] || map[i][3]) greenPush++;
            if (map[0][i] || map[1][i] || map[2][i] || map[3][i]) bluePush++;
        }

        while (greenPush-- > 0) {
            for (int i = 9; i > 3; i--) {
                for (int j = 0; j < 4; j++) {
                    map[i][j] = map[i-1][j];
                }
            }
        }
        while (bluePush-- > 0) {
            for (int j = 9; j > 3; j--) {
                for (int i = 0; i < 4; i++) {
                    map[i][j] = map[i][j-1];
                }
            }
        }
    }

    private static int count(){
        int ret = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (map[i][j]) ret++;
            }
        }
        return ret;
    }

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < 10; i++) {
            map[10][i] = true;
            map[i][10] = true;
        }

        while (N-- > 0){
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            place(t, x, y);
            eraseLine();
            push();
        }

        System.out.println(score);
        System.out.println(count());
    }
}