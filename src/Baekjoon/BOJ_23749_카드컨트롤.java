package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

/*
시작 시간 : 24-0
종료 시간 : 24-0
실행 시간 : ms
메 모 리 : KB
*/

public class BOJ_23749_카드컨트롤 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        int N = Integer.parseInt(br.readLine()); // 카드의 세트 수
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 카드를 저장할 배열
        boolean[] isO = new boolean[2 * N]; // O이면 true, X이면 false

        for (int i = 0; i < 2 * N; i++) {
            isO[i] = st.nextToken().equals("O");
        }

        // 최소 조작 횟수를 계산
        int result = cal(isO, 2 * N, N);
        System.out.println(result);
    }

    private static int cal(boolean[] isO, int total, int N) {
        // BFS 탐색을 위한 큐와 방문 확인을 위한 집합
        Queue<boolean[]> q = new LinkedList<>();
        q.offer(isO);
        Set<String> visited = new HashSet<>();
        visited.add(Arrays.toString(isO));

        int time = 0; // 조작 횟수

        // BFS 시작
        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                boolean[] now = q.poll();

                // 현재 상태에서 준석이가 이기면 종료
                if (isWin(now, total, N)) {
                    return time;
                }

                // 카드를 조작하는 모든 가능한 경우를 탐색
                for (int i = 0; i < total; i++) {
                    boolean[] next = change(i, now, total);

                    // 이미 방문한 상태는 탐색하지 않음
                    if (!visited.contains(Arrays.toString(next))) {
                        q.offer(next);
                        visited.add(Arrays.toString(next));
                    }
                }
            }
            time++; // 각 레벨 탐색이 끝날 때마다 조작 횟수를 증가시킴
        }
        return -1; // 준석이가 이길 수 없는 경우
    }

    // 카드를 i번째에서 맨 위로 이동시키는 함수
    private static boolean[] change(int index, boolean[] now, int n) {
        boolean[] temp = Arrays.copyOf(now, now.length);
        boolean flag = now[index]; // 선택된 카드를 저장
        // i번째 카드부터 한 칸씩 뒤로 이동
        for (int i = index; i > 0; i--) {
            temp[i] = temp[i - 1];
        }
        temp[0] = flag; // 선택된 카드를 맨 위로
        return temp;
    }

    // 현재 상태에서 준석이가 이기는지 확인하는 함수
    private static boolean isWin(boolean[] now, int n, int N) {
        int[] score = new int[2]; // score[0]은 준석이의 점수, score[1]은 수현이의 점수

        // 카드를 2개씩 비교하면서 점수 계산
        for (int i = 0; i < n; i += 2) {
            if (now[i] == now[i + 1]) {
                continue; // 무승부
            }
            if (now[i]) {
                score[0]++; // 준석이의 카드가 O면 준석이 점수 증가
            } else {
                score[1]++; // 수현이의 카드가 O면 수현이 점수 증가
            }
        }

        // 준석이의 점수가 수현이의 점수보다 큰지 확인
        return score[0] > score[1];
    }
}