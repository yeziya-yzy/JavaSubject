package day32.exercises1;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/5/13
 * 面试题 01.05. 一次编辑
 */
class Solution {
    public static void main(String[] args) {
        String first = "dinitrophenylhydrazine";
        String second = "acetylphenylhydrazine";
        System.out.println(new Solution().oneEditAway(first, second));
    }

    public boolean oneEditAway(String first, String second) {
        if (first.equals(second)) {
            return true;
        }
        if (first.length() == 1 && second.length() == 1) {
            return true;
        }
        if (Math.abs(first.length() - second.length()) >= 2) {
            return false;
        }
        int firstIndex = 0;
        int secondIndex = 0;
        int count = 0;
        if (first.length() < second.length()) {
            while (firstIndex < first.length() && secondIndex < second.length()) {
                if (first.charAt(firstIndex) == second.charAt(secondIndex)) {
                    firstIndex++;
                }
                secondIndex++;
            }
        } else if (first.length() > second.length()) {
            while (firstIndex < first.length() && secondIndex < second.length()) {
                if (first.charAt(firstIndex) == second.charAt(secondIndex)) {
                    secondIndex++;
                }
                firstIndex++;
            }
        } else {
            while (firstIndex < first.length()) {
                if (first.charAt(firstIndex) != second.charAt(secondIndex)) {
                    count++;

                }
                secondIndex++;
                firstIndex++;
            }
            if (count >= 2) {
                return false;
            }
        }
        return Math.abs(secondIndex - firstIndex) <= 1;
    }
}
