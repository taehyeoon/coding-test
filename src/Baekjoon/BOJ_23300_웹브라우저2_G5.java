package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
시작 시간 : 24-0
종료 시간 : 24-0
실행 시간 : ms
메 모 리 : KB
*/

public class BOJ_23300_웹브라우저2_G5 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, Q;

    static class Page{
        boolean isDeleted;
        int page;

        public Page(boolean isDeleted, int page) {
            this.isDeleted = isDeleted;
            this.page = page;
        }

        @Override
        public String toString() {
            return "[" + page + "," + (isDeleted ? "X" : "O") + "]";

        }
    }
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        Deque<Page> prev = new ArrayDeque<>();
        Deque<Page> next = new ArrayDeque<>();
        Page cur = null;

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            char cmd = st.nextToken().charAt(0);

            switch (cmd) {
                case 'B':
                    while (!prev.isEmpty()) {
                        Page p = prev.pollFirst();
                        if (!p.isDeleted) {
                            next.addFirst(cur);
                            cur = p;
                            break;
                        }
                    }
                    break;
                case 'F':
                    if(!next.isEmpty()) {
                        cur.isDeleted = false;
                        prev.addFirst(cur);
                        cur = next.pollFirst();
                        cur.isDeleted = false;
                    }
                    break;
                case 'A':
                    int accessPage = Integer.parseInt(st.nextToken());
                    if(cur != null) prev.addFirst(cur);
                    cur = new Page(false, accessPage);
                    next.clear();
                    break;

                case 'C':
                    int check = -1;
                    for(Iterator<Page> it = prev.iterator(); it.hasNext(); ) {
                        Page p = it.next();
                        if(check == p.page){
                            p.isDeleted = true;
                        }else{
                            check = p.page;
                        }
                    }
                    break;
            }
        }

        System.out.println(cur.page);
        print(prev);
        print(next);
    }

    private static void print(Deque<Page> pages) {

        if(pages.isEmpty()){
            System.out.println(-1);
        }else{
			for (Page p : pages) {

				if (!p.isDeleted) {
					System.out.print(p.page + " ");
				}
			}
            System.out.println();
        }

    }
}