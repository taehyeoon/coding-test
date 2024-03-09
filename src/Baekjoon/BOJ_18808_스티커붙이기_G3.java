package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
시작 시간 : 24-03-09 14:00
종료 시간 : 24-03-09 15:10
실행 시간 : 116ms
메 모 리 : 12464KB
*/

public class BOJ_18808_스티커붙이기_G3 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int H, W, K, ans, curStickerSize;
    static int[] stickerSize;
    static int[][][] sticker;
    static int[][] map, curSticker;
    static int ph, pw;

    private static void input() throws IOException{
        st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[H][W];
        sticker = new int[K][][];
        stickerSize = new int[K];

        for (int sti = 0; sti < K; sti++) {
            st = new StringTokenizer(br.readLine());
            int sh = Integer.parseInt(st.nextToken());
            int sw = Integer.parseInt(st.nextToken());

            sticker[sti] = new int[sh][sw];
            int area = 0;
            for (int i = 0; i < sh; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < sw; j++) {
                    sticker[sti][i][j] = Integer.parseInt(st.nextToken());
                    if(sticker[sti][i][j] == 1) area++;
                }
            }
            stickerSize[sti] = area;
        }
    }

    private static boolean canStickAtPos(int si, int sj){

        for (int i = 0; i < ph; i++) {
            for (int j = 0; j < pw; j++) {
                if(curSticker[i][j] == 1 && map[si+i][sj+j] == 1) return false;
            }
        }

        return true;
    }

    // if can stick it, return [left, top] pos
    // else return [-1, -1]
    private static int[] canStick(){

        for (int i = 0; i <= H-ph; i++) {
            for (int j = 0; j <= W-pw; j++) {

                if(canStickAtPos(i, j))
                    return new int[]{i, j};
            }
        }

        return new int[]{-1, -1};
    }

    private static void stickIt(int si, int sj){

        for (int i = 0; i < ph; i++) {
            for (int j = 0; j < pw; j++) {
                if(curSticker[i][j] == 0) continue;
                map[si+i][sj+j] = 1;
            }
        }
    }

    private static void turn(){

        int oldH = curSticker.length;
        int oldW = curSticker[0].length;

        int[][] arr = new int[oldW][oldH];
        for (int i = 0; i < oldW; i++) {
            for (int j = 0; j < oldH; j++) {
                arr[i][j] = curSticker[oldH-1-j][i];
            }
        }
        curSticker = arr;
    }

    private static boolean solve(){

        ph = curSticker.length;
        pw = curSticker[0].length;
        int[] result = canStick();
        if(result[0] != -1){
            stickIt(result[0], result[1]);
            ans += curStickerSize;
            return true;
        }
        return false;
    }
    public static void main(String[] args) throws IOException {

        input();

        for (int i = 0; i < K; i++) {
            curStickerSize = stickerSize[i];
            curSticker = sticker[i];

            if(solve()) continue;

            // 90도
            turn();
            if(solve()) continue;

            // 180도
            turn();
            if(solve()) continue;

            // 270도
            turn();
            if(solve()) continue;
        }

        System.out.println(ans);
    }
}