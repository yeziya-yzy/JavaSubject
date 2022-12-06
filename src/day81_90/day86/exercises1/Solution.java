package day86.exercises1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/8/10
 * 640. 求解方程
 */
class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().solveEquation("x=x+2"));
    }

    public String solveEquation(String equation) {
        String[] split = equation.split("=");
        int[] ints = new int[2];
        String regex = "(-)?[0-9]*[x]*";
        Pattern compile = Pattern.compile(regex);
        for (int i = 0; i < split.length; i++) {
            Matcher matcher = compile.matcher(split[i]);
            while (matcher.find()) {
                if (matcher.group().length() == 0) {
                    continue;
                }
                if (matcher.group().contains("x")) {
                    if (i == 0) {
                        if (matcher.group().equals("x")) {
                            ints[0] += 1;
                        } else if (matcher.group().split("x")[0].equals("-")) {
                            ints[0] += -1;
                        } else {
                            ints[0] += Integer.parseInt(matcher.group().split("x")[0]);
                        }
                    }
                    if (i == 1) {
                        if (matcher.group().equals("x")) {
                            ints[0] += -1;
                        } else if (matcher.group().split("x")[0].equals("-")) {
                            ints[0] += 1;
                        } else {
                            ints[0] += -Integer.parseInt(matcher.group().split("x")[0]);
                        }
                    }
                } else {
                    if (i == 0) {
                        ints[1] += -Integer.parseInt(matcher.group());
                    }
                    if (i == 1) {
                        ints[1] += Integer.parseInt(matcher.group());
                    }
                }
            }
        }
        if (ints[0] == 0 && ints[1] == 0) {
            return "Infinite solutions";
        }
        if (ints[0] == 0 && ints[1] != 0) {
            return "No solution";
        }
        return "x=" + (ints[1] / ints[0]);
    }
}
