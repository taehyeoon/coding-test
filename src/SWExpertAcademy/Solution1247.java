package SWExpertAcademy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

// [S/W 문제해결 응용] 3일차 - 최적 경로 D5
// 23-01-14 try 1
public class Solution1247 {

    static class Pair {
        public int x;
        public int y;

        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int minDis;
    static Pair start;
    static Pair end;
    static ArrayList<Pair> nodes;

    public static void main(String[] args) throws FileNotFoundException {

        System.setIn(new FileInputStream("input.txt"));

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int test_case = 1; test_case < T + 1; test_case++){

            int n = sc.nextInt();
            minDis = Integer.MAX_VALUE;

            start = new Pair(sc.nextInt(), sc.nextInt());
            end = new Pair(sc.nextInt(), sc.nextInt());
            nodes = new ArrayList<>(n);

            for(int i = 0; i < n; i++){
                nodes.add(new Pair(sc.nextInt(), sc.nextInt()));
            }

            dp(start, 0, nodes, n);

            System.out.println("#" + test_case + " " + minDis);
        }
    }

    public static void dp(Pair curNode, int curDis, ArrayList<Pair> left_nodes, int left_node_cnt){
        if(left_node_cnt == 1){
            curDis += calcDistance(curNode, left_nodes.get(0));
            curDis += calcDistance(left_nodes.get(0), end);

            if(curDis < minDis) minDis = curDis;
            return;
        }

        for(int i = 0; i < left_node_cnt; i++){

            ArrayList<Pair> copy_nodes = (ArrayList<Pair>) left_nodes.clone();
            copy_nodes.remove(i);
            dp(left_nodes.get(i), curDis + calcDistance(curNode, left_nodes.get(i)),  copy_nodes, left_node_cnt - 1);
        }
    }

    public static int calcDistance(Pair a, Pair b){
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }
}