package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
시작 시간 : 24-0
종료 시간 : 24-0
실행 시간 : ms
메 모 리 : KB
*/

public class BOJ_26154_한양가왕_G2 {

    static class Data {
        int[] arr;
        int hashCode;

        @Override
        public boolean equals(Object obj) {
            Data o = (Data) obj;
            return this.hashCode == o.hashCode;
        }

        public Data(int[] arr) {
            this.arr = arr;

            int sum = 0;
            for (int i = 0; i < 2*N; i++) {
                sum += i * arr[i];
            }
            this.hashCode = sum;
        }

        @Override
        public int hashCode() {
            return this.hashCode;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;
    static int[] inputData;
    private static void ordering(int[] arr){
        for (int i = 0; i < N; i++) {
            if(arr[2*i] > arr[2*i+1]){
                int temp = arr[2*i];
                arr[2*i] = arr[2*i+1];
                arr[2*i+1] = temp;
            }
        }
    }

    private static void input() throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        inputData = new int[2*N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            inputData[2 * i] = Integer.parseInt(st.nextToken());
            inputData[2 * i+1] = Integer.parseInt(st.nextToken());
        }
    }

    private static int[] executeRound(int[] arr){

        int toEndValue = Math.min(arr[0], arr[1]);

        int swapIdx = arr[0] == toEndValue ? 0 : 1;
        for (int i = 1; i < N; i++) {
            int swapValue = Math.max(arr[2*i], arr[2*i+1]);
            arr[swapIdx] = swapValue;
            swapIdx = arr[2*i] == swapValue ? 2*i : 2*i+1;
        }

        arr[swapIdx] = toEndValue;

        ordering(arr);

        return Arrays.copyOf(arr, 2*N);
    }
    public static void main(String[] args) throws IOException {
        Map<Data, Integer> map = new HashMap<>();

        input();

        int iter = 0, aIdx = 0, rIdx = 0;
        ordering(inputData);
        int[] next = inputData;

        if(M <= N) iter = M;
        else iter = N + (M % N);

        while (iter > 0){
            iter--;

            next = executeRound(next);

//            if(map.containsKey(new Data(next))){
//                aIdx = map.get(new Data(next));
//                rIdx = iter;
//                break;
//            }else{
//                map.put(new Data(next), iter);
//            }

        }

        for (int i = 0; i < N; i++) {
            System.out.println(next[2*i] + " " + next[2*i+1]);
        }
//
//        if(iter == M) {
//            for (int i = 0; i < N; i++) {
//                System.out.println(next[2*i] + " " + next[2*i+1]);
//            }
//        }else{
//            M -= aIdx;
//            int mod = M % (rIdx - aIdx);
//
////            System.out.println("mod = " + mod);
//            int findIdx = 0;
//            if(mod == 0){
//                findIdx = rIdx-1;
//            }else{
//                findIdx = aIdx + mod - 1;
//            }
//
////            System.out.println("findIdx = " + findIdx);
//            for (Map.Entry<Data, Integer> entry : map.entrySet()) {
//                if (entry.getValue() == findIdx) {
//
//                    int[] ansArr = entry.getKey().arr;
//                    for (int i = 0; i < N; i++) {
//                        System.out.println(ansArr[2*i] + " " + ansArr[2*i+1]);
//                    }
//                    return;
//                }
//            }
//        }
    }
}