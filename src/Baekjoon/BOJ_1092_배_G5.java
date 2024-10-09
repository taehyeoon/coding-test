package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-0
종료 시간 : 24-0
실행 시간 : ms
메 모 리 : KB
*/

public class BOJ_1092_배_G5 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());
        Integer[] crains = new Integer[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            crains[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        LinkedList<Integer> boxes = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            boxes.add(Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(crains, Collections.reverseOrder());
        boxes.sort(Collections.reverseOrder());

        if(crains[0] < boxes.get(0)){
            System.out.println(-1);
            return;
        }

        int time = 0;

        Find:
        while(true){
            time++;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < boxes.size(); j++) {
                    int curBox = boxes.get(j);
                    if(curBox <= crains[i]) {
                        boxes.remove(j);
                        break;
                    }
                }
                if(boxes.isEmpty()) break Find;
            }
        }

        System.out.println(time);
    }
}