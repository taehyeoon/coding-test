package Baekjoon;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.StringTokenizer;

/*
시작 시간 : 24-02-08 01:42
종료 시간 : 24-02-08 09:30
실행 시간 : 536ms
메 모 리 : 118352KB

고려사항
세그먼트트리를 이용하여, 구간합을 중간노드에 저장한 후
빠르게 접근하여, 구간합을 구하였습니다.
 */

public class BOJ_2042_구간합구하기_G1 {

    static int N, M, K;
    static long[] input;
    static long[] tree;
    static long[][] cmds;
    static StringBuilder sb = new StringBuilder();

    private static void makeTree(int arrSize){
        int height = (int) Math.ceil(Math.log(arrSize) / Math.log(2));
        int requiredNodeNum = (int) Math.pow(2, height+1);
        tree = new long[requiredNodeNum];
    }

    private static long init(long[] arr, int node, int start, int end){
        // 리프 노드
        if(start == end){
            return tree[node] = arr[start];
        }

        // 중간 노드
        int mid = (start+end) / 2;
        return tree[node] =
                init(arr, node*2, start, mid)
                        + init(arr, node*2+1, mid+1, end);
    }

    private static void update(int node, int start, int end, int idx, long diff){
        if(idx < start || idx > end) return;

        tree[node] += diff;

        if(start != end){
            int mid = (start+end)/2;
            update(node*2, start, mid, idx, diff);
            update(node*2+1, mid+1, end, idx, diff);
        }
    }

    /**
     *
     * @param node 현재 노드
     * @param start 배열의 시작
     * @param end 배열의 끝
     * @param left 원하는 누적합의 시작
     * @param right 원하는 누적합의 끝
     */
    private static long sum(int node, int start, int end, int left, int right){
        // 범위를 벗어나는 경우, 더이상 탐색x
        if(left > end || right < start) return 0;

        // 범위 내에 완전히 포함되는 경우
        if(left <= start && end <= right) return tree[node];

        // 이외의 경우
        int mid = (start+end)/2;
        return sum(node*2, start, mid, left, right)
                + sum(node*2+1, mid+1, end, left, right);
    }

    private static void input() throws IOException {
        System.setIn(Files.newInputStream(Paths.get("input.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        input = new long[N];
        cmds = new long[M+K][3];

        for(int i = 0; i < N; i++) input[i] = Long.parseLong(br.readLine());

        for(int i = 0; i < M+K; i++){
            st = new StringTokenizer(br.readLine());
            cmds[i][0] = Long.parseLong(st.nextToken());
            cmds[i][1] = Long.parseLong(st.nextToken());
            cmds[i][2] = Long.parseLong(st.nextToken());
        }
    }

    private static void execute(long[] cmd) {
        if(cmd[0] == 1){ // update
            long diff = cmd[2] - input[(int)cmd[1]-1];
            input[(int)(cmd[1]-1)] = cmd[2];
            update(1,1,N,(int)cmd[1],diff);
        }else{ // sum
            sb.append(sum(1,1,N,(int)cmd[1],(int)cmd[2])).append("\n");
        }
    }

    public static void main(String[] args) throws IOException {

        input();
        makeTree(N);
        init(input, 1, 0, N-1);

        for(int i = 0; i < M+K; i++){
            execute(cmds[i]);
        }
        System.out.print(sb);
    }
}