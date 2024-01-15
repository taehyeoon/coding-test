package Baekjoon;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

// DFS와 BFS S2
public class Solution1260 {

    static int n, m, start;
    static ArrayList<ArrayList<Integer>> mat;
    static boolean[] isVisits;
    static Queue<Integer> q;
    public static void main(String[] args) throws FileNotFoundException {

        System.setIn(new FileInputStream("input.txt"));

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();
        q = new LinkedList<>();

        mat = new ArrayList<>(n + 1);
        isVisits = new boolean[n + 1];

        for(int i = 0; i <= n; i++) mat.add(new ArrayList<Integer>());

        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            mat.get(a).add(b);
            mat.get(b).add(a);
        }

        // 오름차순 정렬
        for(int i = 1; i <= n; i++){
            Collections.sort(mat.get(i));
        }

        dfs(start);
        System.out.println();
        bfs(start);

    }

    private static void bfs(int node) {
        boolean[] visited = new boolean[n + 1];
        LinkedList<Integer> queue = new LinkedList<>();

        visited[node] = true;
        queue.add(node);

        while(queue.size() != 0){
            node = queue.poll();
            System.out.print(node + " ");


            for(int i = 0; i < mat.get(node).size(); i++){
                if(!visited[mat.get(node).get(i)]){
                    visited[mat.get(node).get(i)] = true;
                    queue.add(mat.get(node).get(i));

                }
            }

        }

    }

    static void dfs(int node){
        isVisits[node] = true;
        System.out.print(node + " ");

        for(int i = 0; i < mat.get(node).size(); i++){
            if(!isVisits[mat.get(node).get(i)]) dfs(mat.get(node).get(i));
        }
    }

}