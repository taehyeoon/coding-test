package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-05-16 00:05
종료 시간 : 24-05-16 00:54
실행 시간 : 236ms
메 모 리 : 18864KB
*/

public class BOJ_4386_별자리만들기_G3 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int[] minSpots = new int[2];
    static double minEdge;
    static double[][] spots, adj;
    static boolean[] connected;
    private static void input() throws IOException{
        N = Integer.parseInt(br.readLine());
        spots = new double[N][];
        adj = new double[N][N];
        connected = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            spots[i] = new double[]{Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken())};
            adj[i][i] = Double.MAX_VALUE;
        }

        minEdge = Double.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                adj[i][j] = adj[j][i] = Math.sqrt(
                    Math.pow(spots[i][0] - spots[j][0],2) + Math.pow(spots[i][1] - spots[j][1],2)
                );

                if(adj[i][j] < minEdge){
                    minSpots = new int[]{i,j};
                    minEdge = adj[i][j];
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        input();

        PriorityQueue<double[]> pq = new PriorityQueue<>((Comparator.comparingDouble(o -> o[2])));

        connected[minSpots[0]] = true;
        connected[minSpots[1]] = true;

        for (int i = 0; i < N; i++) {
            if(i != minSpots[0] && !connected[i]){
                pq.add(new double[]{minSpots[0], i, adj[minSpots[0]][i]});
            }
            if(i != minSpots[1] && !connected[i]){
                pq.add(new double[]{minSpots[1], i, adj[minSpots[1]][i]});
            }
        }

        int connectedCnt = 2;
        double ans = minEdge;
        while(connectedCnt != N){

            double[] cur = pq.poll();
            if(connected[(int)cur[1]]) continue;

            connected[(int)cur[1]] = true;
            ans += cur[2];
            connectedCnt++;
            for (int i = 0; i < N; i++) {
                if(i != (int)cur[1] && !connected[i]){
                    pq.add(new double[]{(int)cur[1], i, adj[(int)cur[1]][i]});
                }
            }
        }
        System.out.println(Math.round(ans*100.0)/100.0);
    }
}