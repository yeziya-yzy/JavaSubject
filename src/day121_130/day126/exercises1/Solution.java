package day121_130.day126.exercises1;


import java.util.Arrays;
import java.util.Comparator;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/10/3
 * 870. 优势洗牌
 */
class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] res = new int[n];
        Integer[] nums1Index = new Integer[n];
        Integer[] nums2Index = new Integer[n];
        for (int i = 0; i < n; i++) {
            nums1Index[i] = i;
            nums2Index[i] = i;
        }
        Arrays.sort(nums1Index, Comparator.comparingInt(i -> nums1[i]));
        Arrays.sort(nums2Index, Comparator.comparingInt(i -> nums2[i]));
        int left = 0;
        int right = n - 1;
        for (int i = 0; i < n; i++) {
            if (nums1[nums1Index[i]] > nums2[nums2Index[left]]) {
                res[nums2Index[left]] = nums1[nums1Index[i]];
                left++;
            } else {
                res[nums2Index[right]] = nums1[nums1Index[i]];
                right--;
            }
        }
        return res;
    }
}