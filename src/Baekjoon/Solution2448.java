package Baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/*
백준 별찍기11 2448 G4
시작 시간 : 24-01-26 22:20
종료 시간 : 24-01-26 23:20
실행시간 : 528ms

고려사항
처음에는 위에서부터 아래까지 한번에 그리려고 했지만, 불가능하다는 것을 꺠닫고
2차원 배열에 그릴 별의 좌표정보를 저장하고,
StringBuilder를 이용해 한번에 출력하였습니다.

삼각형들이 어떤 기준으로 배치되어있는가를 먼저 생각했습니다.
삼각형의 아래 중심을 기준으로 상,좌,우 방향에 삼각형을 그리면 되고,
재귀적으로 메소드를 호출하여 k==0인 순간에 기본 삼각형을 그리도록 구현하였습니다.

*/

public class Solution2448 {

    static boolean[][] map;
    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine()) / 3;
        int k = 0;
        while(N != 1){
            k++;
            N /= 2;
        }

        if(k == 0){
            sb.append("  *  \n");
            sb.append(" * * \n");
            sb.append("*****\n");
            System.out.println(sb);
            return;
        }

        int totalWidth = 6*(int)Math.pow(2,k)-1;
        int totalHeight = 3*(int)Math.pow(2,k);

        map = new boolean[totalHeight][totalWidth];
        star(k, 3*(int)Math.pow(2,k)-2, 6*(int)Math.pow(2,k-1)-1);
        sb = new StringBuilder(totalWidth*totalHeight);

        for (int i = 0; i < totalHeight; i++) {
            for (int j = 0; j < totalWidth; j++) {
                if(map[i][j]) sb.append("*");
                else sb.append(" ");
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    private static void star(int k, int ii, int jj) {

        if(k == 0){
            map[ii-1][jj] = true;
            map[ii][jj-1] = true; map[ii][jj+1] = true;
            for (int dj = -2; dj <= 2; dj++) {
                map[ii+1][jj+dj] = true;
            }
            return;
        }

        int dj = 3*(int)Math.pow(2,k-1);
        star(k-1, ii-dj, jj);
        star(k-1, ii, jj-dj);
        star(k-1, ii, jj+dj);
    }

}