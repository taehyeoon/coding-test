package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
시작 시간 : 24-03-01 20:10
종료 시간 : 24-03-01 21:10
실행 시간 : 311ms / 실패
메 모 리 : 22824KB
*/

public class SWEA_4012_요리사_모의 {

	static int TC, N, ans;
    static int[][] food;
	static boolean[] selected;



	private static int cal(){
		int a = 0, b = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if( i == j) continue;

				if(selected[i] && selected[j]) a += food[i][j];
				else if(!selected[i] && !selected[j]) b+= food[i][j];
			}
		}

		return Math.abs(a - b);
	}

	private static void combi(int cnt, int start){

		if(cnt == N/2){
			ans = Math.min(ans, cal());
			return;
		}

		for (int i = start; i < N; i++) {
			if(selected[i]) continue;

			selected[i] = true;
			combi(cnt+1, i+1);
			selected[i] = false;
		}
	}

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        TC = Integer.parseInt(br.readLine());
        
        for(int tc = 1; tc <= TC; tc++) {
        	
        	N = Integer.parseInt(br.readLine());
        	food = new int[N][N];
			selected = new boolean[N];
        	ans = Integer.MAX_VALUE;
        	
        	for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					food[i][j] = Integer.parseInt(st.nextToken());
				}
        	}

			combi(0, 0);

        	sb.append(String.format("#%d %d%n", tc, ans));
        }
        
        System.out.print(sb);
    }
}