package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
시작 시간 : 24-0
종료 시간 : 24-0
실행 시간 : ms
메 모 리 : KB
*/

public class BOJ_2879_코딩은예쁘게 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int[] input, diff;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        input = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        diff = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            diff[i] = input[i] - Integer.parseInt(st.nextToken());
        }

        System.out.println(fixIndent());
    }

    private static int fixIndent(){
        int cnt = 0;

        List<List<Integer>> group = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            group.add(new ArrayList<>());
        }

        int num = 0, before = 0, after = 0;
        if(diff[0] > 0) before = 1;
        else if(diff[0] == 0) before = 0;
        else before = -1;
        group.get(num).add(diff[0]);

        for (int i = 1; i < diff.length; i++) {
            if(diff[i] > 0) after = 1;
            else if(diff[i] < 0) after = -1;
            else before = 0;

            if(before == after) group.get(num).add(diff[i]);
            else {
                num++;
                group.get(num).add(diff[i]);
            }
            before = after;
        }

        for (List<Integer> integers : group){
            if(integers.isEmpty()) break;

            int sum = integers.stream().mapToInt(Integer::intValue).sum();
            while(sum != 0){
                int startIdx = 0;
                for(int i = 0; i < integers.size(); i++){
                    if(integers.get(i) != 0){
                        startIdx = i;
                        break;
                    }
                }
                for (int i = startIdx; i < integers.size(); i++) {
                    if(integers.get(i) != 0){
                        if(integers.get(i) > 0) integers.set(i, integers.get(i) - 1);
                        else                    integers.set(i, integers.get(i) + 1);
                    }
                    else{
                        break;
                    }
                }
                sum = integers.stream().mapToInt(Integer::intValue).sum();
                cnt++;
            }
        }

        return cnt;
    }
}