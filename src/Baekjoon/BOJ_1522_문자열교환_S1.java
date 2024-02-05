package Baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/*
시작 시간 : 24-02-04 02:40
종료 시간 : 24-02-05 20:00
실행 시간 : 76ms / 실패
메 모 리 : 11,492KB

고려사항
문자열에 모든 'a'가 연속으로 나타나기 위해 b와 바꾸는 최소 횟수를 구하는 문제였습니다
a의 개수가 k개라고 할 때, 문자열의 0~k-1번째까지 b의 개수를 구할수 있습니다,
만약 b가 3개라면 a가 0~k-1구간에 모여있는 경우 3번의 교환이 필요하다고 생각할 수 있습니다
순차적으로 오른쪽으로 윈도우슬라이딩하며, b의 개수가 최소가 되는 값이 전체 교환의 최소입니다
*/

public class BOJ_1522_문자열교환_S1 {

    static int aNum;
    static String input;
    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        input = br.readLine();
        int strLen = input.length();
        int ans = Integer.MAX_VALUE;

        for(char c : input.toCharArray()){
            if(c == 'a') aNum++;
        }

        for(int i = 0; i <= strLen; i++){
            int cnt = 0;

            for(int j = i; j < i+aNum; j++){
                if(input.charAt(j%strLen) == 'b') cnt++;
            }

            ans = Math.min(ans, cnt);
        }
        System.out.println(ans);
    }
}