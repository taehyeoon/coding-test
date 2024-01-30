package Baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
백준 스위치켜고끄기 1244 S4
시작 시간 : 24-01-30 18:35
종료 시간 : 24-01-30 19:45
실행시간 : 80ms

고려사항
여학생과 남학생으로 분리하여 메소드를 작성하여 구현하였습니다.
여학생의 경우, 입력받은 스위치를 기준으로 좌우 left, right 포인터를 이용하여
대칭성을 계산하였습니다.
*/

public class Solution1244 {

    static int N, cmdNum;
    static boolean[] swi;
    static int[][] cmds;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 스위치 입력
        N = Integer.parseInt(br.readLine());
        swi = new boolean[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N ; i++){
            if(st.nextToken().equals("1")) swi[i] = true;
            else swi[i] = false;
        }

        // 명령어 입력
        cmdNum = Integer.parseInt(br.readLine());
        cmds = new int[cmdNum][2];
        for(int i = 0; i < cmdNum; i++){
            st = new StringTokenizer(br.readLine());
            cmds[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }

        for (int cmdIdx = 0; cmdIdx < cmdNum; cmdIdx++){
            // 남자
            if(cmds[cmdIdx][0] == 1){
                man(cmds[cmdIdx][1]);
            }else{
                // 여자
                girl(cmds[cmdIdx][1]);
            }

        }

        for(int i = 1; i <= N; i++){

            if(swi[i]) sb.append(1);
            else sb.append(0);
            sb.append(' ');


            if(i % 20 == 0) {
                sb.deleteCharAt(sb.length() - 1);
                sb.append("\n");
            }
        }
        sb.deleteCharAt(sb.length() -1);
        System.out.println(sb);

    }

    private static void girl(int x) {
        int l = x;
        int r = x;

        do{
            l--; r++;
            if(l <= 0 || r > N) break;

        }while(swi[l] == swi[r]);

        l++; r--;

        for(int i = l; i <= r; i++){
            swi[i] = !swi[i];
        }

    }

    private static void man(int x) {

        int d = x;
        while(x <= N){
            swi[x] = !swi[x];
            x += d;
        }
    }
}
