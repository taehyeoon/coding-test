package Baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
백준 회의실 배정 1931 S1
시작 시간 : 24-01-22 18:30
종료 시간 : 24-01-22 20:15
실행시간 : 444ms
정답 참조

고려사항
처음에 회의 중에서 가장 회의 진행시간이 짧은 회의를 먼저 확정하면
가장 많이 배치하 수 있을 것이라고 생각
-> 해설 확인 후
종료시간을 기준으로 오름차순 정렬,
종료시간이 빠른 것부터 확정하는 방법이 가장 많이 회의를 배치하는 방법이였다.
*/

public class Solution1931 {


    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int[][] time = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(time, (o1, o2) -> {
            // 종료시간이 같을 경우 시작시간이 빠른순으로 정렬해야한다.
            if(o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }

            return o1[1] - o2[1];
        });

        int count = 0;
        int prev_end_time = 0;

        for(int i = 0; i < N; i++) {

            // 직전 종료시간이 다음 회의 시작 시간보다 작거나 같다면 갱신
            if(prev_end_time <= time[i][0]) {
                prev_end_time = time[i][1];
                count++;
            }
        }

        System.out.println(count);


    }
}