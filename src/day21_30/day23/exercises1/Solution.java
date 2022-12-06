package day23.exercises1;


/**
 * @author wyw
 * @coding utf-8
 * @data 2022/5/4
 * 1823. 找出游戏的获胜者
 */
class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().findTheWinner(6, 5));
    }

    public int findTheWinner(int n, int k) {
        int p = 0;
        for (int i = 2; i <= n; i++) {
            p = (p + k) % i;
        }
        return p + 1;
    }
}