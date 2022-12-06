import java.awt.*;
import java.io.*;
import java.util.Scanner;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/4/18
 */
public class Test {
    private static Test test = new Test();
    private static int count = 0;
    private static FileOutputStream fileOutputStream;
    private static final int lengthFormat = 100;

    public static void main(String[] args) throws IOException, AWTException {
        // String needChangeString = "48，54，60，64，48，55，54，45，51，48，56，48，64，50，54";
        // String splitString = "，";
        // test.printI(needChangeString, splitString);
        // fileOutputStream = new FileOutputStream("D:\\桌面\\down\\FileLiseNames.txt");
        // File file = new File("H:\\");
        // test.getAllFileName(file);
        // test.hnt('A', 'B', 'C', 3);

    }

    private void printI(String needChange, String splitString) {
        String[] strings = needChange.split(splitString);
        for (String string : strings) {
            System.out.println(string);
        }
    }

    private void getAllFileName(File file) throws IOException {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File fileNext : files) {
                    getAllFileName(fileNext);
                }
            }
        } else {
            String name = file.getName();
            String absolutePath = file.getAbsolutePath();
            String content = formatString(lengthFormat, name + absolutePath + " ");
            fileOutputStream.write(content.getBytes());
        }
    }

    private static String formatString(int length, String needFormatString) {
        if (needFormatString.length() > length) {
            return needFormatString;
        }
        StringBuilder stringBuilder = new StringBuilder(needFormatString);
        for (int i = 0; i < length - needFormatString.length(); i++) {
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }

    private void hnt(char A, char B, char C, int count) {
        if (count == 1) {
            System.out.printf("从%c -> %c%n", A, C);
            return;
        }
        hnt(A, C, B, count - 1);
        System.out.printf("从%c -> %c%n", A, C);
        hnt(B, A, C, count - 1);
    }
}