package com.ssafy.coding;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-04-02 10:40
종료 시간 : 24-04-02 17:25
실행 시간 : 316ms / 실패
메 모 리 : 39604KB
*/

public class BOJ_4256_트리_G2 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    static int N;
    static int[] preOrder, inOrder;
    
    private static void input() throws IOException{
    	N = Integer.parseInt(br.readLine());
    	preOrder = new int[N];
    	inOrder = new int[N];
    	
    	st = new StringTokenizer(br.readLine());
    	for(int i = 0; i < N; i++) {
    		preOrder[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	st = new StringTokenizer(br.readLine());
    	for(int i = 0; i < N; i++) {
    		inOrder[i] = Integer.parseInt(st.nextToken());
    	}
    }
    

    private static void findPostOrder(int rootIdx, int begin, int end) {
    	
    	if(rootIdx >= N) return;
    	
    	int rootValue = preOrder[rootIdx];
    	
    	for(int idx = begin; idx <= end; idx++) {
    		if(rootValue == inOrder[idx]) {
    			// leftChild
    			findPostOrder(rootIdx+1, begin, idx);
    			
    			// rightChild
    			findPostOrder(rootIdx + idx + 1 - begin, idx+1, end);
    			
    			sb.append(rootValue + " ");
    			return;
    		}
    	}
    	
    }
    
    public static void main(String[] args) throws IOException {

    	int TC = Integer.parseInt(br.readLine());
    	
    	for(int tc = 0; tc < TC; tc++) {
    		
    		input();
    		
    		findPostOrder(0, 0, N-1);
    		
    		sb.append("\n");
    	}
    	System.out.println(sb);
        
    }
}