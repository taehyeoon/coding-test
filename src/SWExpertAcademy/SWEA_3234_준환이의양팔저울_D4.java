package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
시작 시간 : 24-02-08 13:00
종료 시간 : 24-02-08 22:00
실행 시간 : 937ms
메 모 리 : 23164KB

고려사항
Next-permutaion을 직접 구현하여, 다음 순열에 대해
저울에 올리는 순서가 적절한지 DFS를 이용하여 체크하였습니다
*/

public class SWEA_3234_준환이의양팔저울_D4 {

	static int TC, N, ans;
    static int[] stones;
    public static void main(String[] args) throws IOException {

        System.setIn(Files.newInputStream(Paths.get("input.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        TC = Integer.parseInt(br.readLine());
        
        for(int tc = 1; tc <= TC; tc++) {
        	
        	N = Integer.parseInt(br.readLine());
        	stones = new int[N];
        	ans = 0;
        	
        	st = new StringTokenizer(br.readLine());
        	for(int i = 0; i < N; i++) {
        		stones[i] = Integer.parseInt(st.nextToken());
        	}

			Arrays.sort(stones);
			do{
				dfs(stones[0], 0, 1);
			}while(nextPermutation(stones));
        	sb.append(String.format("#%d %d%n", tc, ans));
        }
        
        System.out.print(sb);
    }

	private static boolean nextPermutation(int[] stones) {
		int i = N-1;
		while(i > 0 && stones[i-1] >= stones[i]) i--;
		if(i == 0) return false;

		int j = N-1;
		while(stones[i-1] >= stones[j]) j--;

		swap(stones, i-1, j);

		int k = N-1;
		while(i < k) swap(stones, i++, k--);

		return true;
	}

	private static void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	private static void dfs(int lSum, int rSum, int idx) {

		if(idx == N) {
			ans++;
			return; 
		}

		if(lSum >= rSum + stones[idx]){
			dfs(lSum, rSum+stones[idx], idx+1);
		}
		dfs(lSum+stones[idx], rSum, idx+1);
	}
}