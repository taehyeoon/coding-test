package SsafyGit;

//광부 게임 Lv5

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution2034 {

    static int[][] mat;
    static int cur_i, cur_j;
    static int result = 0;
    public static void main(String[] args) throws FileNotFoundException {

        System.setIn(new FileInputStream("input.txt"));

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        mat = new int[n + 2][n + 2];

        // 가장자리 0으로 초기화
        for(int iter = 0; iter < n + 2; iter++){
            mat[0][iter] = 0;
            mat[n+1][iter] = 0;
            mat[iter][0] = 0;
            mat[iter][n+1] = 0;
        }

        // 맵에 값 입력
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int rock = sc.nextInt();
                if(rock == 0){
                    cur_i = i;
                    cur_j = j;
                }
                mat[i][j] = rock;
            }
        }

        int cmdNum = sc.nextInt();

        for(int i = 0; i < cmdNum; i++) {
            char cmd = sc.next().charAt(0);
            move(cmd);
        }

        System.out.printf("광부 위 : (%d,%d)\n부순 암석 개수 : %d", cur_i, cur_j, result);
    }

    private static void move(char cmd) {
        int next_i = cur_i;
        int next_j = cur_j;

        // 폭탄일 경우
        if(cmd == 'X'){
            if(mat[cur_i - 1][cur_j - 1] != 0){
                result++;
                mat[cur_i - 1][cur_j - 1] = 0;
            }
            if(mat[cur_i - 1][cur_j] != 0){
                result++;
                mat[cur_i - 1][cur_j] = 0;
            }
            if(mat[cur_i - 1][cur_j + 1] != 0){
                result++;
                mat[cur_i - 1][cur_j + 1] = 0;
            }


            if(mat[cur_i][cur_j - 1] != 0){
                result++;
                mat[cur_i][cur_j - 1] = 0;
            }
            if(mat[cur_i][cur_j + 1] != 0){
                result++;
                mat[cur_i][cur_j + 1] = 0;
            }

            if(mat[cur_i + 1][cur_j - 1] != 0){
                result++;
                mat[cur_i + 1][cur_j - 1] = 0;
            }
            if(mat[cur_i + 1][cur_j] != 0){
                result++;
                mat[cur_i + 1][cur_j] = 0;
            }
            if(mat[cur_i + 1][cur_j + 1] != 0){
                result++;
                mat[cur_i + 1][cur_j + 1] = 0;
            }
            return;
        }

        switch (cmd){
            case 'U':
                next_i--;
                break;
            case 'D':
                next_i++;
                break;
            case 'L':
                next_j--;
                break;
            case 'R':
                next_j++;
                break;
            default:
                break;
        }

        if(mat[next_i][next_j] > 0){
            // 블록이 1일 때만 암석을 부순 것으로 카운트
            if(mat[next_i][next_j] == 1) result++;
            mat[next_i][next_j]--;
        }

        // 다음 칸으로 이동
        if(mat[next_i][next_j] == 0){
            cur_i = next_i;
            cur_j = next_j;
        }
    }
}
