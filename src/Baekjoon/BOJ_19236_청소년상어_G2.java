package Baekjoon;

import java.io.*;
import java.util.*;

/*
실행 시간 : 76ms
메 모 리 : 11656KB
*/

public class BOJ_19236_청소년상어_G2 {

    static class Data{

        // 물고기가 없는 칸 : 0
        // 상어가 있는 칸 : -1
        // 나머지 : 1~16
        int cnt;
        int dir;

        public Data(int dir, int cnt) {
            this.dir = dir;
            this.cnt = cnt;
        }

        @Override
        public String toString() {
            return String.format("(%d, %d) ", cnt, dir);
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int ans;
    static int[] di = {-99, -1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dj = {-99, 0, -1, -1, -1, 0, 1, 1, 1};

    private static Data[][] input() throws IOException {

        Data[][] map = new Data[4][4];

        for(int i = 0; i < 4; i++){
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 4; j++) {
                int order = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken());
                map[i][j] = new Data(dir, order);
            }
        }
        return map;
    }

    private static boolean moveSingleFish(Data[][] map, int ci, int cj) {

        // 물고기 인접한 셀로 이동시키는 로직
        int dir = map[ci][cj].dir;
        for (int iter = 0; iter < 8; iter++) {
            int ni = ci + di[dir], nj = cj + dj[dir];

            // 화살표가 가리키는 셀이 바깥 OR 상어위치
            if(ni < 0 || nj < 0 || ni >= 4 || nj >= 4 || map[ni][nj].cnt == -1){
                if(dir == 8) dir = 1;
                else dir += 1;
                continue;
            }

            map[ci][cj].dir = dir;
            if(map[ni][nj].cnt == 0){
                map[ni][nj].dir = dir;
                map[ni][nj].cnt = map[ci][cj].cnt;
                map[ci][cj].cnt = 0;
            }else{
                Data tempD = map[ci][cj];
                map[ci][cj] = map[ni][nj];
                map[ni][nj] = tempD;
            }
            return true;
        }

        return false;
    }

    private static void moveFishes(Data[][] map){

        int order = 1;
        while(order <= 16){

            OneFishMove:
            for(int i = 0; i < 4; i++){
                for (int j = 0; j < 4; j++) {
                    if(map[i][j].cnt == order){

                        if(moveSingleFish(map, i, j))
                            break OneFishMove;
                    }
                }
            }
            order++;
        }
    }

    private static Data[][] copyMap(Data[][] d){
        Data[][] res = new Data[4][4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                res[i][j] = new Data(d[i][j].dir, d[i][j].cnt);
            }
        }

        return res;
    }

    private static void dfs(Data[][] map, int si, int sj, int sum){

        // moveFish
        moveFishes(map);

        // find shark move Pos
        int sharkDir = map[si][sj].dir;
        boolean isSharkMove = false;
        int ni = si, nj = sj;
        do{
            ni += di[sharkDir];
            nj += dj[sharkDir];

            // 반드시 맵 밖으로 나가는 경우가 발생 -> while 탈출 가능
            if(ni < 0 || nj < 0 || ni >= 4 || nj >= 4) break;
            // 물고기가 없는 칸은 skip
            if(map[ni][nj].cnt == 0) continue;

            isSharkMove = true;
            Data[][] copiedMap = copyMap(map);
            int eatFish = copiedMap[ni][nj].cnt;
            copiedMap[si][sj].cnt = 0;
            copiedMap[ni][nj].cnt = -1;

            dfs(copiedMap, ni, nj, sum + eatFish);

        }while (true);


        // compare sum with ans
        if(!isSharkMove){
            ans = Math.max(ans, sum);
        }
    }
    public static void main(String[] args) throws IOException {

        Data[][] map = input();

        // eat fish (0,0)
        int eaten = map[0][0].cnt;

        // update map
        map[0][0].cnt = -1;
        dfs(map, 0, 0, eaten);

        System.out.println(ans);
    }
}