package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
시작 시간 : 24-0
종료 시간 : 24-0
실행 시간 : ms
메 모 리 : KB
*/

public class BOJ_2310_어드벤처게임_G4 {

    static class Room {

        char type;
        int cost;
        List<Integer> toList = new ArrayList<>();
        boolean visit;

        public Room(char type, int cost, List<Integer> toList) {
            this.type = type;
            this.cost = cost;
            this.toList = toList;
            this.visit = false;
        }

        @Override
        public String toString() {
            return "Room{" +
                    "type=" + type +
                    ", cost=" + cost +
                    ", toList=" + toList +
                    ", visit=" + visit +
                    '}';
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N;
    static Room[] rooms;
    static boolean result;

    private static void input() throws IOException{
        N = Integer.parseInt(br.readLine());
        if(N == 0) return;
        rooms = new Room[N+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            char type = st.nextToken().charAt(0);
            int cost = Integer.parseInt(st.nextToken());
            List<Integer> toList = new ArrayList<>();
            String token = "";
            while (true){
                token = st.nextToken();
                if(token.equals("0")) break;
                toList.add(Integer.parseInt(token));
            }
            rooms[i] = new Room(type, cost, toList);
        }
    }

    static void move(int start, int money){
        if(rooms[start].type == 'T') money -= rooms[start].cost;
        else{
            if(money < rooms[start].cost){
                money = rooms[start].cost;
            }
        }

        if(money >= 0){
            if(start == N){
                System.out.println("Yes");
                result = true;
            }

            rooms[start].visit = true;

            for(int i = 0; i<rooms[start].toList.size(); i++){
                if(!rooms[rooms[start].toList.get(i)].visit){
                    move(rooms[start].toList.get(i), money);
                }
            }

            rooms[start].visit = false;
        }

        else {
            if(rooms[start].type == 'T') money += rooms[start].cost;
            return;
        }
    }

    public static void main(String[] args) throws IOException {

        while (true){
            input();
            if(N == 0) break;

            move(1, 0);

            if(!result) System.out.println("No");
        }
    }
}