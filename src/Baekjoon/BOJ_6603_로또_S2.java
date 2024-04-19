package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-04-19 23:46
종료 시간 : 24-04-20 00:25
실행 시간 : 84ms / 실패
메 모 리 : 13376KB
*/

public class BOJ_6603_로또_S2 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int[] data;
    static boolean[] isSelected;

    private static void dfs(int cnt, int idx){

        if(cnt == 6){
            for (int i = 0; i < n; i++) {
                if(isSelected[i]) sb.append(data[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = idx; i < n; i++) {
            if(isSelected[i]) continue;

            isSelected[i] = true;
            dfs(cnt+1, i);
            isSelected[i] = false;
        }

    }
    public static void main(String[] args) throws IOException {

        String line = br.readLine();

        while(!line.equals("0")){
            st = new StringTokenizer(line);

            n = Integer.parseInt(st.nextToken());
            data = new int[n];
            isSelected = new boolean[n];
            for (int i = 0; i < n; i++) {
                data[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(data);

            dfs(0, 0);

            sb.append("\n");

            line = br.readLine();
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(sb.toString());
        bw.close();
    }
}