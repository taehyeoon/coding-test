package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-04-30 03:03
종료 시간 : 24-04-30 03:15
실행 시간 : 316ms / 실패
메 모 리 : 36252KB
*/

public class BOJ_3066_브리징시그널_G2 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int[] ports;

    private static int lowerBound(int t, List<Integer> arr){

        int lo = -1, hi = arr.size()-1;
        while (lo+1 < hi){

            int mid = (lo+hi)/2;
            if(arr.get(mid) < t){
                lo = mid;
            }else{
                hi = mid;
            }

        }

        return hi;
    }
    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < TC; tc++) {

            // input
            N = Integer.parseInt(br.readLine());
            ports = new int[N];
            for (int i = 0; i < N; i++) {
                ports[i] = Integer.parseInt(br.readLine());
            }

            // logic
            ArrayList<Integer> lis = new ArrayList<>();
            lis.add(ports[0]);

            for (int i = 1; i < N; i++) {
                if(lis.get(lis.size()-1) < ports[i]){
                    lis.add(ports[i]);
                }else{
                    int idx = lowerBound(ports[i], lis);
                    lis.set(idx, ports[i]);
                }
            }
            sb.append(lis.size()).append("\n");
        }

        System.out.println(sb);
    }
}