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

public class BOJ_1954_화학실험_G3 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M, Gas;
    static int[][] para;

    static private void input() throws IOException{
        N = Integer.parseInt(br.readLine());
        para = new int[N][];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            para[i] = new int[]{a, b};
        }

        M = Integer.parseInt(br.readLine());
    }

    private static boolean dfs(int order, int restLiquid){

        if(order == N){
            return restLiquid == 0;
        }

        // 남은 용액을 다 합쳐도 뒤에 시약에 1씩 못넣는 경우, 종료
        if(restLiquid < N-order) return false;

        // 현재 gas양을 나누어떨어지게 맞추지 못하는 경우 종료
        if( (Gas-para[order][1]) % para[order][0] != 0) return false;

        int requireLiquid = (Gas-para[order][1]) / para[order][0];
        if(requireLiquid > restLiquid) return false;

        return dfs(order+1, restLiquid - requireLiquid);
    }

    public static void main(String[] args) throws IOException {

        input();

        for (int g = 1; g <= M-N+1; g++) {
            Gas = para[0][0] * g + para[0][1];
            boolean success = dfs(0, M);

            if(success){
                System.out.println(Gas);
                return;
            }
        }

        System.out.println(0);
    }
}