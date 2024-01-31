package Baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
백준 가르침 1062 G4
시작 시간 : 24-01-31 15:55
종료 시간 : 24-01-31 -----
실행 시간 : 580ms / 실패

고려사항
전체 알파벳에서 고정적으로 제공되는 a,c,i,t,n을 포함하여
26개의 알파벳에서 K개의 char를 조합을 이용하여 구한다
실제로 계산할 때는 5개의 char는 미리 선택한 것으로 한다

주의, K값이 5보다 작다면, 어떤 문자열도 읽을 수 없다
flag를 26개의 비트로 고려하여 각 위치마다 해당 알파벳을 깨우쳤는지 여부를 표시한다
예를 들어, 'c'문자만을 알고 있다면 flag = ...000100
문자열의 char를 탐색하며, 문자열을 이루는 모든 문자에 대해서 flag에 1로
표시되어 있지 않다면 해당 문자열은 읽을 수 없다
*/

public class BOJ_1062_가르침_G4 {

	static int N, K, flag;
	static String[] words; // 입력받은 N개의 문자열
	static int ans = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {

		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		if(K < 5){
			System.out.println(0);
			System.exit(0);
		}

		words = new String[N];
		for(int i = 0; i < N; i++){
			words[i] = br.readLine();
		}

		char[] originCharList = {'a','c','i','t','n'};
		for(int t = 0; t < 5; t++) {
			flag |= 1 << (originCharList[t] - 'a');
		}

		comb(0, 0);

		System.out.println(ans);
	}

	private static void comb(int depth, int start) {

		if(depth == K - 5) {
			int cnt = 0;
			for(int i = 0; i < N; i++){
				// 현재 flag를 바탕으로 i번째 문자열을 읽을수 있는지
				if(canRead(words[i])) cnt++;
			}

			ans = Math.max(ans, cnt);
			return;
		}

		for(int i = start; i < 26; i++){
			// 이미 i번째 캐릭터를 조합내에 가지고 있는 경우 pass
			if((flag & 1 << i) != 0) continue;

			flag |= 1 << i;
			comb(depth+1, i+1);
			flag &= ~(1 << i);
		}



	}

	private static boolean canRead(String word) {

		for(char c : word.toCharArray()){
//			문자열이 한 문자가 flag에서 1로 표시되지 않은 경우, 이 문자열은 읽을 수 없다
			if((flag | (1 << (c-'a'))) != flag) return false;
		}

		return true;
	}


}
