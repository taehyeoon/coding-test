package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
시작 시간 : 24-0
종료 시간 : 24-0
실행 시간 : ms
메 모 리 : KB
*/

public class BOJ_1594_전화번호만들기_G2 {

    static class Data implements Comparable<Data>{
        String str; // xx-xxx-xx
        int cnt;

        public Data(String str, int cnt) {
            this.str = str;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Data o) {
            if(this.cnt != o.cnt) return -Integer.compare(this.cnt, o.cnt);
            else return this.str.compareTo(o.str);
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    List<String> strs = new ArrayList<>();
    static Map<String, Data> storage = new HashMap<>(); // key : xxxxxxx, Data: <xx-xxx-xx, 3>

    private static int getScore(String str){
        if(str.length() == 2){
            return str.charAt(0) == str.charAt(1) ? 2 : 0;
        }else{
            if(str.charAt(0) == str.charAt(1) && str.charAt(1) == str.charAt(2)) return 2;
            else if(str.charAt(0) != str.charAt(1) && str.charAt(1) != str.charAt(2) && str.charAt(2) != str.charAt(0)) return 0;
            else return 1;
        }
    }

    private static Data dfs(String prefix, String suffix, int cnt){

        if(suffix.length() == 2 || suffix.length() == 3){
            return new Data(prefix+"-"+suffix, cnt+ getScore(suffix));
        }else if(suffix.length() == 4){
            String front = suffix.substring(0,2);
            String back = suffix.substring(2,4);
            return new Data(prefix + "-" + front + "-" + back, cnt+getScore(front)+getScore(back));
        }

        String first2 = suffix.substring(0,2);
        String last2 = suffix.substring(2);
        String first3 = suffix.substring(0,3);
        String last3 = suffix.substring(3);

        Data data2;
        if(storage.containsKey(last2)){
            data2 = new Data(prefix+storage.get(last2).str, cnt + storage.get(last2).cnt);
        }else {
            data2 = dfs(prefix+"-"+first2, last2, cnt + getScore(first2));
            storage.put(last2, new Data(data2.str.substring(prefix.length()+3), data2.cnt-cnt - getScore(first2)));
        }

        Data data3;
        if(storage.containsKey(last3)){
            data3 = new Data(prefix+storage.get(last3).str, cnt + storage.get(last3).cnt);
        }else {
            data3 = dfs(prefix+"-"+first3, last3, cnt + getScore(first3));
            storage.put(last3, new Data(data3.str.substring(prefix.length()+4), data3.cnt-cnt - getScore(first3)));
        }

        return data2.compareTo(data3) > 0 ? data3 : data2;
    }

    public static void main(String[] args) throws IOException {

        String phone = br.readLine();

//        Data one = new Data("123", 3);
//        Data two = new Data("234", 2);
//        System.out.println(one.compareTo(two));

        System.out.println(dfs("", phone, 0).str);
    }
}