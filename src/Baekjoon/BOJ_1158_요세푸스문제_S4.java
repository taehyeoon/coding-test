package coding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
시작 시간 : 24-02-05 16:20
종료 시간 : 24-02-05 17:15
실행시간 : 540ms
메 모 리 : 292,160KB

고려사항
Queue 자료구조를 이용하여, 큐를 순회하며, K번째 항목마다 pop을 하는 방식을 선택하였습니다
만약 K번째 항목이 아닌 경우, 맨앞의 숫자를 pop하여 맨 뒤로 push한다
큐가 빌때까지 반복합니다
*/

public class BOJ_1158_요세푸스문제_S4 {

	static int N, K;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new LinkedList<>();
		
		for(int i = 1; i <= N; i++) {
			q.add(i);
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		int cnt = 0;
		while(!q.isEmpty()) {
			cnt++;
			if(cnt == K) {
				sb.append(q.peek()).append(", ");
				q.poll();
				cnt = 0;
				
			}else {
				
				Integer top = q.peek();
				q.poll();
				q.add(top);
			}
			
			
		}
		sb.deleteCharAt(sb.length()-1);
		sb.deleteCharAt(sb.length()-1);
		sb.append(">");
		
		System.out.print(sb);
		
		
		
	}
}