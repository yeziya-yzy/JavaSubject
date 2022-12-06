package day69.exercises1;

import java.util.*;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/7/7
 */
class Solution {
    public static void main(String[] args) {
        List<String> dictionary = new ArrayList<>();
        dictionary.add("cat");
        dictionary.add("bat");
        dictionary.add("rat");
        String sentence = "the cattle was rattled by the battery";
        System.out.println(new Solution().replaceWords(dictionary, sentence));
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        Set<String> stringSet = new HashSet<>(dictionary);
        String[] strings = sentence.split(" ");
        for (int j = 0; j < strings.length; j++) {
            for (int i = 0; i < strings[j].length(); i++) {
                if (stringSet.contains(strings[j].substring(0, i + 1))) {
                    strings[j] = strings[j].substring(0, i + 1);
                    break;
                }
            }
        }
        return String.join(" ",strings);
    }
}
