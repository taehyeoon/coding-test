package SWExpertAcademy;

/*
시작 시간 : 24-01-31 22:55
종료 시간 : 24-01-31 23:55
실행 시간 : 114ms

고려사항
1. 좌상단에서 시작
2. 처음 달팽이가 움직이는 방향은 오른쪽
3. 달팽이가 이미 방문한 노드를 만나거나, 맵 밖으로 나간다면
4. 현재 방향에서 오른쪽으로 90회전한다.
5. 3~4번 과정을 반복
*/

import java.io.*;

public class SWEA_1954_달팽이숫자_D2 {
    static int n;
    static int[][] dir = {{0,1}, {1,0}, {0,-1}, {-1,0}}; // 우 하 좌 상
    static int[][] data;
    static boolean[][] isVisited;
    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        for(int tcidx = 1; tcidx <= tc; tcidx++){

            n = Integer.parseInt(br.readLine());
            isVisited = new boolean[n][n];
            data = new int[n][n];
            int curI = 0, curJ = 0;
            int val = 1;
            int curDirIdx = 0;
            while(val <= n*n){
                data[curI][curJ] = val;
                isVisited[curI][curJ] = true;

                int tempI = curI + dir[curDirIdx][0];
                int tempJ = curJ + dir[curDirIdx][1];
                if(tempI < 0 || tempJ < 0 || tempI >= n || tempJ >= n || isVisited[tempI][tempJ]) {
                    curDirIdx = (curDirIdx + 1) % 4;
                    curI += dir[curDirIdx][0];
                    curJ += dir[curDirIdx][1];
                }else{
                    curI = tempI;
                    curJ = tempJ;
                }
                val++;
            }

            System.out.printf("#%d%n", tcidx);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(data[i][j] + " ");
                }
                System.out.println();
            }
        }



    }
}
