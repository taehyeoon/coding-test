package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.StringTokenizer;

/*
시작 시간 : 24-02-09 20:00
종료 시간 : 24-02-09 20:30
실행시간 : 76ms
메 모 리 : 11508KB

고려사항
끝자리의 0의 개수가 의미하는 것은 2와 5의 개수가 몇개인지에 따라 달라집니다
문제에서 팩토리얼을 계산할 때 마지막자리에 처음 0이 등장하는 순간은 5!입니다
5!이후로는 곱하는 수에 5가 포함되는 횟수만큼 0의 개수가 늘어나게됩니다
따라서 구간 내에 존재하는 5의 개수와 0의 개수가 같습니다
*/

public class BOJ_1676_팩토리얼0의개수_S5 {

    static int N;

    private static void input() throws IOException {
        System.setIn(Files.newInputStream(Paths.get("input.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
    }

    private static int solve() {
        if(N < 5) return 0;
        int ans = 0;
        for(int i = N; i >= 5; i--){
            int val = i;
            while(val % 5 == 0){
                ans++;
                val /= 5;
            }
        }
        return ans;
    }


    public static void main(String[] args) throws IOException {

        input();
        System.out.println(solve());
    }
}
