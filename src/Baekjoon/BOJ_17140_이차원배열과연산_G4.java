package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-03-14 22:12
종료 시간 : 24-03-14 23:16
실행 시간 : 124ms
메 모 리 : 17968KB
*/

public class BOJ_17140_이차원배열과연산_G4 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int R, C, K, rowL, colL;
    static int[][] map;
    private static void input() throws IOException{
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken()) - 1;
        C = Integer.parseInt(st.nextToken()) - 1;
        K = Integer.parseInt(st.nextToken());

        map = new int[3][3];
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void rowSort(){

        int[] freq;

        PriorityQueue<int[]>[] pqs = new PriorityQueue[rowL];
        for (int i = 0; i < rowL; i++) {
            pqs[i] = new PriorityQueue(new Comparator<int[]>() {

                @Override
                public int compare(int[] o1, int[] o2) {
                    if(o1[1] == o2[1]) return Integer.compare(o1[0], o2[0]);
                    else return Integer.compare(o1[1], o2[1]);
                }
            });
        }

        for (int r = 0; r < rowL; r++) {
            freq = new int[101];
            for (int c = 0; c < colL; c++) {
                int val = map[r][c];
                if(val == 0) continue;
                freq[val]++;
            }
            for (int num = 1; num <= 100; num++) {
                if(freq[num] != 0){
                    pqs[r].offer(new int[]{num, freq[num]});
                }
            }
        }

        int maxSet = 0;
        for (int i = 0; i < rowL; i++) {
            if(pqs[i].size() > maxSet) maxSet = pqs[i].size();
        }
        int maxCol;
        if(maxSet > 50) maxCol = 100;
        else maxCol = 2 * maxSet;

        map = new int[rowL][maxCol];

        for (int r = 0; r < rowL; r++) {
            for (int c = 0; c < maxCol/2; c++) {
                int[] cur = pqs[r].poll();
                if(cur == null) break;
                int num = cur[0];
                int f = cur[1];
                map[r][2*c] = num;
                map[r][2*c+1] = f;
            }
        }
    }

    private static void colSort(){

        int[] freq;

        PriorityQueue<int[]>[] pqs = new PriorityQueue[colL];
        for (int i = 0; i < colL; i++) {
            pqs[i] = new PriorityQueue(new Comparator<int[]>() {

                @Override
                public int compare(int[] o1, int[] o2) {
                    if(o1[1] == o2[1]) return Integer.compare(o1[0], o2[0]);
                    else return Integer.compare(o1[1], o2[1]);
                }
            });
        }

        for (int c = 0; c < colL; c++) {
            freq = new int[101];
            for (int r = 0; r < rowL; r++) {
                int val = map[r][c];
                if(val == 0) continue;
                freq[val]++;
            }
            for (int num = 1; num <= 100; num++) {
                if(freq[num] != 0){
                    pqs[c].offer(new int[]{num, freq[num]});
                }
            }
        }

        int maxSet = 0;
        for (int i = 0; i < colL; i++) {
            if(pqs[i].size() > maxSet) maxSet = pqs[i].size();
        }
        int maxRow;
        if(maxSet > 50) maxRow = 100;
        else maxRow = 2 * maxSet;

        map = new int[maxRow][colL];

        for (int c = 0; c < colL; c++) {
            for (int r = 0; r < maxRow/2; r++) {
                int[] cur = pqs[c].poll();
                if(cur == null) break;
                int num = cur[0];
                int f = cur[1];
                map[2*r][c] = num;
                map[2*r+1][c] = f;
            }
        }
    }

    private static void solve(){

        rowL = map.length;
        colL = map[0].length;

        if(rowL >= colL) rowSort();
        else colSort();
    }

    public static void main(String[] args) throws IOException {

        input();

        for (int time = 0; time <= 100; time++) {
            if(R < map.length && C < map[0].length && map[R][C] == K){
                System.out.println(time);
                return;
            }
            solve();
        }
        System.out.println(-1);
    }
}