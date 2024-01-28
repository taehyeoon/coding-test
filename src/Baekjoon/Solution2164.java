package Baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
백준 카드2 2164 S4
시작 시간 : 24-01-28 10:20
종료 시간 : 24-01-28 10:30
실행시간 : 156ms

고려사항
List에 추가와 삭제가 빈번하게 나타나는 경우의 문제입니다.
ArrayList는 현재 최대 capacity인 경우 element를 더 추가하게되면,
더 큰 capacity를 정의하고, 기존 배열을 copy한 뒤 새로운 element를 add하게 됩니다
이때 copy하는 과정에서 시간을 많이 소모하게 됩니다.
따라서 이 문제는 ArrayList 대신 LinkedList를 이용해여 해결할 수 있었습니다.
*/

public class Solution2164 {

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<Integer> arr = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            arr.add(i + 1);
        }

        while (arr.size() > 1) {
            arr.remove(0);
            int second = arr.remove(0);
            arr.add(second);
        }

        System.out.println(arr.get(0));
    }
}
