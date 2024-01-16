package Baekjoon;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

// 단지번호붙이기 2667 S1
public class Solution2667 {

    static int n;
    static boolean[][] visited; // 노드 방문여부 표시
    static boolean[][] mat; // 인풋 배열 저장
    static int[][] resultMat; // 결과 배열 저장
    static int curAptNum; // 현재 아파트 단지 번호

    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, 1, -1};

    public static void main(String[] args) throws FileNotFoundException {

        System.setIn(new FileInputStream("input.txt"));
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        mat = new boolean[n][n];
        resultMat = new int[n][n];
        visited = new boolean[n][n];

        // 데이터 입력
        for(int i = 0; i < n; i++){
            String row = sc.next();
            for(int j = 0; j < n; j++){
                mat[i][j] = row.charAt(j) != '0';
            }
        }


        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                // 이미 방문한 노드 skip
                if(visited[i][j]) continue;

                // 처음 방문 && 아파트가 없는 노드
                if(!mat[i][j]) {
                    visited[i][j] = true;
                    continue;
                }

                // 처음 방문 && 아파트가 있는 노드
                bfs(i, j);
            }
        }

        // 결과 종합
        int[] answerArr = new int[curAptNum];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(resultMat[i][j] != 0) answerArr[resultMat[i][j] - 1]++; // 아파트의 단지 별 숫자 저장
            }
        }

        // 단지별 숫자 오름차순 정렬
        Arrays.sort(answerArr);

        // 결과 출력
        System.out.println(curAptNum);
        for(int res : answerArr) System.out.println(res);
    }

    private static void bfs(int idxI, int idxJ) {

        // bfs 탐색마다 단지 번호 증가
        curAptNum++;
        Queue<int[]> q = new LinkedList<>();

        // 시작 아파트 방문 체크
        visited[idxI][idxJ] = true;
        resultMat[idxI][idxJ] = curAptNum;
        q.add(new int[]{idxI, idxJ});

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int nowI = cur[0];
            int nowJ = cur[1];

            for(int i = 0; i < 4; i++){
                int nextI = nowI + di[i];
                int nextJ = nowJ + dj[i];

                // map 바깥쪽 예외처리
                if(nextI < 0 || nextJ < 0 || nextI >= n || nextJ >= n) continue;
                // 이미 방문한 노드 or 아파트가 없는 노드 skip
                if(visited[nextI][nextJ] || !mat[nextI][nextJ]) continue;

                // 큐에 저장
                q.add(new int[]{nextI, nextJ});
                resultMat[nextI][nextJ] = curAptNum;
                visited[nextI][nextJ] = true;
            }
        }
    }
}