package coding;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
시작 시간 : 24-02-05 11:10
종료 시간 : 24-02-05 11:55
실행 시간 : 3120ms
메 모 리 : 186,124KB

고려사항
오른쪽 끝부터 왼쪽으로 탐색
0. k는 N-1~1까지 순회
1. 스택에는 현재 왼쪽으로 레이저를 발사하고 있는 탑을 저장
2. k번째 탑을 스택의 top값과 비교하여
	i. k번째 탑의 높이 < top 값 : 스택에 k번째 탑 높이 저장
	ii. k번째 탑의 높이 >= top 값 : k번째 탑의 높이보다 top이 클 때까지 pop
		a. pop한 탑의 결과는 k이다 : pop이 되었다는 것은 k번째 탑의 레이저를 수신했다는 의미
3. k번째 탑을 stack에 push
4. 순회가 끝났고, 스택이 비어있지 않는 경우,
	- 스택의 모든 탑을 0으로 저장
*/

public class Main_2493_탑_G5 {

	static int N;
	static int[] lazer, result;
	static Stack<int[]> s = new Stack<>();
	public static void main(String[] args) throws IOException {
		
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		lazer = new int[N+1]; // 레이저 번호, 레이저 높이
		result = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			lazer[i] = Integer.parseInt(st.nextToken());
		}

		s.add(new int[] {N, lazer[N]}); // 오른쪽 끝 레이저
		
		for(int curIdx = N-1; curIdx >= 1; curIdx--) {
			
			int topH = s.peek()[1];
			
			int curH = lazer[curIdx];
			if(curH < topH) {
				s.add(new int[] {curIdx, lazer[curIdx]});
			}else {
				while(curH >= topH) {
					
					int[] top = s.pop();
					result[top[0]] = curIdx;
					if(s.isEmpty()) break;
					topH = s.peek()[1];
				}
				s.add(new int[] {curIdx, lazer[curIdx]});
			}
			
		}
		
		while(!s.isEmpty()) {
			result[s.pop()[0]] = 0;
		}
		
		for(int i = 1; i <= N; i++)
			System.out.print(result[i] + " ");
	}
}
