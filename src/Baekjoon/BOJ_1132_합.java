package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
시작 시간 : 24-0
종료 시간 : 24-0
실행 시간 : ms
메 모 리 : KB
*/

public class BOJ_1132_합 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static String[] input;

    static class Data implements Comparable<Data>{

        boolean isFirst;
        long cnt;

        public Data(long cnt) {
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Data o) {
            return Long.compare(cnt, o.cnt);
        }

        @Override
        public String toString() {
            return "Data{" +
                "isFirst=" + isFirst +
                ", cnt=" + cnt +
                '}';
        }
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        input = new String[N];
        for (int i = 0; i < N; i++) {
            input[i] = br.readLine();
        }
        Data[] freqs = new Data[10];
        for (int i = 0; i < 10; i++) {
            freqs[i] = new Data(0);
        }

        for (int i = 0; i < N; i++) {
            long val = 1;
            String str = input[i];
            for (int j = str.length()-1; j >= 0; j--) {
                char c = str.charAt(j);
                freqs[c-'A'].cnt += val;
                if(j == 0) freqs[c-'A'].isFirst = true;
                val *= 10;
            }
        }

        Arrays.sort(freqs);
        boolean[] isUsed = new boolean[10];

        long ans = 0;
        for (int i = 0; i < 10; i++) {
            if(freqs[i].isFirst){
                for (int j = 1; j < 10; j++) {
                    if(isUsed[j]) continue;
                    isUsed[j] = true;
                    ans += (long)j * freqs[i].cnt;
                    break;
                }
            }else{
                for (int j = 0; j < 10; j++) {
                    if(isUsed[j]) continue;
                    isUsed[j] = true;
                    ans += (long)j * freqs[i].cnt;
                    break;
                }
            }
        }

        System.out.println(ans);
    }
}