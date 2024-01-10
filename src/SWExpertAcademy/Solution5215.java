package SWExpertAcademy;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileInputStream;


// 푼 방법: DFS 탐색
public class Solution5215 {

    static int n, l, result;
    static int[][] info;
    static boolean[] check;

    public static void main(String[] args) throws FileNotFoundException {

        System.setIn(new FileInputStream("input.txt"));

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++) {
            n = sc.nextInt();
            l = sc.nextInt();
            info = new int[n][2];
            check = new boolean[n];
            result = 0;


            for (int i = 0; i < n; i++) {
                info[i][0] = sc.nextInt();
                info[i][1] = sc.nextInt();
            }

            dfs(0, true);
            dfs(0, false);

            System.out.println("#" + test_case + " " + result);
        }
    }

    private static void dfs(int idx, boolean val) {

        if(idx == n) {
            int score_sum = 0;
            int cal_sum = 0;
            for(int i = 0; i < n; i++){
                if(check[i]){
                    score_sum += info[i][0];
                    cal_sum += info[i][1];
                }
            }
            if(cal_sum <= l &&  score_sum > result) result = score_sum;
            return;
        }

        check[idx] = val;
        dfs(idx + 1, true);
        dfs(idx + 1, false);
    }
}
