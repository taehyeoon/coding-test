package Baekjoon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
시작 시간 : 24-10-09
종료 시간 : 24-0
실행 시간 : ms
메 모 리 : KB
*/

public class BOJ_1114_통나무자르기 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        String[] spt = line.split(" ");
        Long l = Long.parseLong(spt[0]);
        int k = Integer.parseInt(spt[1]);
        int c = Integer.parseInt(spt[2]);

        line = sc.nextLine();
        spt = line.split(" ");

        List<Long> cuts = new ArrayList<>();
        cuts.add(0L);
        cuts.add(l);
        for (int i = 0; i < k; i++) {
            cuts.add(Long.parseLong(spt[i]));
        }
        cuts.sort((a, b) -> (int) (a - b));
        long lo = 0;
        long hi = l;
        long ansFirst = 0;
        long ansLongest = l;

        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            long cutCnt = 0;
            long firstCut = -1;
            long diff = 0;
            for (int i = k; i >= 0; i--) {
                diff += cuts.get(i + 1) - cuts.get(i);
                if (diff > mid) {
                    diff = cuts.get(i + 1) - cuts.get(i);
                    cutCnt++;
                    if (diff > mid) {
                        cutCnt = c + 1;
                        break;
                    }
                }
            }

            if (cutCnt < c) {
                firstCut = cuts.get(1);
            } else {
                firstCut = diff;
            }
            if (cutCnt <= c) {
                ansLongest = Math.min(mid, ansLongest);
                ansFirst = firstCut;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        System.out.println(ansLongest + " " + ansFirst);
        sc.close();
        }
}