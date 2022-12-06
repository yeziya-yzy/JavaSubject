package day11.exercises2;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/4/21
 * 给你一个由若干单词组成的句子sentence ，单词间由空格分隔。每个单词仅由大写和小写英文字母组成。
 * 请你将句子转换为 “山羊拉丁文（Goat Latin）”（一种类似于 猪拉丁文- Pig Latin 的虚构语言）。山羊拉丁文的规则如下：
 * 如果单词以元音开头（'a', 'e', 'i', 'o', 'u'），在单词后添加"ma"。
 * 例如，单词 "apple" 变为 "applema" 。
 * 如果单词以辅音字母开头（即，非元音字母），移除第一个字符并将它放到末尾，之后再添加"ma"。
 * 例如，单词 "goat" 变为 "oatgma" 。
 * 根据单词在句子中的索引，在单词最后添加与索引相同数量的字母'a'，索引从 1 开始。
 * 例如，在第一个单词后添加 "a" ，在第二个单词后添加 "aa" ，以此类推。
 * 返回将 sentence 转换为山羊拉丁文后的句子。
 * <p>
 * 案例:
 * 输入：sentence = "I speak Goat Latin"
 * 输出："Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
 * <p>
 * 输入：sentence = "The quick brown fox jumped over the lazy dog"
 * 输出："heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
 */
public class Solution {
    public String toGoatLatin(String sentence) {
        StringBuilder stringBuilder = new StringBuilder();
        Set<Character> characters = new HashSet<>();
        characters.add('a');
        characters.add('e');
        characters.add('i');
        characters.add('o');
        characters.add('u');
        characters.add('A');
        characters.add('E');
        characters.add('I');
        characters.add('O');
        characters.add('U');
        String[] Strings = sentence.split(" ");
        StringBuilder count = new StringBuilder("a");
        for (String string : Strings) {
            if (characters.contains(string.charAt(0))) {
                stringBuilder.append(string).append("ma").append(count);
            } else {
                String substring = string.substring(1, string.length());
                stringBuilder.append(substring).append(string.charAt(0)).append("ma").append(count);
            }
            count.append("a");
            stringBuilder.append(" ");
        }
        return stringBuilder.substring(0, stringBuilder.length() - 1);
    }
}
