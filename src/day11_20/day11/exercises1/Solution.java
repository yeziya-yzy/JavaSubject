package day11.exercises1;


/**
 * @author wyw
 * @coding utf-8
 * @data 2022/4/21
 * 给定一个长度为 n 的整数数组nums。
 * 假设arrk是数组nums顺时针旋转 k 个位置后的数组，我们定义nums的 旋转函数F为：
 * F(k) = 0 * arrk[0] + 1 * arrk[1] + ... + (n - 1) * arrk[n - 1]
 * 返回F(0), F(1), ..., F(n-1)中的最大值。
 * 生成的测试用例让答案符合32 位 整数。
 * 案例:
 * 输入: nums = [4,3,2,6]
 * 输出: 26
 * 解释:
 * F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
 * F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
 * F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
 * F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26
 * 所以 F(0), F(1), F(2), F(3) 中的最大值是 F(3) = 26 。
 * <p>
 * 输入: nums = [100]
 * 输出: 0
 * <p>
 * 向右旋转一次，就相当于把当前结果加上整个数组的和，再减去数组大小乘以当前最后一位。
 * 记数组 \textit{nums}nums 的元素之和为 \textit{numSum}numSum。根据公式，可以得到：
 *
 * F(0) = 0 \times \textit{nums}[0] + 1 \times \textit{nums}[1] + \ldots + (n-1) \times \textit{nums}[n-1]F(0)=0×nums[0]+1×nums[1]+…+(n−1)×nums[n−1]
 * F(1) = 1 \times \textit{nums}[0] + 2 \times \textit{nums}[1] + \ldots + 0 \times \textit{nums}[n-1] = F(0) + \textit{numSum} - n \times \textit{nums}[n-1]F(1)=1×nums[0]+2×nums[1]+…+0×nums[n−1]=F(0)+numSum−n×nums[n−1]
 * 更一般地，当 1 \le k \lt n1≤k<n 时，F(k) = F(k-1) + \textit{numSum} - n \times \textit{nums}[n-k]F(k)=F(k−1)+numSum−n×nums[n−k]。我们可以不停迭代计算出不同的 F(k)F(k)，并求出最大值。
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {4, 3, 2, 6};
        System.out.println(solution.maxRotateFunction(nums));
    }

    public int maxRotateFunction(int[] nums) {
        int max;
        int temp = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            temp += i * nums[i];
            sum += nums[i];
        }
        max = temp;
        for (int i = 1; i < nums.length; i++) {
            temp = F(nums, i, temp, sum);
            max = Math.max(max, temp);
        }
        return max;
    }

    private int F(int[] nums, int index, int lastF, int sum) {
        return lastF + sum - nums.length * nums[nums.length - index];
    }

}
