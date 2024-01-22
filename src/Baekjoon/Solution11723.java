package Baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
백준 집합 11723 S5
시작 시간 : 24-01-23 01:25
종료 시간 : 24-01-23 01:45
실행시간 : 1036ms

고려사항
시간초과 해결방법
1. 집합에 추가 및 삭제를 비트연산자를 통해 실행시간을 단축했습니다.
2. 문자열을 scanner대신 readBuffer를 통해 입력받으며,
   출력할때, System.out.println() 대신에 stringBuilder를 사용하여
   실행 시간을 단축시켰습니다.

메모리초과
명렁어를 읽어들이고나서, 따로 리스트에 저장하는 것이 아닌,
입력받는 순간 바로 명령어를 실행합니다.
*/

public class Solution11723 {

    static int union, N;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            int x = 0;
            if(!cmd.equals("empty") && !cmd.equals("all")) x = Integer.parseInt(st.nextToken());
            switch (cmd){
                case "add":
                    union |= (1 << x);
                    break;
                case "remove":
                    union &= ~(1 << x);
                    break;
                case "check":
                    if((union & (1 << x)) >> x == 0) sb.append(0+"\n");
                    else sb.append(1+"\n");
                    break;
                case "toggle":
                    if((union & (1 << x)) >> x == 0) union |= (1<<x);
                    else union &= ~(1 << x);
                    break;
                case "all":
                    union = (1 << 21) - 1;
                    break;
                case "empty":
                    union = 0;
                    break;
            }
        }
        System.out.print(sb);
    }
}