package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
시작 시간 : 24-01-30
종료 시간 : 24-01-30
실행 시간 : 1031ms
메 모 리 : 22,224KB
 */
public class SWEA_6808_규영이와인영이의카드게임_D3 {

	static int TC; 	

	static int[] kyu, inn;
	static int winCnt, loseCnt; // 승수
	static StringTokenizer st; 
	
	private static void permutation(int idx) {
		if(idx == 9) {
			check();
			return;
		}
		
		for(int i = idx; i < 9; i++) {
			swap(i, idx);
			permutation(idx+1);
			swap(i, idx);
		}
		
	}
	
	
	private static void swap(int i, int idx) {
		
		int temp = inn[i];
		inn[i] = inn[idx];
		inn[idx] = temp;
		
	}


	private static void check() {
		
		int kSum = 0;
		int iSum = 0;
		
		for(int i = 0; i < 9; i++) {
			if(kyu[i] > inn[i]) kSum += kyu[i] + inn[i];
			else iSum += kyu[i] + inn[i];
		}
		
		if(kSum > iSum) winCnt++;
		if(iSum > kSum) loseCnt++;
		return;
	}


	public static void main(String[] args) throws NumberFormatException, IOException {
		
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		TC = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= TC; tc++) {
			winCnt = 0;
			loseCnt = 0;
			
			st = new StringTokenizer(br.readLine());
			
			boolean[] check = new boolean[18];
			inn = new int[9];
			kyu = new int[9];
			
			for(int i = 0; i < 9; i++) {
				int num = Integer.parseInt(st.nextToken());
				check[num-1] = true;
				kyu[i] = num;
			}
			
			int idx = 0;
			for(int i = 0; i < 18; i++) {
				if(!check[i]) inn[idx++] = i + 1;
			}
			
			permutation(0);
			
			
			System.out.printf("#%d %d %d\n", tc, winCnt, loseCnt);
		}
		
		

	
	}
}
