package Baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
백준 AC 5430 G5
시작 시간 : 24-01-29 19:20
종료 시간 : 24-01-29 -----
실행시간 : 732ms / 실패

고려사항
답안 참조
구현문제로 생각을 코드로 표현하는 것이 중요한 문제였습니다.
문제에서 배열을 뒤집는다고 명시되어 있지만, 구현시에는 deque를 이용해서 현재 앞부분이
어디인지에 따라서 왼쪽 혹은 오른쪽에서 원소를 삭제하면 됩니다.

deque의 pollLast, pollFirst를 사용해서 더이상 제거할 수 있는 경우가 없으면
null이 리턴되는 것을 이용하여 error처리를 하였습니다.

출력이 많은 것으로 예상되었기에 StringBuilder를 사용했습니다.
*/

public class Solution5430 {

    static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        while(tc-- > 0){

            char[] cmd = br.readLine().toCharArray(); // command
            int n = Integer.parseInt(br.readLine()); // n;
            Deque<Integer> dq;
            if(n == 0){
                dq = new ArrayDeque<>();
                br.readLine(); // list
            }else{

                String line = br.readLine(); // list
                line = line.substring(1, line.length()-1);

                dq = new ArrayDeque<>(n);

                for(String s : line.split(",")){
                    dq.addLast(Integer.parseInt(s));
                }

            }

            calcAns(dq, cmd);
        }
        System.out.println(sb);
    }

    private static void calcAns(Deque<Integer> dq, char[] cmd) {

        boolean isRight = false;
        for(char c : cmd){
            if(c == 'R') isRight = !isRight;
            else{
                if(isRight){
                    if(dq.pollLast() == null){
                        sb.append("error\n");
                        return;
                    }
                }else{
                    if(dq.pollFirst() == null){
                        sb.append("error\n");
                        return;
                    }
                }
            }
        }

        makeStr(dq, isRight);
    }

    private static void makeStr(Deque<Integer> dq, boolean isRight) {
        if(dq.isEmpty()){
            sb.append("[]\n");
            return;
        }

        sb.append('[');
        if(isRight){
            int num = dq.pollLast();
            sb.append(num);
            while(!dq.isEmpty()){
                sb.append(',').append(dq.pollLast());
            }
        }else{
            int num = dq.pollFirst();
            sb.append(num);
            while(!dq.isEmpty()){
                sb.append(',').append(dq.pollFirst());
            }
        }
        sb.append("]\n");
    }
}