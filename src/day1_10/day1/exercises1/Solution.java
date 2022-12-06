package day1_10.day1.exercises1;


/**
 * @author wyw
 * @coding utf-8
 * @data 2022/4/11
 */
class Solution extends day1.exercises1.VersionControl {
    public static void main(String[] args) {
        int n = 2126753390;
        Solution solution = new Solution();
        int i = solution.firstBadVersion(n);
        System.out.println(i);
    }

    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = (left & right) + ((left ^ right) >> 1);
            if (!isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
