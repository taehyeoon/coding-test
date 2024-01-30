package Baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
백준 스타트와링크 14889 S1
시작 시간 : 24-01-30 09:00
종료 시간 : 24-01-30 10:30
실행시간 : 412ms

고려사항
조합 이용
순서를 고려하지 않고, N명 중에서 N/2명을 뽑는 조합을 이용하였습니다.
조합을 이용해서 N/2명을 뽑았다면,
각 팀의 N/2명 내에서 팀의 능력치를 계산합니다
*/

public class Solution14889 {

    static int N, ans = Integer.MAX_VALUE;
    static int[][] data;
    static boolean[] visited;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        data = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N];
        comb(visited, 0, N, N/2);
        System.out.println(ans);
    }

    private static void comb(boolean[] visited, int start, int n, int r) {
        if(r == 0){
            ArrayList<Integer> team1mem = new ArrayList<>();
            ArrayList<Integer> team2mem = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                if(visited[i]) team1mem.add(i);
                else team2mem.add(i);
            }

            int team1 = 0, team2 = 0;
            for (int i = 0; i < team1mem.size()-1; i++) {
                for (int j = i+1; j < team1mem.size(); j++) {
                    team1 += data[team1mem.get(i)][team1mem.get(j)];
                    team1 += data[team1mem.get(j)][team1mem.get(i)];
                }
            }

            for (int i = 0; i < team2mem.size()-1; i++) {
                for (int j = i+1; j < team2mem.size(); j++) {
                    team2 += data[team2mem.get(i)][team2mem.get(j)];
                    team2 += data[team2mem.get(j)][team2mem.get(i)];
                }
            }

            ans = Math.min(ans, Math.abs(team1-team2));
            return;
        }

        for(int i = start; i < n; i++) {
            visited[i] = true;
            comb(visited, i + 1, n, r - 1);
            visited[i] = false;
        }

    }
}