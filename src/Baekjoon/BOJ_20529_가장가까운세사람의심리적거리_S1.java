package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-04-14 11:05
종료 시간 : 24-04-14 11:34
실행 시간 : 508ms
메 모 리 : 51572KB
*/

public class BOJ_20529_가장가까운세사람의심리적거리_S1 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static boolean[] selected;
    static int distinctN, ans;
    static List<String> distinctList;

    private static int calc(String[] d){

        int value = 0;

        for (int i = 0; i < 4; i++) {

            if(d[0].charAt(i) != d[1].charAt(i)) value++;
            if(d[1].charAt(i) != d[2].charAt(i)) value++;
            if(d[2].charAt(i) != d[0].charAt(i)) value++;
        }

        return value;
    }

    private static void combi(int cnt, int start){

        if(cnt == 3){
            String[] data = new String[3];
            int idx = 0;
            for (int i = 0; i < distinctN; i++) {
                if(selected[i]) data[idx++] = distinctList.get(i);
            }
            ans = Math.min(ans, calc(data));
            return;
        }


        for (int i = start; i < distinctN; i++) {
            if(selected[i]) continue;

            selected[i] = true;
            combi(cnt+1, i+1);
            selected[i] = false;
        }

    }
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < TC; tc++) {
            ans = Integer.MAX_VALUE;
            int N = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();
            Set<String> set = new HashSet<>();
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                String mbti = st.nextToken();
                map.put(mbti, map.getOrDefault(mbti, 0)+1);
            }

            distinctList = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                int itemCnt = Math.min(entry.getValue(), 3);

                for (int i = 0; i < itemCnt; i++) {
                    distinctList.add(entry.getKey());
                }
            }
            distinctN = distinctList.size();
            selected = new boolean[distinctN];
            combi(0,0);

            if(distinctN == 1) ans = 0;
            sb.append(ans).append("\n");
        }

        System.out.println(sb);
    }
}