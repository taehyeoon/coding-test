package Baekjoon;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 유기농배추 1012 S2
public class Solution1012 {

    static int n, m, k; // 세로 가로 배추개수
    static boolean[][] visited; // 노드 방문여부 표시
    static boolean[][] mat; // 인풋 배열 저장
    static int curWormNum;

    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, 1, -1};

    public static void main(String[] args) throws FileNotFoundException {

        System.setIn(new FileInputStream("input.txt"));
        Scanner sc = new Scanner(System.in);

        int test_case = sc.nextInt();

        for(int t = 0; t < test_case; t++){

            n = sc.nextInt();
            m = sc.nextInt();
            k = sc.nextInt();
            curWormNum = 0;

            mat = new boolean[n][m];
            visited = new boolean[n][m];

            // 데이터 입력
            for(int iter = 0; iter < k; iter++){
                mat[sc.nextInt()][sc.nextInt()] = true;
            }

            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    // 이미 방문한 노드 skip
                    if(visited[i][j]) continue;

                    // 처음 방문 && 배추가 없는 노드
                    if(!mat[i][j]) {
                        visited[i][j] = true;
                        continue;
                    }

                    // 처음 방문 && 배추가 있는 노드
                    bfs(i, j);
                }
            }

            // 결과 출력
            System.out.println(curWormNum);
        }
    }

    private static void bfs(int idxI, int idxJ) {

        // bfs 탐색마다 단지 번호 증가
        curWormNum++;
        Queue<int[]> q = new LinkedList<>();

        // 시작 배추 방문 체크
        visited[idxI][idxJ] = true;
        q.add(new int[]{idxI, idxJ});

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int nowI = cur[0];
            int nowJ = cur[1];

            for(int i = 0; i < 4; i++){
                int nextI = nowI + di[i];
                int nextJ = nowJ + dj[i];

                // map 바깥쪽 예외처리
                if(nextI < 0 || nextJ < 0 || nextI >= n || nextJ >= m) continue;
                // 이미 방문한 노드 or 배추가 없는 노드 skip
                if(visited[nextI][nextJ] || !mat[nextI][nextJ]) continue;

                // 큐에 저장
                q.add(new int[]{nextI, nextJ});
                visited[nextI][nextJ] = true;
            }
        }
    }
}