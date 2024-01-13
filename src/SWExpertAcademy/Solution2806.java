package SWExpertAcademy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

// N-Queen D3
// 23-01-13 try 1
// 23-01-14 try 2
// DFS 탐색
public class Solution2806 {

    static int[] mat;
    static int result;
    static int n;

    public static void main(String[] args) throws FileNotFoundException {

        System.setIn(new FileInputStream("input.txt"));

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int test_case = 1; test_case < T + 1; test_case++){

            result = 0;
            n = sc.nextInt();
            mat = new int[n];


            dfs(0);


            System.out.println("#" + test_case + " " + result);
        }
    }

    private static void dfs(int level) {

        // 마지막 줄인 경우
        if(level == n) {
            result++;
            return;
        }

        for(int i = 0; i < n; i++){
            mat[level] = i;
            if(isPossible(level)){
                dfs(level + 1);
            }
        }

    }

    private static boolean isPossible(int level) {
        for(int i = 0; i < level; i++){
            if(mat[i] == mat[level] || level - i == Math.abs(mat[level]- mat[i])){
                return false;
            }
        }
        return true;
    }
}