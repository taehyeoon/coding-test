package coding.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
시작 시간 : 24-03-12 23:30
종료 시간 : 24-03-13 11:00
실행 시간 : 80ms / 실패
메 모 리 : 11612KB
*/

public class BOJ_1043_거짓말_G4 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;
    static int[] parents;
    static int firstKnowPerson;
    static int[][] party;
    
    private static int find(int v){
        if(v == parents[v]) return v;
        return parents[v] = find(parents[v]);
    }

    private static void union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);

        if(aRoot == bRoot) return;
        
        if(aRoot == firstKnowPerson) {
        	parents[bRoot] = firstKnowPerson;
        }else if(bRoot == firstKnowPerson) {
        	parents[aRoot] = firstKnowPerson;
        }else {
        	parents[aRoot] = bRoot;
        }
    }

    private static void input() throws IOException{
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // union 초기화
        parents = new int[N+1];
        for (int i = 1; i < N+1; i++) {
            parents[i] = i;
        }
        
        // 사실을 알고있는 사람 union
        st = new StringTokenizer(br.readLine());
        int knowingNum = Integer.parseInt(st.nextToken());
        if(knowingNum > 0) {
        	int prev = Integer.parseInt(st.nextToken());
        	firstKnowPerson = prev;
        	
        	for(int i = 1; i < knowingNum; i++) {
        		int cur = Integer.parseInt(st.nextToken());
        		union(prev, cur);
        		cur = prev;
        	}
        }
        
        party = new int[M][];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());

            int[] people = new int[n];
            int prev = Integer.parseInt(st.nextToken());
            people[0] = prev;
            
            for (int j = 1; j < n; j++) {
                people[j] = Integer.parseInt(st.nextToken());
                union(prev, people[j]);
                prev = people[j];
            }
            party[i] = people;
        }

    }
    public static void main(String[] args) throws IOException {

        int ans = 0;
        
        input();

        for(int i = 0; i < M; i++) {
        	if(find(party[i][0]) != firstKnowPerson) ans++;
        }
        
        System.out.println(ans);
    }
}