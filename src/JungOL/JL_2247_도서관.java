package JungOL;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


// 실행시간 : 308ms
// 메모리 : 38.1MB

public class JL_2247_도서관 {

	static class Stay implements Comparable<Stay>{
		int s, e;

		public Stay(int s, int e) {
			super();
			this.s = s;
			this.e = e;
		}

		@Override
		public int compareTo(Stay o) {
			return this.s == o.s ? this.e - o.e : this.s - o.s;
		}

	}
	static int N, maxStay, maxEmpty;
	static Stay[] stays;
	
	public static void main(String[] args) throws IOException{
		
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		stays = new Stay[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			stays[i] = new Stay(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		
		Arrays.sort(stays);

		int lastE = stays[0].e;
		int curStay = stays[0].e - stays[0].s;
		maxStay = curStay;
		for(int i = 1; i < N; i++) {
			Stay cur = stays[i];
			
			if(cur.e < lastE) continue; // 가장 마지막 종료 시점보다 일찍 종료되는 경우 skip
			
			if(cur.s <= lastE) { // 이전과 겹치는 경우
				curStay += cur.e - lastE;
				maxStay = Math.max(maxStay, curStay);
				
			}else { // 겹치지 않는 경우
				curStay = cur.e - cur.s;
				maxEmpty = Math.max(maxEmpty, cur.s - lastE);
				maxStay = Math.max(maxStay, curStay);
			}
			lastE = cur.e;
		}
		
		maxStay = Math.max(maxStay, curStay);
		
		System.out.println(maxStay + " " + maxEmpty);
	}
}