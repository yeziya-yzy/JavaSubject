package day131_140.day133.exercises1;


/**
 * @author wyw
 * @coding utf-8
 * @data 2022/10/15
 * 1700. 无法吃午餐的学生数量
 */
class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int[] ints = new int[2];
        for (int student : students) {
            if (student == 0) {
                ints[0] += 1;
            } else {
                ints[1] += 1;
            }
        }
        int index = 0;
        while (index < sandwiches.length) {
            if (sandwiches[index] == 0) {
                if (ints[0] > 0) {
                    ints[0] -= 1;
                } else {
                    break;
                }
            } else {
                if (ints[1] > 0) {
                    ints[1] -= 1;
                } else {
                    break;
                }
            }
            index++;
        }
        return sandwiches.length - index;
    }
}