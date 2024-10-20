package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
시작 시간 : 24-0
종료 시간 : 24-0
실행 시간 : ms
메 모 리 : KB
*/

public class BOJ_13325_이진트리 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int K, SIZE, ans;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());
        SIZE = (int) (Math.pow(2, K + 1) - 1);

        arr = new int[SIZE + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 2; i < SIZE + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        ans = 0;
        dfs(1);

        System.out.println(ans);
    }

    private static int dfs(int node) {
        if (node * 2 >= SIZE) {
            // 리프노드의 값을 더해주고 반환한다
            ans += arr[node];
            return arr[node];
        }

        int left = dfs(node * 2);
        int right = dfs(node * 2 + 1);

        // 현재 노드의 값과 자식 노드들의 차이를 더해준다
        ans += arr[node] + Math.abs(left - right);
        return arr[node] + Math.max(left, right);
    }
}