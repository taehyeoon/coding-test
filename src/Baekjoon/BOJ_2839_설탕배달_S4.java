package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

/*
시작 시간 : 24-02-13 19:23
종료 시간 : 24-02-13 19:30
실행시간 : 76ms
메 모 리 : 11500KB

고려사항
N이 15이상인 경우 5kg의 설탕봉지를 가져가는 것으로 계산하며,
N이 15미만으로 남은 경우 3의 배수라면 모두 3kg의 설탕봉지로 가져갑니다
만약 N의 값이 3미만인 경우에 -1을 출력합니다.
*/

public class BOJ_2839_설탕배달_S4 {

    static int N;
    public static void main(String[] args) throws IOException {

        System.setIn(Files.newInputStream(Paths.get("input.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int ans = 0;
        while(N >= 3){
            if(N < 15 && N % 3 == 0){
                ans += N / 3;
                N = 0;
                break;
            }
            ans++;
            N -= 5;
        }

        if(N != 0) System.out.println(-1);
        else System.out.println(ans);
    }
}
