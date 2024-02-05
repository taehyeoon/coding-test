package coding;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/*
시작 시간: 24-02-05 17:00
종료 시간: 24-02-05 17:45
실행 시간: 113ms
메 모 리: 19,620KB

고려사항
LinkedList를 사용하여 I 명령을 받을 때마다 리스트 중간에 입력받은 y개의 숫자를 추가합니다.
*/

public class SWEA_1228_암호문1_D3 {

	static int N, cmdN;
	static List<Integer> crypto;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 1; tc <= 10; tc++) {
			
			N = Integer.parseInt(br.readLine());
			crypto = new LinkedList<>();
			
			st = new StringTokenizer(br.readLine());
			
			while(st.hasMoreTokens()) {
				crypto.add(Integer.parseInt(st.nextToken()));
			}
			
			cmdN = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				
				st.nextToken(); // I
				int insIdx = Integer.parseInt(st.nextToken());
				int insN = Integer.parseInt(st.nextToken());
				
				
				for(int j = 0; j < insN; j++) {
					crypto.add(insIdx++, Integer.parseInt(st.nextToken()));
				}
			}
			
			sb.append("#" + tc);
			for(int k = 0; k < 10; k++) 
				sb.append(" ").append(crypto.get(k));
			sb.append("\n");
		}
		System.out.print(sb);
	}
}