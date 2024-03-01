package coding.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/*
실행 시간 : 445ms
메 모 리 : 93320KB
*/

public class SWEA_2382_미생물격리 {

	static class Warm implements Comparable<Warm>{
		int i, j, n, dir;

		public Warm(int i, int j, int n, int dir) {
			super();
			this.i = i;
			this.j = j;
			this.n = n;
			this.dir = dir;
		}

		@Override
		public boolean equals(Object obj) {
			Warm w = (Warm)obj;
			return this.i == w.i && this.j == w.j;
		}

		@Override
		public int compareTo(Warm o) {
			return this.i == o.i ? this.j - o.j : this.i - o.i;
		}
	}
	
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    
	static int N, Time, WarmNum;
	static List<Warm> warms;
	static int[] di = {-99, -1,1,0,0};
	static int[] dj = {-99, 0,0,-1,1};
	
	private static void input() throws IOException {
		st = new StringTokenizer(br.readLine());
        	
        	N = Integer.parseInt(st.nextToken());
        	Time = Integer.parseInt(st.nextToken());
        	WarmNum = Integer.parseInt(st.nextToken());
        	
        	warms = new LinkedList<>();
        	for(int i = 0; i < WarmNum; i++) {
        		st = new StringTokenizer(br.readLine());
        		int h = Integer.parseInt(st.nextToken());
        		int w = Integer.parseInt(st.nextToken());
        		int n = Integer.parseInt(st.nextToken());
        		int dir = Integer.parseInt(st.nextToken());
        		
        		warms.add(new Warm(h, w, n, dir));
        	}
	}
	
	private static void move() {
		for(int i = 0; i < warms.size(); i++) {
			Warm warm = warms.get(i);
			warm.i = warm.i + di[warm.dir];
			warm.j = warm.j + dj[warm.dir];
		}
	}
	
	private static boolean inRedZone(Warm w) {
		if(w.i == 0 || w.j == 0 || w.i == N-1 || w.j == N-1) return true;
		else return false;
	}
	
	private static void mergeNTurn() {
		
		Collections.sort(warms);
		
		ArrayList<Warm> tempList = new ArrayList<Warm>(warms.size());
		while(!warms.isEmpty()) {
			
			Warm cur;
			int finalDir = -1;
			int maxWarm = Integer.MIN_VALUE;
			int sumWarm = 0;
			do {
				cur = warms.remove(0);
				
				if(inRedZone(cur)) {
					sumWarm = cur.n / 2;
					
					if(cur.dir == 1) finalDir = 2;
					else if(cur.dir == 2) finalDir = 1;
					else if(cur.dir == 3) finalDir = 4;
					else if(cur.dir == 4) finalDir = 3;
					break;
				}
				
				
				sumWarm += cur.n;
				if(cur.n > maxWarm) {
					finalDir = cur.dir;
					maxWarm = cur.n;
				}
				
				if(warms.isEmpty()) break;
			} while(cur.equals(warms.get(0)));
			
			if(sumWarm != 0)
				tempList.add(new Warm(cur.i, cur.j, sumWarm, finalDir));
		}
		
		warms = tempList;
	}
	
    public static void main(String[] args) throws IOException {

        int TC = Integer.parseInt(br.readLine());
        
        for(int tc = 1; tc <= TC; tc++) {
        	input();
        	
        	while(Time-- > 0) {
        		move();
        		mergeNTurn();
        	}
        	
        	int sum = 0;
        	for(Warm w : warms) {
        		sum += w.n;
        	}
        	sb.append(String.format("#%d %d%n", tc, sum));
        }
        System.out.print(sb);
    }
}