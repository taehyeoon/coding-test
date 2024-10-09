package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;
import java.util.StringTokenizer;

/*
시작 시간 : 24-0
종료 시간 : 24-0
실행 시간 : ms
메 모 리 : KB
*/

public class BOJ_3584_가장가까운공통조상 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T;

    static int N, X, Y;
    static int[] parents;

    public static void main(String[] args) throws IOException {

        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            System.out.println(sol());
        }
    }

    private static int sol() throws IOException {
        N = Integer.parseInt(br.readLine());

        parents = new int[N+1];
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            parents[b] = a;
        }

        st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        ArrayList<Integer> xList = getArrayList(X);
        ArrayList<Integer> yList = getArrayList(Y);


        int ptrX = xList.size()-1;
        int ptrY = yList.size()-1;

        while(ptrX >= 0 && ptrY >= 0) {
            if(!Objects.equals(xList.get(ptrX), yList.get(ptrY))) {
                return xList.get(ptrX+1);
            }

            ptrX--; ptrY--;
        }

        if(ptrX < 0) return xList.get(0);
        if(ptrY < 0) return yList.get(0);

        return -1;
    }

    private static ArrayList<Integer> getArrayList(int start) {
        ArrayList<Integer> list = new ArrayList<>();

        int cur = start;
        list.add(cur);
        while(parents[cur] != cur) {
            list.add(parents[cur]);
            cur = parents[cur];
        }

        return list;
    }
}