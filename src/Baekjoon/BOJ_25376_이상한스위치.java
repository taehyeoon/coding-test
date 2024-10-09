package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_25376_이상한스위치 {

    static int N, goal;
    static List<Integer>[] associate;
    static Set<Integer> dup = new HashSet<Integer>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        associate = new List[N];
        for (int i = 0; i < N; i++) {
            associate[i] = new ArrayList<>();
        }

        goal = (1 << N) - 1;
        boolean[] state = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            state[i] = st.nextToken().equals("1");
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());

            for (int j = 0; j < a; j++) {
                int link = Integer.parseInt(st.nextToken());
                associate[i].add(link-1);
            }
        }

        int first = 0;
        for (int i = 0; i < state.length; i++) {
            if(state[i]) {
                first += (int)Math.pow(2, N-i-1);
            }
        }
        dup.add(first);

        if(first == ((1 << N)-1)){
            System.out.println(0);
            return;
        }

        Queue<Integer> q = new ArrayDeque<>();
        q.add(first);

        int cnt = 0;
        boolean success = false;
        loop:
        while(!q.isEmpty()){

            int size = q.size();
            cnt++;

            for (int i = 0; i < size; i++) {

                int cur = q.poll();
                for (int j = 0; j < N; j++) {

                    // j번째 버튼 클릭
                    if((cur & (1 << (N-j-1))) == 0) {
                        int next = cur;
                        next ^= 1 << (N-j-1);

                        // j 번째 클릭할 때 연관된 스위치 반전
                        for (int k = 0; k < associate[j].size(); k++) {
                            int pos = associate[j].get(k);
                            next ^= 1 << (N-pos-1);
                        }

                        if(next == goal) {
                            success = true;
                            break loop;
                        }

                        if(!dup.contains(next)) {
                            dup.add(next);
                            q.add(next);
                        }

                    }
                }

            }
        }

        System.out.println(success ? cnt : -1);
    }
}