package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-03-25 19:23
종료 시간 : 24-03-25
실행 시간 : ms
메 모 리 : KB
*/

public class BOJ_1076_저항_B2 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        Map<String, Integer> val = new HashMap<>();
        Map<String, Integer> mul = new HashMap<>();

        String[] color = new String[]{"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};

        for (int v = 0, m = 1; v < color.length; v++, m *=10) {
            val.put(color[v], v);
            mul.put(color[v], m);
        }

        String str = br.readLine();
        long result = val.get(str);
        str = br.readLine();
        result = 10*result + val.get(str);
        str = br.readLine();
        result *= mul.get(str);

        System.out.println(result);

    }
}