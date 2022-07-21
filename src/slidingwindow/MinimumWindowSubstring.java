package slidingwindow;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        System.out.println(minWindow("cabwefgewcwaefgcf", "cae"));
    }

    public static String minWindow(String s, String t) {
        int[] tMap = new int[128];
        for (int i = 0; i < t.length(); i++)
            tMap[t.charAt(i)]++;

        int i = 0, j = 0;
        int minLen = Integer.MAX_VALUE;
        int maxI = 0;
        int maxJ = 0;
        int cnt = t.length();
        boolean isValidWindowFound = false;
        while (j < s.length()) {
            char ch = s.charAt(j);
            if (tMap[ch] > 0)
                cnt--;
            tMap[ch]--;

            //contract left
            while (cnt == 0) {
                if (minLen > j - i + 1) {
                    isValidWindowFound = true;
                    maxI = i;
                    maxJ = j;
                    minLen = j - i + 1;
                }

                char c2 = s.charAt(i);
                tMap[c2]++;
                if (tMap[s.charAt(i)] > 0)
                    cnt++;
                i++;
            }
            // expand right
            j++;
        }
        return isValidWindowFound ? s.substring(maxI, maxJ + 1) : "";
    }
}
