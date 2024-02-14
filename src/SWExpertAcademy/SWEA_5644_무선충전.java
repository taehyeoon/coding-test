package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/*
실행시간 : 137ms
메모리 : 26532KB
*/

public class SWEA_5644_무선충전 {

    static class BC implements Comparable<BC>{
        int x, y, c, p;

        public BC(int x, int y, int c, int p) {
            super();
            this.x = x;
            this.y = y;
            this.c = c;
            this.p = p;
        }

        @Override
        public int compareTo(BC o) {
            return o.p - this.p;
        }

        @Override
        public boolean equals(Object obj) {
            if(obj instanceof BC){
                BC o = (BC) obj;
                return this.x == o.x && this.y == o.y;
            }
            return false;
        }
    }

    static int TC, Time, BCNum;
    static int sum;
    static int[] moveA;
    static int[] moveB;
    static int[] curA = new int[2];
    static int[] curB = new int[2];

    static BC[] bcs;
    static StringTokenizer st;
    static BufferedReader br;

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("input.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        TC = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= TC; tc++) {
            reset();
            input();
            solve();
            sb.append(String.format("#%d %d%n", tc, sum));
        }
        System.out.println(sb);
    }

    private static void reset() {
        sum = 0;
        curA = new int[]{1, 1};
        curB = new int[]{10, 10};
    }

    private static void input() throws IOException {

        st = new StringTokenizer(br.readLine());
        Time = Integer.parseInt(st.nextToken());
        BCNum = Integer.parseInt(st.nextToken());
        moveA = new int[Time];
        moveB = new int[Time];
        bcs = new BC[BCNum];

        st = new StringTokenizer(br.readLine());
        for(int t = 0; t < Time; t++) {
            moveA[t] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int t = 0; t < Time; t++) {
            moveB[t] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < BCNum; i++) {
            st = new StringTokenizer(br.readLine());

            bcs[i] = new BC(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()));
        }
    }

    private static void solve() {
        for(int i = 0; i < Time; i++) {
            // 계산 로직
            sum += charge();
            moveTo(curA, moveA[i]);
            moveTo(curB, moveB[i]);
        }
        sum += charge();
    }

    private static int charge() {
        BC[] nearA = getNearBC(curA);
        BC[] nearB = getNearBC(curB);

        // 둘다 주변에 BC 없음
        if(nearA.length == 0 && nearB.length == 0) return 0;

        Arrays.sort(nearA);
        Arrays.sort(nearB);
        // 둘중 하나의 주변에 BC 없음
        if(nearA.length == 0) return nearB[0].p;
        if(nearB.length == 0) return nearA[0].p;

        // 둘다 가장 큰 BC가 서로 다름
        if(!nearB[0].equals(nearA[0])) return nearA[0].p + nearB[0].p;

        // 같은 BC 하나에만 A, B둘다 인접함
        if(nearA.length == 1 && nearB.length == 1) return nearA[0].p;

        // A, B둘중 하나만 1개 BC에 인접
        if(nearA.length == 1) return nearA[0].p + nearB[1].p;
        if(nearB.length == 1) return nearA[1].p + nearB[0].p;

        // A, B 둘다 여러 BC에 인접
        return Math.max(nearA[0].p + nearB[1].p, nearA[1].p + nearB[0].p);
    }

    private static BC[] getNearBC(int[] cur) {
        List<BC> near = new ArrayList<>();

        for(int i = 0; i < BCNum; i++) {
            if(getDis(cur, bcs[i]) <= bcs[i].c) {
                near.add(bcs[i]);
            }
        }
        return near.toArray(new BC[0]);
    }

    private static int getDis(int[] cur, BC bc) {
        int disX = Math.abs(cur[0] - bc.x);
        int disY = Math.abs(cur[1] - bc.y);
        return disX + disY;
    }

    private static void moveTo(int[] cur, int cmd) {
        switch(cmd) {
            case 1: cur[1]--; break; // 상
            case 2: cur[0]++; break; // 우
            case 3: cur[1]++; break; // 하
            case 4: cur[0]--; break; // 좌
            default: break; // 정지
        }
    }
}