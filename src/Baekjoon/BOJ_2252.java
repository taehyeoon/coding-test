package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2252 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, M;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int[] in = new int[N+1];
		List<Integer>[] out = new List[N+1];
		for (int i = 1; i <= N; i++) {
			out[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			in[b]++;
			out[a].add(b);
		}

		Queue<Integer> q = new ArrayDeque<Integer>();
		for (int i = 1; i <= N; i++) {
			if(in[i] == 0) {
				q.add(i);
			}
		}


		List<Integer> result = new ArrayList<>();
		while(!q.isEmpty()) {
			int cur = q.poll();
			result.add(cur);

			for(int a : out[cur]){
				if(--in[a] == 0) {
					q.add(a);
				}
			}

		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		for(int a : result){
			sb.append(a).append(" ");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}