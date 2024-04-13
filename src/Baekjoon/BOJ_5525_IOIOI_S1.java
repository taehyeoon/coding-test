package Baekjoon;

import java.io.*;

/*
시작 시간 : 24-04-14 02:20
종료 시간 : 24-04-14 03:21
실행 시간 : 204ms
메 모 리 : 25324KB
*/

public class BOJ_5525_IOIOI_S1 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String line = br.readLine();

        boolean ok = false, stateO = false;
        int cnt = 0;

        for (int i = 0; i < m; i++) {
            if(ok && stateO){
                if(line.charAt(i) == 'I') cnt++;
                else ok = false;

                stateO = false;
                continue;
            }

            if(ok){
                if(line.charAt(i) == 'O') stateO = true;
                else{
                    ok = false;
                    i--;
                }
                continue;
            }

            if(i+2*n < m){

                boolean find = true;

                for (int j = 0; j < 2*n+1; j++) {
                    char t = j % 2 == 0 ? 'I' : 'O';
                    if(line.charAt(i) == t) {
                        i++;
                        continue;
                    }

                    if(line.charAt(i) == 'I') i--;

                    find = false;
                    break;
                }

                if(find) {
                    i--;
                    ok = true;
                    cnt++;
                }
            }
            else break;
        }

        System.out.println(cnt);
    }
}