package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/*
시작 시간 : 24-0
종료 시간 : 24-0
실행 시간 : ms
메 모 리 : KB
*/

public class BOJ_1440_타임머신 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Set<String> set = new HashSet<>();
    static boolean[] isSelected = new boolean[3];
    static int[] data = new int[3], time = new int[3];
    static int ans;

    public static void main(String[] args) throws IOException {

        String input = br.readLine();

        for (int i = 0; i < 3; i++) {
            time[i] = Integer.parseInt(input.split(":")[i]);
        }

        per(0);

        System.out.println(ans);
    }

    private static void per(int x) {
        if(x == 3){
            // check
            ans += check() ? 1 : 0;
            return;
        }

        for (int i = 0; i < 3; i++) {
            if(!isSelected[i]) {
                isSelected[i] = true;
                data[x] = time[i];
                per(x + 1);
                isSelected[i] = false;
            }
        }

    }

    private static boolean check() {

        String temp = data[0] + ":" + data[1] + ":" + data[2];
        if(set.contains(temp)) {
            return true;
        }

        if(data[0] >= 1 && data[0] <= 12
            && data[1] >= 0 && data[1] < 60
            && data[2] >= 0 && data[2] < 60) {

            set.add(temp);
            return true;
        }

        return false;


    }
}