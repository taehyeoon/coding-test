package Baekjoon;

import java.io.*;

/*
시작 시간 : 24-03-27 23:30
종료 시간 : 24-03-27 00:30
실행 시간 : 388ms
메 모 리 : 13968KB
*/

public class BOJ_2239_스도쿠_G4 {

    static int[] map;
    static boolean[][] Row, Col, Square;

    private static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Row = new boolean[10][10];
        Col = new boolean[10][10];
        Square = new boolean[10][10];

        map = new int[81];
        int idx = 0;
        for (int i = 0; i < 9; i++) {
            String str = br.readLine();
            for (int j = 0; j < 9; j++) {
                int val = str.charAt(j) - '0';
                map[idx++] = val;

                if(val!=0){
                    Row[i][val] = true;
                    Col[j][val] = true;
                    Square[3*(i/3)+(j/3)][val] = true;
                }
            }
        }
    }

    private static boolean isValid(int idx, int x){
        int r = idx / 9;
        int c = idx % 9;
        int sq = 3*(r/3)+(c/3);

        if(Row[r][x] || Col[c][x] || Square[sq][x]) return false;
        return true;
    }

    private static void check(int idx, int x, boolean flag){
        int r = idx / 9;
        int c = idx % 9;
        int sq = 3*(r/3)+(c/3);

        Row[r][x] = flag;
        Col[c][x] = flag;
        Square[sq][x] = flag;
    }
    private static boolean dfs(int cur){

        while(cur < 81 && map[cur] != 0) cur++;
        if(cur == 81) return true;

        for (int i = 1; i <= 9; i++) {
            if(!isValid(cur, i)) continue;
            map[cur] = i;
            check(cur, i, true);
            if(dfs(cur+1)) {
                return true;
            }else{
                check(cur, i, false);
            }
        }
        map[cur] = 0;
        return false;
    }
    public static void main(String[] args) throws IOException {

        input();

        dfs(0);

        int idx = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(map[idx++]);
            }
            System.out.println();
        }
    }
}