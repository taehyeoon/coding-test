package Baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

/*
백준 색종이만들기 2630 S2
시작 시간 : 24-01-28 14:30
종료 시간 : 24-01-28 14:55
실행시간 : 280ms

고려사항
재귀를 활용하여 풀이
잘라진 색종이가 파란색 혹은 하얀색 정사각형 색종이가 아닌경우
4개의 작은 색종이에 대하여 재귀적으로 탐색

재귀의 탈출 조건
1. 색종이의 한 변의 길이가 1인 경우
2. 색종이의 모든 칸이 파란색 이거나 모든 칸이 하얀색인 경우
 */

public class Solution2630 {

    static int N, blue, white;
    static int[][] data;

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        data = new int[N][N];

        for (int i = 0; i < N; i++) {
            data[i] = Stream.of(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }

        calc(0, N, 0, N, N);

        System.out.println(white);
        System.out.print(blue);
    }

    private static void calc(int is, int ie, int js, int je, int num) {

        if(num == 1){
            if(data[is][js] == 1) blue++;
            else white++;
            return;
        }
        int sum = 0;
        for (int i = is; i < ie; i++) {
            for (int j = js; j < je; j++) {
                sum += data[i][j];
            }
        }

        if(sum == 0){
            white++;
            return;
        }
        if(sum == num * num){
            blue++;
            return;
        }

        calc(is, is+num/2, js, js+num/2, num/2); // 좌상단
        calc(is, is+num/2, js+num/2, je, num/2); // 우상단
        calc(is+num/2, ie, js, js+num/2, num/2); // 좌하단
        calc(is+num/2, ie, js+num/2, je, num/2); // 우하단
    }
}