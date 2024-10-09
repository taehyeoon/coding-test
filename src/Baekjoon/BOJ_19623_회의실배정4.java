package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
시작 시간 : 24-0
종료 시간 : 24-0
실행 시간 : ms
메 모 리 : KB
*/

public class BOJ_19623_회의실배정4 {

    static class Meet implements Comparable<Meet> {
        int s, e, h;
        public Meet(int s, int e, int h) {
            this.s = s;
            this.e = e;
            this.h = h;
        }

        @Override
        public int compareTo(Meet o) {
            if(this.e != o.e) return Integer.compare(this.e, o.e);
            return Integer.compare(this.s, o.s);
        }

        @Override
        public String toString() {
            return "Meet{" +
                "s=" + s +
                ", e=" + e +
                ", h=" + h +
                '}';
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static Meet[] meets;
    static int[] max, min;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());

        meets = new Meet[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            meets[i] = new Meet(s, e, h);
        }

        Arrays.sort(meets);

        max = new int[N];
        min = new int[N];

        Arrays.fill(max, -1);
        Arrays.fill(min, -1);
        max[0] = meets[0].h;
        min[0] = 0;


        System.out.println(Math.max(calcMax(N-1), calcMin(N-1)));
    }

    private static int calcMax(int x){

        if(max[x] != -1) return max[x];

        int lo = 0, hi = x;

        while(lo + 1 < hi){
            int mid = (hi + lo) / 2;

            if(meets[mid].e <= meets[x].s) lo = mid;
            else hi = mid;
        }

        return max[x] = calcMax(lo) + meets[x].h;

        // for(int i = x-1; i >= 0; i--){
        //
        //     if(meets[i].e <= meets[x].s){
        //         return max[x] = calcMax(i) + meets[x].h;
        //     }
        // }
        // return max[x] = meets[x].h;

    }

    private static int calcMin(int x) {

        if(min[x] != -1) return min[x];

        return min[x] = Math.max(calcMax(x-1), calcMin(x-1));
    }
}