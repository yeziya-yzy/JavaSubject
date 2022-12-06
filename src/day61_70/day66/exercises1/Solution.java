package day66.exercises1;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/6/30
 * 1175. 质数排列
 */
class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().numPrimeArrangements(100));
    }

    public int numPrimeArrangements(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        long countL = 1;
        long countR = 1;
        for (int i = 1; i <= count; i++) {
            countL *= i;
            countL %= 1000000007;
        }
        for (int i = 1; i <= n - count; i++) {
            countR *= i;
            countR %= 1000000007;
        }
        return (int) ((countL * countR) % 1000000007);
    }

    private boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}