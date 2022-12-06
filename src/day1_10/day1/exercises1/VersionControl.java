package day1.exercises1;

/**
 * @author wyw
 * @coding utf-8
 * @data 2022/4/11
 */
public class VersionControl {
    private int n = 2126753390;
    private int bad = 1702766719;
    boolean[] booleans = new boolean[n];

    public VersionControl() {
        for (int i = 0; i < bad; i++) {
            booleans[i] = true;
        }
    }

    public boolean isBadVersion(int version) {
        return booleans[version];
    }
}
