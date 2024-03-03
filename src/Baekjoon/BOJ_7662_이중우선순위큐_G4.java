package Baekjoon;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-03-03 13:51
종료 시간 : 24-03-03 14:47
실행 시간 : 3260ms
메 모 리 : 472952KB
*/

public class BOJ_7662_이중우선순위큐_G4 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringJoiner sj = new StringJoiner("\n");

    static int T, K;
    static PriorityQueue<Long> minPQ, maxPQ;
    static Map<Long, Integer> map;
    static int totalNum;

    private static void insert(long val){
        if(map.containsKey(val)){
            map.put(val, map.get(val)+1);
        }else{
            map.put(val, 1);
            minPQ.offer(val);
            maxPQ.offer(val);
        }
    }

    private static boolean delete(int flag){

        if (totalNum <= 0) return false;

        // 최대값 삭제
        if(flag == 1){

            long val = maxPQ.peek();

            while (!map.containsKey(val)){
                maxPQ.poll();
                val = maxPQ.peek();
            }

            if(map.get(val) == 1){
                map.remove(val);
                maxPQ.poll();
            }else{
                map.put(val, map.get(val)-1);
            }
        // 최솟값 삭제
        }else{
            long val = minPQ.peek();

            while (!map.containsKey(val)){
                minPQ.poll();
                val = minPQ.peek();
            }

            if(map.get(val) == 1){
                map.remove(val);
                minPQ.poll();
            }else{
                map.put(val, map.get(val)-1);
            }

        }
        return true;
    }
    public static void main(String[] args) throws IOException {

        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            minPQ = new PriorityQueue<>();
            maxPQ = new PriorityQueue<>(Collections.reverseOrder());
            map = new HashMap<>();
            totalNum = 0;

            K = Integer.parseInt(br.readLine());

            for(int k = 0; k < K; k++){
                st = new StringTokenizer(br.readLine());
                String cmd = st.nextToken();
                int val = Integer.parseInt(st.nextToken());

                if(cmd.equals("I")){
                    totalNum++;
                    insert(val);
                }else{
                    if(delete(val)) totalNum--;
                }
            }
            if(totalNum == 0) sj.add("EMPTY");
            else {
                while(!map.containsKey(maxPQ.peek())) maxPQ.poll();
                while (!map.containsKey(minPQ.peek())) minPQ.poll();

                sj.add(maxPQ.peek() + " " + minPQ.peek());
            }
        }

        bw.write(String.valueOf(sj));
        bw.close();
        br.close();

    }
}