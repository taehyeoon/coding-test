import java.io.*;
import java.util.*;

/*
시작 시간 : 24-04-23 11:00
종료 시간 : 24-04-23 14:06
실행 시간 : 2216ms / 실패
메 모 리 : 35780KB
*/

public class BOJ_1256_사전_G2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception {
			
		StringBuilder ans = new StringBuilder();
		List<Integer> save = new ArrayList<>();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < TC; tc++) {
			
			pq.clear();
			save.clear();
			int n = Integer.parseInt(br.readLine());
			StringBuilder sb = new StringBuilder();
			int cnt = 0;
			
			for(int i = 1; i <= n; i++) {
				if(i % 10 == 1) {
					st = new StringTokenizer(br.readLine());
				}
				int val = Integer.parseInt(st.nextToken());
				pq.add(val);
				
				if(i % 2 == 1) {
					
					int qSize = pq.size();
					int mid = qSize / 2;
					
					while(mid-- > 0) {
						save.add(pq.poll());
					}
					cnt++;
					sb.append(pq.peek() + " ");
					for(int j = 0; j < save.size(); j++) {
						pq.add(save.get(j));
					}
					save.clear();
					if(cnt == 10) sb.append("\n");
				}
			}
			
			ans.append(cnt).append("\n");
			ans.append(sb).append("\n");
		}
		
		bw.write(ans.toString());
		bw.close();
	}
}
