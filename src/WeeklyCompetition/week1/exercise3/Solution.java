package WeeklyCompetition.week1.exercise3;


/**
 * @author wyw
 * @coding utf-8
 * @data 2022/8/29
 * 2391. 收集垃圾的最少总时间号
 */
class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int MIndex = 0;
        int PIndex = 0;
        int GIndex = 0;
        int MCount = 0;
        int PCount = 0;
        int GCount = 0;
        for (int i = 0; i < garbage.length; i++) {
            if (garbage[i].contains("M")) {
                MIndex = i;
            }
            if (garbage[i].contains("P")) {
                PIndex = i;
            }
            if (garbage[i].contains("G")) {
                GIndex = i;
            }
            MCount += countMPG(garbage[i], 'M');
            PCount += countMPG(garbage[i], 'P');
            GCount += countMPG(garbage[i], 'G');
        }
        for (int i = 0; i < MIndex; i++) {
            MCount += travel[i];
        }
        for (int i = 0; i < PIndex; i++) {
            PCount += travel[i];
        }
        for (int i = 0; i < GIndex; i++) {
            GCount += travel[i];
        }
        return MCount + PCount + GCount;
    }

    private int countMPG(String s, char need) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == need) {
                res++;
            }
        }
        return res;
    }
}