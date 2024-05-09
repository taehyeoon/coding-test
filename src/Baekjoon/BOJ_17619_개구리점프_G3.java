import java.io.*;
import java.util.*;

/*
시작 시간 : 24-05-02 11:32
종료 시간 : 24-05-02 17:33
실행 시간 : 848ms / 실패
메 모 리 : 81392KB
*/

public class BOJ_17619_개구리점프_G3 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, Q;
    static int[][] lines;
    static int[][] ques;

    static int[] parents;

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        parents = new int[N];
        for (int i = 0; i < N; i++) {
            parents[i] = i;
        }
        lines = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            lines[i][0] = x1;
            lines[i][1] = x2;
            lines[i][2] = i;
        }

        ques = new int[Q][2];
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            ques[i][0] = x1;
            ques[i][1] = x2;
        }
    }

    public static void main(String[] args) throws Exception {
        input();

        Arrays.sort(lines, (o1, o2) -> {
            if(o1[0] != o2[0]) return o1[0] - o2[0];
            else return o1[1] - o2[1];
        });

        int endPoint = lines[0][1];
        for (int i = 1; i < N; i++) {
            if(lines[i][0] <= endPoint) {
                parents[lines[i][2]] = parents[lines[i-1][2]];
                if(lines[i][1] > endPoint)
                    endPoint = lines[i][1];
            }else{
                endPoint = lines[i][1];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            if(parents[ques[i][0]-1] == parents[ques[i][1]-1]) {
                sb.append("1\n");
            }else{
                sb.append("0\n");
            }
        }

        System.out.println(sb);
    }
}
