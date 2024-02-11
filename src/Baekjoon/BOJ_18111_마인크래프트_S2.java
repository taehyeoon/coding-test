package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.StringTokenizer;

/*
시작 시간 : 24-02-11 20:08
종료 시간 : 24-02-11 21:15
실행시간 : 492ms
메 모 리 : 34452KB

고려사항
땅이 평탄화될 수 있는 높이(h)는 최소 높이 ~ B개의 블럭을 모두 이용했을 때의 최대 높이로 설정하였습니다
해당 범위 내에서 소요되는 시간을 계산한 후,
최소 시간에 해당하는 높이를 함께 출력하였습니다.
풀이 과정에서는 h의 최대값을 B개의 블럭을 모두 이용했을 때까지 포함하였지만
실제로는 초기 땅의 높이중 가장 높은 값을 설정하여, 계산과정을 더 줄일 수 있었습니다.
*/

public class BOJ_18111_마인크래프트_S2 {

    static int N, M, B, total, minH = Integer.MAX_VALUE;
    static int[][] map;

    private static void input() throws IOException {
        System.setIn(Files.newInputStream(Paths.get("input.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                total += map[i][j];
                if(map[i][j] < minH) minH = map[i][j];
            }
        }
    }

    private static int[] solve() {

        int upperH = Math.floorDiv(total + B, N*M);
        upperH = Math.min(upperH, 256);
        int time = Integer.MAX_VALUE;
        int maxH = 0;

        for(int h = minH; h <= upperH; h++){
            int newTime = getTime(h);
            if(newTime <= time){
                time = newTime;
                maxH = h;
            }
        }

        return new int[]{time, maxH};
    }

    private static int getTime(int h){
        int time = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] > h) time += 2 * (map[i][j] - h);
                else if(map[i][j] < h) time += h - map[i][j];
            }
        }
        return time;
    }

    public static void main(String[] args) throws IOException {
        input();
        int[] result = solve();
        System.out.println(result[0] + " " + result[1]);
    }
}
