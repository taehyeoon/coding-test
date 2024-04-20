package SWExpertAcademy.b;

import java.io.*;

/*
시작 시간 : 24-04-20 10:20
종료 시간 : 24-04-20 10:45
실행 시간 : 119ms
메 모 리 : 25288KB
*/

public class SWEA_b_새로운불면증치료법 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= TC; tc++) {

			int flag = 0;
			long x = Long.parseLong(br.readLine());
			long add = x;

			while(flag != ((1<<10) -1)){
				long temp = x;

				while(temp != 0){
					flag |= 1 << (temp % 10);
					temp /= 10;
				}
				x += add;
			}
			sb.append(String.format("#%d %d\n", tc, x-add));
		}
		System.out.println(sb);
	}
}
