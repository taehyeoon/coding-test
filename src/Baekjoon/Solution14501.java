package Baekjoon;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution14501 {

    static class Pair{
        public int day;
        public int price;

        public Pair(int day, int price) {
            this.day = day;
            this.price = price;
        }
    }

    static int n;
    static int maxPrice;
    static Pair[] info;

    public static void main(String[] args) throws FileNotFoundException {

        System.setIn(new FileInputStream("input.txt"));

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        info = new Pair[n];

        for(int i = 0; i < n; i++) {
            info[i] = new Pair(sc.nextInt(), sc.nextInt());
        }

        dp(0, 0);

        System.out.println(maxPrice);
    }

    private static void dp(int i, int total) {

        if(i > n) return;

        if(i == n) {
            maxPrice = Math.max(total, maxPrice);
            return;
        }

        dp(i + info[i].day, total + info[i].price);
        dp(i + 1, total);
    }

}