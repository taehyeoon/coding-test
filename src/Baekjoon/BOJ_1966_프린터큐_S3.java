package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
시작 시간 : 24-02-12 08:15
종료 시간 : 24-02-09
실행시간 : 108ms / 실패
메 모 리 : 12628KB

고려사항
큐의 맨 앞의 값이 큐 내의 데이터 중 최대 값이라면 poll하며
그렇지 않은 경우, 최대값 이전의 모든 데이터를 poll하여 다시 큐에 add합니다
이를 반복하며, M번째 값이 나올때까지 반복합니다, 반복한 횟수를 출력합니다.
*/

public class BOJ_1966_프린터큐_S3 {

    static int TC, N, M;
    static LinkedList<int[]> ll; // 등장순서, 값
    static StringBuilder sb = new StringBuilder();

    private static void input() throws IOException {
        System.setIn(Files.newInputStream(Paths.get("input.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        TC = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < TC; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            ll = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int val = Integer.parseInt(st.nextToken());
                ll.offer(new int[]{j, val});
            }
            solve();
        }
    }

    private static void solve() {
        int cnt = 0;

        while(!ll.isEmpty()){
            int[] cur = ll.pollFirst();
            boolean isMax = true;

            // 맨 앞의 값이 최대값인지 체크
            for (int i = 0; i < ll.size(); i++) {
                if(ll.get(i)[1] > cur[1]){

                    ll.offer(cur);
                    for (int j = 0; j < i; j++) {
                        ll.offer(ll.poll());
                    }

                    isMax = false;
                    break;
                }
            }

            if(!isMax){
                continue;
            }

            cnt++;
            if(cur[0] == M) break;
        }
        sb.append(cnt).append("\n");
    }

    public static void main(String[] args) throws IOException {
        input();

        System.out.print(sb);
    }
}
