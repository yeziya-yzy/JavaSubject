package day131_140.day134.exercises1;


/**
 * @author wyw
 * @coding utf-8
 * @data 2022/10/15
 * 779. 第K个语法符号
 */
class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().kthGrammar(12, 32));
    }

    public int kthGrammar(int n, int k) {
        if (n == 1) {
            return 0;
        }
        if (k > (1 << (n - 2))) {
            return 1 ^ kthGrammar(n - 1, k - (1 << (n - 2)));
        }
        return kthGrammar(n - 1, k);
    }
}