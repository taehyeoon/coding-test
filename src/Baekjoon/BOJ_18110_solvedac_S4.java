package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

/*
시작 시간 : 24-02-09 18:00
종료 시간 : 24-02-09 18:15
실행시간 : 336ms
메 모 리 : 37494KB

고려사항
점수 계산에서 제외되는 상위 15%, 하위 15%를 제외한 후 평균을 구하였습니다.
*/

public class BOJ_18110_solvedac_S4 {

    static int N;
    static int[] scores;

    private static void input() throws IOException {
        System.setIn(Files.newInputStream(Paths.get("input.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        scores = new int[N];
        for (int i = 0; i < N; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }
    }

    private static void print(){
        for (int a : scores) System.out.print(a + " ");
        System.out.println();
    }
    private static int solve() {
        Arrays.sort(scores);
        int outter = (int)Math.round((double)N * 0.15);
        double sum = 0;
        for(int i = outter; i < N-outter; i++){
            sum += scores[i];
        }
        return (int)Math.round(sum / (N - 2 * outter));
    }

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }
}