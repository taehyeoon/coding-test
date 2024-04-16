package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-04-17 00:10
종료 시간 : 24-04-17 00:35
실행 시간 : 520ms
메 모 리 : 138300KB
*/

public class BOJ_21943_연산최대로_G2 {

    static int N, P, Q;
    static int[] numbers;
    static ArrayList<boolean[]> operators;

    private static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        numbers = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        P = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
    }

    static boolean[] isSelected;
    private static void combiMulPos(int cnt, int start){
        if(cnt == Q){
            boolean[] temp = Arrays.copyOf(isSelected, N-1);
            operators.add(temp);
            return;
        }

        for (int i = start; i < N-1; i++) {
            if(isSelected[i]) continue;
            isSelected[i] = true;
            combiMulPos(cnt+1, i);
            isSelected[i] = false;
        }
    }
    
    private static int calc(){
        
        int maxResult = 0;
        for(boolean[] ops : operators){

            int sum = data[0];
            List<Integer> mulList = new ArrayList<>();

            for (int i = 0; i < N-1; i++) {
                int num = data[i+1];
                boolean op = ops[i];
                
                // 곱하기 
                if(op){
                    mulList.add(sum);
                    sum = num;
                }else{
                    sum += num;
                }
            }
            mulList.add(sum);

            int result = 1; 
            for(int a : mulList) result *= a;
            maxResult = Math.max(maxResult, result);
            
        }
        
        return maxResult;
    }

    static int[] data;
    static int ans;
    private static void per(int cnt){

        if(cnt == N){
            int result = calc();
            ans = Math.max(ans, result);
            return;
        }

        for (int i = 0; i < N; i++) {
            if(isSelected[i]) continue;

            isSelected[i] = true;
            data[cnt] = numbers[i];
            per(cnt+1);
            isSelected[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {

        input();

        // int[] 의 길이 N-1, 곱하기의 위치 지정
        operators = new ArrayList<>();
        isSelected = new boolean[N-1];
        combiMulPos(0, 0);

        data = new int[N];
        isSelected = new boolean[N];
        per(0);

        System.out.println(ans);
    }
}