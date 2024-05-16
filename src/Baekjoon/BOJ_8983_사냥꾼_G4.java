package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-05-17 00:35
종료 시간 : 24-05-17 02:22
실행 시간 : 648ms / 실패
메 모 리 : 63532KB
*/

public class BOJ_8983_사냥꾼_G4 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int M, N, L;
    static int[] shotPoses;
    static long[][] animals;

    private static void input() throws IOException{
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        shotPoses = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            shotPoses[i] = Integer.parseInt(st.nextToken());
        }

        animals = new long[N][];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            animals[i] = new long[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }
    }

    public static void main(String[] args) throws IOException {

        input();

        Arrays.sort(shotPoses);

        int ans = 0;
        for (int i = 0; i < N; i++) {

            int lo = 0, hi = M-1;
            boolean ahead = false;
            while (lo + 1 < hi){

                int mid = (lo + hi) / 2;

                if(animals[i][0] < shotPoses[mid]){
                    hi = mid;
                }else if(animals[i][0] > shotPoses[mid]){
                    lo = mid;
                }else{
                    if(animals[i][1] <= L) ahead = true;
                    break;
                }
            }

            if(ahead){
                ans++;
            }else{
                long len = Math.min(Math.abs(animals[i][0] - shotPoses[lo]), Math.abs(animals[i][0] - shotPoses[hi])) + animals[i][1];
                if(len <= L){
                    ans++;
                }
            }
        }

        System.out.println(ans);
    }
}