package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-04-15 15:00
종료 시간 : 24-04-15 20:22
실행 시간 : 128ms
메 모 리 : 17456KB
 */

public class BOJ_2632_피자판매_G2 {

    static int Want, ASize, BSize;
    static int[] A, B;
    static int totalSumA, totalSumB;

    private static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Want = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        ASize = Integer.parseInt(st.nextToken());
        BSize = Integer.parseInt(st.nextToken());

        A = new int[2*ASize-1];
        B = new int[2*BSize-1];

        for(int i = 0; i < ASize; i++) {
            A[i] = Integer.parseInt(br.readLine());
            totalSumA += A[i];
        }
        int idx = 0;
        for (int i = ASize; i < 2*ASize-1; i++) {
            A[i] = A[idx++];
        }

        for(int i = 0; i < BSize; i++) {
            B[i] = Integer.parseInt(br.readLine());
            totalSumB += B[i];
        }
        idx = 0;
        for (int i = BSize; i < 2*BSize-1; i++) {
            B[i] = B[idx++];
        }
    }

    public static void main(String[] args) throws IOException {

        input();

        int[] freqA = new int[Want+1];
        int[] freqB = new int[Want+1];

        for (int i = 0; i < ASize; i++) {
            int sum = A[i];
            for (int j = i+1; j < i+ASize; j++) {
                if(sum > Want) break;
                freqA[sum]++;
                sum += A[j];
            }
        }
        if(totalSumA <= Want)
            freqA[totalSumA]++;

        for (int i = 0; i < BSize; i++) {
            int sum = B[i];
            for (int j = i+1; j < i+BSize; j++) {
                if(sum > Want) break;
                freqB[sum]++;
                sum += B[j];
            }
        }
        if(totalSumB <= Want)
            freqB[totalSumB]++;

        int result = 0;
        for (int i = 1; i < Want; i++) {
            result += freqA[i] * freqB[Want-i];
        }
        result += freqA[Want];
        result += freqB[Want];

        System.out.println(result);
    }
}