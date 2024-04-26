package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-04-27 00:55
종료 시간 : 24-04-27 00:58
실행 시간 : 528ms
메 모 리 : 63672KB
*/

public class BOJ_17219_비밀번호찾기_S4 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, String> data = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String addr = st.nextToken();
            String pw = st.nextToken();
            data.put(addr, pw);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String find = br.readLine();
            sb.append(data.get(find)).append("\n");
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.close();
    }
}