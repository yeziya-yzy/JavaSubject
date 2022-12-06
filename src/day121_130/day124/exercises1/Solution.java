package day121_130.day124.exercises1;


/**
 * @author wyw
 * @coding utf-8
 * @data 2022/10/3
 * 927. 三等分
 */
class Solution {
    public int[] threeEqualParts(int[] arr) {
        int count = 0;
        for (int i : arr) {
            if (i == 1) {
                count++;
            }
        }
        if (count == 0) {
            return new int[]{0, 2};
        }
        if (count % 3 != 0) {
            return new int[]{-1, -1};
        }
        int length = count % 3;
        count = 0;
        int first = 0;
        int second = 0;
        int third = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                if (count == 0) {
                    first = i;
                } else if (count == length) {
                    second = i;
                } else if (count == 2 * length) {
                    third = i;
                }
                count++;
            }
        }
        int len = arr.length - third;
        if (first + len <= second && second + len <= third) {
            count = 0;
            while (third + count < arr.length) {
                if (arr[first + count] != arr[second + count] || arr[first + count] != arr[third + count]) {
                    return new int[]{-1, -1};
                }
                count++;
            }
            return new int[]{first + len - 1, second + len};
        }
        return new int[]{-1, -1};
    }
}