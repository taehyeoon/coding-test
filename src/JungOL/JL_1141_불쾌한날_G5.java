package coding;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


// 실행시간 : 277ms
// 메모리 : 42.8MB

/*
시작 시간 : 24-02-02 
종료 시간 : 24-02-02 
실행 시간 : 277ms
메 모 리 : 186,124KB

소를 오른쪽에서 왼쪽으로 탐색하며,
k번째 소를 탐색할 때,
현재 소를 바라보는 소를 스택에 저장한다
 */
public class JL_1141_불쾌한날_G5 {

	static int N;
	static long ans;
	static long[] input;
	static Stack<Long> s = new Stack<>();

	public static void main(String[] args) throws IOException{
		
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		input = new long[N];
		
		for(int i =0 ; i < N; i++) {
			input[i] = Integer.parseInt(br.readLine()); 
		}

		s.add(input[0]);
		for(int i = 1; i < N; i++) {
			long cur = input[i];
			long top = s.peek();
			while(cur >= top) {
				s.pop();
				if(s.isEmpty()) break;
				top = s.peek();
			}
			ans += s.size();
			s.add(cur);
			
		}
		
		System.out.println(ans);
		
	}
}
