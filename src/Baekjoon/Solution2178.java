package Baekjoon;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

// 미로탐색 S1
// 정답 참조
public class Solution2178 {

    static int n, m, mat[][];
    static boolean[][] isVisited;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws FileNotFoundException {

        System.setIn(new FileInputStream("input.txt"));

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        mat = new int[n][m];
        isVisited = new boolean[n][m];

        for(int i = 0; i < n;i++){
            String row = sc.next();
            for(int j = 0; j < m; j++){
                mat[i][j] = row.charAt(j) - '0';
            }
        }

        isVisited[0][0] = true;
        bfs(0,0);

        for(int i = 0; i < n;i++){
            for(int j = 0; j < m; j++){
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void bfs(int initX, int initY) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{initX, initY});

        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];

            for(int i = 0; i < 4; i++){
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) continue;
                System.out.println("sss");

                if(isVisited[nextX][nextY] || mat[nextX][nextY] == 0) continue;
                queue.add(new int[]{nextX, nextY});
                System.out.println("cur val : "+mat[nowX][nowY]);
                mat[nextX][nextY] = mat[nowX][nowY] + 1;
                isVisited[nextX][nextY] = true;
            }

        }
    }
}