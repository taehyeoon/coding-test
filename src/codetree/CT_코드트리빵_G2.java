package codetree;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-04-13 23:14
종료 시간 : 24-04-13 01:50
실행 시간 : 332ms
메 모 리 : 14MB
*/

public class CT_코드트리빵_G2 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;
    static int[][] map, stores, peoples;
    static int[] peopleStates; // 0 : 외부, 1: 격자 안, 2 : 도착


    static List<int[]> campList = new ArrayList<>(); // 점령되지 않는 캠프들
    static int[][] delta = {{-1,0}, {0,-1}, {0,1}, {1,0}}; // 상좌우하
    static final int OUT = 0, IN = 1, ARRIVE = 2;

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1){
                    campList.add(new int[]{i,j});
                }
            }
        }

        stores = new int[M][];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            stores[i] = new int[]{x,y};
        }

        peoples = new int[M][];
        peopleStates = new int[M];
    }

    private static int getDist(int[] a, int[] b){
        return Math.abs(a[0]-b[0]) + Math.abs(a[1] - b[1]);
    }

    private static void moveToBasecamp(int pNum){

        List<int[]> candidateCampList = new ArrayList<>();

        boolean[][] visited = new boolean[N][N];
        visited[stores[pNum][0]][stores[pNum][1]] = true;

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{stores[pNum][0], stores[pNum][1]});

        boolean isFindBase = false;

        while (!q.isEmpty()) {

            int qSize = q.size();

            for (int iter = 0; iter < qSize; iter++) {
                int[] cur = q.poll();
                int ci = cur[0], cj = cur[1];

                for (int i = 0; i < 4; i++) {
                    int ni = ci + delta[i][0];
                    int nj = cj + delta[i][1];

                    if(ni < 0 || nj < 0 || ni >= N || nj >= N) continue;

                    if(map[ni][nj] == 1){
                        isFindBase = true;
                        candidateCampList.add(new int[]{ni, nj});
                        continue;
                    }
                    if(map[ni][nj] == -1) continue; // 벽
                    if(visited[ni][nj]) continue; // 이미 방문

                    visited[ni][nj] = true;
                    q.offer(new int[]{ni, nj});
                }
            }

            if(isFindBase) break;
        }

        candidateCampList.sort(((o1, o2) -> {
            if(o1[0] != o2[0]) return o1[0] - o2[0];
            return o1[1] - o2[1];
        }));

        peopleStates[pNum] = IN;
        int pi = candidateCampList.get(0)[0];
        int pj = candidateCampList.get(0)[1];
        peoples[pNum] = new int[]{pi, pj};
        map[pi][pj] = -1; // 이제 금지

        // 빈 campList 에서 삭제
        for (int i = 0; i < campList.size(); i++) {
            if(campList.get(i)[0] == pi && campList.get(i)[1] == pj){
                campList.remove(i);
                break;
            }
        }
    }

    private static boolean move(int pNum){

        // 바로 앞이 편의점인 경우
        if(getDist(peoples[pNum], stores[pNum]) == 1){
            peopleStates[pNum] = ARRIVE;
            return true;
        }

        int pi = peoples[pNum][0];
        int pj = peoples[pNum][1];


        List<int[]> candidate = new ArrayList<>();

        boolean[][] visited = new boolean[N][N];
        visited[stores[pNum][0]][stores[pNum][1]] = true;

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{stores[pNum][0], stores[pNum][1]});

        boolean isFindPNum = false;
        while (!q.isEmpty()) {

            int qSize = q.size();

            for (int iter = 0; iter < qSize; iter++) {

                int[] cur = q.poll();
                int ci = cur[0], cj = cur[1];

                for (int i = 0; i < 4; i++) {
                    int ni = ci + delta[i][0];
                    int nj = cj + delta[i][1];

                    if(ni < 0 || nj < 0 || ni >= N || nj >= N) continue;

                    // 사람이 있는 칸에 도착한 경우
                    if(ni == pi && nj == pj){
                        isFindPNum = true;
                        candidate.add(new int[]{ci, cj});
                        break;
                    }

                    if(map[ni][nj] == -1) continue; // 벽
                    if(visited[ni][nj]) continue; // 이미 방문

                    visited[ni][nj] = true;
                    q.offer(new int[]{ni, nj});
                }
            }

            if(isFindPNum) break;
        }

        candidate.sort(((o1, o2) -> {
            if(o1[0] != o2[0]) return o1[0] - o2[0];
            return o1[1] - o2[1];
        }));

        int nextI = candidate.get(0)[0];
        int nextJ = candidate.get(0)[1];

        // 실제 이동
        peoples[pNum] = new int[]{nextI, nextJ};

        return false;
    }

    private static List<Integer> movePeoples(){

        List<Integer> arrivedStoreList = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            if(peopleStates[i] != IN) continue;

            boolean isArrive = move(i);
            if(isArrive){
                arrivedStoreList.add(i);
            }
        }

        return arrivedStoreList;
    }

    private static boolean isAllArrived(){
        for (int i = 0; i < M; i++) {
            if(peopleStates[i] != ARRIVE) return false;
        }

        return true;
    }

    public static void main(String[] args) throws IOException {

        input();

        List<Integer> arrivedIndices;

        int time = 0;
        while (!isAllArrived()){

            arrivedIndices = movePeoples();

            // 벽으로 설정
            for(int idx : arrivedIndices){
                map[stores[idx][0]][stores[idx][1]] = -1;
            }

            if(time < M){
                moveToBasecamp(time);
            }

            time++;
        }

        System.out.println(time);
    }
}