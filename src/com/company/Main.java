package com.company;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        System.out.println(new Solution().isPossible(new int[]{9, 3, 5}));
    }
}

class Solution {
    public boolean isPossible(int[] A) {
        long total = 0;
        int n = A.length;
        for (int a: A)
            total += a;
        Arrays.sort(A);
        while (true) {
            int a = A[n - 1];
            total -= a;
            if (a == 1 || total == 1)
                return true;
            if (a < total || a % total == 0)
                return false;
            a %= total;
            total += a;
            A[n - 1] = a;
            Arrays.sort(A);
        }
    }
}