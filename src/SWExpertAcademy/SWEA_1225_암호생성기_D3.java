package coding;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 실행시간 : 132ms
// 메모리 : 20,352KB
public class SWEA_1225_암호생성기_D3 {
	
	static Deque<Integer> q = new ArrayDeque<>();

	public static void main(String[] args) throws IOException{
		
		
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		int tc = 1;
		
		
		while(tc <= 10) {
			
			q.clear();
			
			br.readLine();
			st = new StringTokenizer(br.readLine());

			for(int i = 0; i < 8; i++) {
				q.add(Integer.parseInt(st.nextToken()));
			}
			
			System.out.printf("#%d ", tc++);
			int temp;
			int t = 0;
			while(true) {
				temp = q.poll() - (t+1);
				
				if(temp <= 0) {
					q.offer(0);
					break;
				}
				
				q.offer(temp);
				t = (t+1) % 5;
			}
			
			Iterator<Integer> it = q.iterator();
			
			while(it.hasNext()) {
				System.out.print(it.next() + " ");
			}
			System.out.println();
			
			
		}
		
	}
}
