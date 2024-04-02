package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-04-01 22:15
종료 시간 : 24-04-01
실행 시간 : ms
메 모 리 : KB
*/

public class BOJ_2473_세용액_G3 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static long minVal = Long.MAX_VALUE;
    static List<Long> originData;
    static long[] res;

    private static boolean findZero(int idx){

        List<Long> data = new ArrayList<>(originData);
        long save = data.remove(idx);

        int l = 0;
        int r = N-2;
        while (l<r){
            long val = data.get(l) + data.get(r) + save;

            if(Math.abs(val) < minVal){
                minVal = Math.abs(val);
                res = new long[]{data.get(l), data.get(r), save};
            }

            if(val > 0) r--;
            else if(val < 0) l++;
            else{
                res = new long[]{data.get(l), data.get(r), save};
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        originData = new ArrayList<>(N);
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            originData.add(Long.parseLong(st.nextToken()));
        }

        Collections.sort(originData);

        if(N == 3){
            System.out.printf("%d %d %d", originData.get(0), originData.get(1), originData.get(2));
            return;
        }

        for (int i = 0; i < N; i++) {
            if(findZero(i)) break;
        }


        Arrays.sort(res);
        System.out.printf("%d %d %d", res[0], res[1], res[2]);


    }
}