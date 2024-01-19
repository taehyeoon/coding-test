package Baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
백준 숨바꼭질 1697 S1
시작 : 24-01-19 20:30 시작
끝 : 24-01-19 23:10 끝
실행시간 : 136ms
정답 확인

고려사항
BFS 이용
각 배열에 위치까지 도달하는데 걸리는 최소 시간 기록
 */
public class Solution1697 {
    static int start, end;
    static StringTokenizer st;

    static int[] check = new int[100001];

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end  = Integer.parseInt(st.nextToken());

        if(start == end){
            System.out.println(0);
        }else{
            bfs(start);
        }


    }

    private static void bfs(int cur) {

        Queue<Integer> q = new LinkedList<>();

        q.add(cur);
        check[cur] = 1;

        while (!q.isEmpty()) {
            int temp = q.poll();

            for (int i = 0; i < 3; i++) {
                int next;
                if (i == 0) next = temp + 1;
                else if (i == 1) next = temp - 1;
                else next = temp * 2;

                if (next == end) {
                    System.out.println(check[temp]);
                    return;
                }

                if (next >= 0 && next < check.length && check[next] == 0) {
                    q.add(next);
                    check[next] = check[temp] + 1;

                }

            }

        }

    }
}