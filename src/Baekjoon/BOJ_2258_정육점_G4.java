package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-04-21 16:30
종료 시간 : 24-04-21
실행 시간 : 668ms / 실패
메 모 리 : 47640KB
*/

public class BOJ_2258_정육점_G4 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, Want, total;
    static int[][] data; // [무게][가격]

    private static void input() throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Want = Integer.parseInt(st.nextToken());

        data = new int[N][];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            total += w;
            data[i] = new int[]{w, c};
        }

    }

    public static void main(String[] args) throws IOException {

        input();

        if(total < Want) {
            System.out.println(-1);
            return;
        }
        
        // 정렬 우선순위 가격 arc, 무게 desc
        Arrays.sort(data, ((o1, o2) -> {
            if(o1[1] == o2[1]) return o2[0] - o1[0];
            else return o1[1] - o2[1];
        }));

        int prevPrice = 0;
        int weightSum = 0;
        int priceSum = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {

            weightSum += data[i][0];

            if(prevPrice != data[i][1]){
                priceSum = prevPrice = data[i][1];
            }else{
                priceSum += data[i][1];
            }

            if(weightSum >= Want){
                min = Math.min(min, priceSum);
            }
        }

        System.out.println(min);
    }
}