package com.ssafy.coding;

import java.io.*;
import java.util.*;

/*
시작 시간 : 24-04-03 12:00
종료 시간 : 24-04-03 15:00
실행시간 : 104ms
메 모 리 : 14564KB
*/


public class BOJ_17837_새로운게임2_G2 {

	static class Cell{
		int color;
		Stack<Integer> s;
		public Cell(int color) {
			this.color = color;
		}
	}

	static class Coin{
		int r, c, d;

		public Coin(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, K;
	static Cell[][] map;
	static Coin[] coins;
	
	static int[] di = {-99, 0, 0, -1, 1};
	static int[] dj = {-99, 1,-1,  0, 0};

	private static void input() throws IOException{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new Cell[N+1][N+1];
		for(int i = 1; i < N+1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j < N+1; j++) {
				map[i][j] = new Cell(Integer.parseInt(st.nextToken()));
			}
		}

		coins = new Coin[K+1];
		for (int i = 1; i < K+1; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			coins[i] = new Coin(r, c, d);
			map[r][c].s = new Stack();
			map[r][c].s.push(i);
		}
		
	}
	
	private static boolean isBlueOrOut(int i, int j) {
		if(i < 1 || j < 1 || i > N || j > N) return true;
		if(map[i][j].color == 2) return true;
		
		return false;
	}
	
	private static int turnDir(int d) {
		if(d == 1) return 2;
		if(d == 2) return 1;
		if(d == 3) return 4;
		if(d == 4) return 3;
		return -1;
	}
	private static boolean moveCoin(int coinNum, boolean firstTry) {
		
		int ci = coins[coinNum].r;
		int cj = coins[coinNum].c;
		int dir = coins[coinNum].d;
		int ni = ci + di[dir];
		int nj = cj + dj[dir];
		
		
		// 파랑 or 외부
		if(isBlueOrOut(ni, nj)) {
			if(!firstTry) return false;
			coins[coinNum].d = turnDir(dir);
			return moveCoin(coinNum, false);
		}
		
		// 옮길 코인을 list에 담아둠
		ArrayDeque<Integer> moveCoins = new ArrayDeque<Integer>();
		
		while(map[ci][cj].s.peek() != coinNum) {
			moveCoins.addFirst(map[ci][cj].s.pop());
		}
		moveCoins.addFirst(map[ci][cj].s.pop());
		
		// 4개 이상 쌓이게 되는 경우 종료
		if(map[ni][nj].s == null) map[ni][nj].s = new Stack<Integer>();
		if(map[ni][nj].s.size() + moveCoins.size() >= 4) return true;
		
		// 빨강
		if(map[ni][nj].color == 1) {
			while(!moveCoins.isEmpty()) {
				int coin = moveCoins.pollLast();
				coins[coin].r = ni;
				coins[coin].c = nj;
				
				map[ni][nj].s.push(coin);
			}
		}
		
		// 흰색
		else {
			while(!moveCoins.isEmpty()) {
				int coin = moveCoins.pollFirst();
				coins[coin].r = ni;
				coins[coin].c = nj;
				
				map[ni][nj].s.push(coin);
			}
		}

		// 이제 coinNum번 돌의 위치는 (ni, nj)
		coins[coinNum].r = ni;
		coins[coinNum].c = nj;
		
		return false;
	}
	public static void main(String[] args) throws IOException {
		
		input();
		
		int turn = 1;
		
		Over:
		while(turn <= 1000) {
			for (int i = 1; i < K+1; i++) {
				if(moveCoin(i, true)) {
					break Over;
				}
			}
			turn++;
		}
		
		if(turn == 1001) System.out.println(-1);
		else System.out.println(turn);
	}
}
