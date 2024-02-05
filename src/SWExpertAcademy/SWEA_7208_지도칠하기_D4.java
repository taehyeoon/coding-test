package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
SWEA 지도칠하기 7208 D4
시작 시간 : 24-01-30 20:00
종료 시간 : 24-01-30 21:00
실행 시간 : 1176ms

고려사항
1~4의 값을 통해 나라의 수만큼을 중복 순열을 생성하여 해결하였습니다.
4TT나라의 수 -> 4^(나라의 수)
1. 모든 순열을 탐색하며, 인접 나라의 색이 다른지 체크
2. 1번을 만족한 순열 중 실제 나라의 색과 가장 차이가 적은 값을 기록
3. 2번에서 도출된 값과 현재 가장 작은 값을 비교하여, 현재 가장 작은 값 갱신
*/

public class SWEA_7208_지도칠하기_D4 {

    static int N, country, ans = Integer.MAX_VALUE;
    static int[] colorByCountry;
    static int[] result; // 중복순열이 저장될 배열
    static int[][] input;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < N; tc++) {
            ans = Integer.MAX_VALUE;
            country = Integer.parseInt(br.readLine());

            result = new int[country];
            colorByCountry = new int[country];
            input = new int[country][country];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < country; j++) {
                colorByCountry[j] = Integer.parseInt(st.nextToken());
            }

            // 그래프 입력
            for (int j = 0; j < country; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < country; k++) {
                    input[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            permutation(0);
            System.out.printf("#%d %d%n", tc+1, ans);

        }
    }


    // 순열 메서드(cnt는 선택 횟수)
    private static void permutation(int cnt) {
        // country개를 선택했으므로, 결과를 출력하고 재귀를 종료한다.
        if (cnt == country) {
            checkAns();
            return;
        }

        // 대상 집합을 순회하며 숫자를 하나 선택한다.
        for (int i = 0; i < country; i++) {
            // cnt번째 나라에 i+1색을 담는다.
            result[cnt] = i+1;
            
            
            // 자신을 재귀 호출한다.
            permutation(cnt + 1);
        }
    }

    private static void checkAns() {

        // result 배열이 현재 그래프에서 유효한지 체크
        for(int i = 0; i < country; i++){
            for(int j = 0; j < country; j++){
                if(input[i][j] == 1 && i != j && result[i] == result[j]){
                    return;
                }
            }
        }
        
        // 유효한 배열로 바뀌기 위해서 몇번 수정해야하는지 체크
        int count = 0;

        for(int i = 0; i < country; i++){
            if(result[i] != colorByCountry[i]) count++;
        }

        ans = Math.min(ans, count);
    }
}

