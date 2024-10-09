package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-0
종료 시간 : 24-0
실행 시간 : ms
메 모 리 : KB
*/

public class BOJ_1332_풀자_G3 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, V;
    static int[] data;
    private static void input() throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        data = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }
    }
    public static void main(String[] args) throws IOException {
        input();

        if(N == 1){
            System.out.println(1);
            return;
        }
        int minIdx = 0, min = data[0];
        int maxIdx = 0, max = data[0];

        for (int i = 1; i < N; i++) {

            if(data[i] < min){
                min = data[i];
                minIdx = i;
            }

            if(data[i] > max){
                max = data[i];
                maxIdx = i;
            }

            if(max - min >= V) {
                break;
            }
        }

        if(max - min < V){
            System.out.println(N);
//            System.out.println("모든 문제 풀이");
            return;
        }

        // 최소흥미도, 최대흥미도의 인덱스를 작은인덱스와 큰인덱스로 구분
        int smallIdx = Math.min(minIdx, maxIdx), largeIdx = Math.max(minIdx, maxIdx);
        int lCnt = smallIdx, rCnt = largeIdx - smallIdx;
        // 0~작은 인덱스 까지의 최소문제풀이 수
        int leftAns = lCnt/2 + lCnt%2;
        // 작은 인덱스 ~ 최대인덱스 까지의 최소 문제 풀이 수
        int rightAns = rCnt/2 + rCnt%2;

        int ans = leftAns + rightAns + 1; // 1번 문제는 반드시 풀이하기 때문에 +1
        System.out.println(ans);
    }
}