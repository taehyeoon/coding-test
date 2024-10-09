package Baekjoon;

import java.util.*;

public class BOJ_6590_덧셈체인_G3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int n = scanner.nextInt();
            if (n == 0) break;
            List<Integer> result = findAdditionChain(n);
            for (int i = 0; i < result.size(); i++) {
                System.out.print(result.get(i));
                if (i < result.size() - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        scanner.close();
    }

    private static List<Integer> findAdditionChain(int n) {
        List<Integer> chain = new ArrayList<>();
        chain.add(1);

        while (chain.get(chain.size() - 1) < n) {
            int size = chain.size();
            int next = 0;

            for (int i = 0; i < size; i++) {
                for (int j = i; j < size; j++) {
                    int candidate = chain.get(i) + chain.get(j);
                    if (candidate > next && candidate <= n) {
                        next = candidate;
                    }
                }
            }
            chain.add(next);
        }

        return chain;
    }
}
