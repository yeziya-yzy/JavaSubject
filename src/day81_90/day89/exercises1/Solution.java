package day89.exercises1;

import java.io.*;


/**
 * @author wyw
 * @coding utf-8
 * @data 2022/8/13
 * 279. 完全平方数
 */
class Solution {
    public static void main(String[] args) throws IOException {
        /**String filePath = "D:\\桌面\\test.txt";
         FileOutputStream fileOutputStream = new FileOutputStream(new File(filePath), true);
         OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "utf-8");
         Solution solution = new Solution();
         outputStreamWriter.write("\n");
         for (int i = 1; i < 100; i++) {
         outputStreamWriter.write(solution.numSquares(i) + "\t");
         }
         outputStreamWriter.close();*/
        Solution solution = new Solution();
        System.out.println(solution.numSquares(12));
    }

    public int numSquares(int n) {
        int[] ints = new int[n + 1];
        ints[0] = 0;
        int min;
        for (int i = 1; i <= n; i++) {
            min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, ints[i - j * j]);
            }
            ints[i] = 1 + min;
        }
        return ints[n];
    }
}
