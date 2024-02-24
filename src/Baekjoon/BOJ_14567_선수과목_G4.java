package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-02-20 21:20
종료 시간 : 24-02-20 21:40
실행 시간 : 608ms
메 모 리 : 128584KB

고려사항
위상정렬 이용
*/

public class BOJ_14567_선수과목_G4 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, E;

    static List<Integer>[] outerList;
    static int[] inDegreeList;
    static Queue<Integer> zeroQueue;
    static int[] result;

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        outerList = new ArrayList[N+1];
        for(int i = 1; i <= N; i++) outerList[i] = new ArrayList<>(N >> 1);
        inDegreeList = new int[N+1];
        zeroQueue = new LinkedList<>();
        result = new int[N+1];

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            outerList[from].add(to);
            inDegreeList[to]++;
        }
    }

    private static void solve(){
        // indegree가 0인 노드 큐에 넣기
        for(int i = 1; i <= N; i++){
            if(inDegreeList[i] == 0) zeroQueue.offer(i);
        }

        int semester = 0;
        while(!zeroQueue.isEmpty()){
            semester++;
            int q_size = zeroQueue.size();
            for(int iter = 0; iter < q_size; iter++){
                int cur = zeroQueue.poll();
                result[cur] = semester;

                for (int i = 0; i < outerList[cur].size(); i++) {
                    if(--inDegreeList[outerList[cur].get(i)] == 0)
                        zeroQueue.add(outerList[cur].get(i));
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if(result[i] == 0) result[i] = 1;
        }
    }


    public static void main(String[] args) throws IOException {

        input();
        solve();

        for (int i = 1; i <= N; i++) {
            sb.append(result[i]).append(" ");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
