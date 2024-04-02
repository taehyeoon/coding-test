package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-04-01 21:45
종료 시간 : 24-04-01 22:05
실행 시간 : 216ms
메 모 리 : 29592KB
*/

public class BOJ_1253_좋다_G4 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static List<Integer> originData;

    private static void input() throws IOException{
        N = Integer.parseInt(br.readLine());
        originData = new ArrayList<>(N);
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            originData.add(Integer.parseInt(st.nextToken()));
        }
    }

    private static boolean isGood(int idx){
        List<Integer> data = new ArrayList<>(originData);
        int target = data.remove(idx);
        int l = 0, r = N-2;
        while (l+1 < r){

            if(data.get(l) + data.get(r) < target) l++;
            else if(data.get(l) + data.get(r) > target) r--;
            else return true;
        }

        return data.get(l) + data.get(r) == target;
    }
    public static void main(String[] args) throws IOException {

        input();

        Collections.sort(originData);
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if(isGood(i)) cnt++;
        }
        System.out.println(cnt);
    }
}