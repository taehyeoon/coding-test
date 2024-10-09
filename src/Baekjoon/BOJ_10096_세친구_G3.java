package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
시작 시간 : 24-08-04 21:30
종료 시간 : 24-0
실행 시간 : ms
메 모 리 : KB
*/

public class BOJ_10096_세친구_G3 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        int single = n/2;
        String str = br.readLine();
        String leftAns = "";

        if(n%2 == 0) {
            System.out.println("NOT POSSIBLE");
            return;
        }

        // if x in left
        boolean left = true;
        boolean meetX = false;
        for (int i = 0, comp = 0; i < single; i++, comp++) {
            if(str.charAt(comp) == str.charAt(single+1+i)) continue;

            if(meetX) {
                left = false;
                break;
            }else{
                meetX = true;
                i--;
            }
        }
        if(left){
            leftAns = str.substring(single+1, str.length());
        }

        // if x in right
        boolean right = true;
        meetX = false;

        for (int i = 0, comp = 0; i < single; i++, comp++) {
            if(str.charAt(i) == str.charAt(comp+single)) continue;

            if(meetX) {
                right = false;
                break;
            }else{
                meetX = true;
                i--;
            }
        }

        String rightAns = "";
        if(right){
            rightAns = str.substring(0, single);
        }

        // System.out.println("left = " + left);
        // System.out.println("leftAns = " + leftAns);
        // System.out.println("right = " + right);
        // System.out.println("rightAns = " + rightAns);

        if(left && right && leftAns.compareTo(rightAns) != 0){
            System.out.println("NOT UNIQUE");
        }else if(left){
            System.out.println(leftAns);
        }else if (right) {
            System.out.println(rightAns);
        }else{
            System.out.println("NOT POSSIBLE");

        }
    }
}