package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.StringTokenizer;

/*
시작 시간 : 24-02-09 11:30
종료 시간 : 24-02-09 12:20
실행시간 : 76ms
메 모 리 : 11572KB

고려사항
트리의 root는 반드시 A를 가지는 것으로 문제에서 제시되었기 때문에
root를 먼저 생성한 뒤, 입력되는 값에 맞게 트리의 나머지 노드를 추가하였습니다
preOrder, inOrder, postOrder는 방문 순서를 다르게하여 재귀적으로 구현하였습니다.
*/

public class BOJ_1991_트리순회_S1 {

    static class Node{
        char val;
        Node l, r;

        public Node(char val, Node l, Node r) {
            this.val = val;
            this.l = l;
            this.r = r;
        }
    }
    static int N;
    static Node root = new Node('A', null, null);
    static StringBuilder sb = new StringBuilder();

    private static void input() throws IOException {
        System.setIn(Files.newInputStream(Paths.get("input.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        char val, l, r;

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            val = st.nextToken().charAt(0);
            l = st.nextToken().charAt(0);
            r = st.nextToken().charAt(0);
            insert(root, val, l, r);
        }

    }

    private static void insert(Node head,  char val, char l, char r) {
        if(head.val == val){
            head.l = l =='.' ? null : new Node(l, null ,null);
            head.r = r =='.' ? null : new Node(r, null ,null);
        }else{
            if(head.l != null) insert(head.l, val, l, r);
            if(head.r != null) insert(head.r, val, l, r);
        }
    }

    private static void preOrder(Node node){
        if(node == null) return;

        sb.append(node.val);
        preOrder(node.l);
        preOrder(node.r);
    }

    private static void inOrder(Node node){
        if(node == null) return;

        inOrder(node.l);
        sb.append(node.val);
        inOrder(node.r);
    }

    private static void postOrder(Node node){
        if(node == null) return;

        postOrder(node.l);
        postOrder(node.r);
        sb.append(node.val);
    }

    public static void main(String[] args) throws IOException {
        input();

        preOrder(root);
        sb.append("\n");
        inOrder(root);
        sb.append("\n");
        postOrder(root);

        System.out.println(sb);
    }
}