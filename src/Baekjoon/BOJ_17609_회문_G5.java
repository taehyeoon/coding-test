package Baekjoon;

import java.io.*;

/*
시작 시간 : 24-05-20 20:43
종료 시간 : 24-05-20 21:14
실행 시간 : 228ms
메 모 리 : 43044KB
*/

public class BOJ_17609_회문_G5 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String str;

    private static int dfs(int l, int r, boolean extracted){
        if(l >= r){
            return extracted ? 1 : 0;
        }

        if(str.charAt(l) == str.charAt(r)) return dfs(l+1, r-1, extracted);

        // 이미 한번 문자를 제거한 경우
        if(extracted) return 2;

        int moveLeft = dfs(l, r-1, true);
        int moveRight = dfs(l+1, r, true);

        if(moveLeft == 1 || moveRight == 1) return 1;
        else return 2;
    }

    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            str = br.readLine();
            sb.append(dfs(0, str.length()-1, false)).append("\n");
        }

        System.out.println(sb);
    }

}
