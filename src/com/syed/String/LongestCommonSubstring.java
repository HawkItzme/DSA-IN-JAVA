package com.syed.String;
import java.util.*;
public class LongestCommonSubstring {
    //Code for Longest common substring among k strings
    public static void main(String[] args) {
        String S1 = "abbababa";
        String S2 = "ababacd";
        String S3 = "dcababalm";

        String[] strings = {S1, S2, S3};
        System.out.println("Longest Common Substring: " + longestCommonSubstring(strings));

    }

    static class Suffix implements Comparable<Suffix> {
        int index;
        String text;

        Suffix(String s, int i) {
            this.index = i;
            this.text = s.substring(i);
        }

        public int compareTo(Suffix o) {
            return this.text.compareTo(o.text);
        }
    }

    public static String longestCommonSubstring(String[] strings) {
        StringBuilder sb = new StringBuilder();
        int[] strOwner = new int[100000];  // track which string each character belongs to
        int totalLen = 0;

        // Step 1: Merge all strings with unique delimiters
        for (int i = 0; i < strings.length; i++) {
            sb.append(strings[i]);
            for (int j = 0; j < strings[i].length(); j++) {
                strOwner[totalLen++] = i;
            }
            sb.append((char)(256 + i));  // unique separator
            strOwner[totalLen++] = -1;   // delimiter not owned
        }

        String merged = sb.toString();
        int n = merged.length();

        // Step 2: Suffix Array
        Suffix[] suffixes = new Suffix[n];
        for (int i = 0; i < n; i++) {
            suffixes[i] = new Suffix(merged, i);
        }
        Arrays.sort(suffixes);

        // Step 3: LCP Array
        int[] lcp = new int[n];
        for (int i = 1; i < n; i++) {
            String a = suffixes[i - 1].text;
            String b = suffixes[i].text;
            int len = 0;
            while (len < a.length() && len < b.length() && a.charAt(len) == b.charAt(len)) {
                len++;
            }
            lcp[i] = len;
        }

        // Step 4: Sliding Window over suffix array
        int maxLen = 0;
        String result = "";
        int k = strings.length;
        Map<Integer, Integer> freq = new HashMap<>();
        int left = 0;

        for (int right = 0; right < n; right++) {
            int owner = strOwner[suffixes[right].index];
            if (owner != -1) {
                freq.put(owner, freq.getOrDefault(owner, 0) + 1);
            }

            while (freq.size() == k) {
                // All k strings are present in the window
                int minLCP = Integer.MAX_VALUE;
                for (int i = left + 1; i <= right; i++) {
                    minLCP = Math.min(minLCP, lcp[i]);
                }

                if (minLCP > maxLen) {
                    maxLen = minLCP;
                    result = merged.substring(suffixes[left].index, suffixes[left].index + maxLen);
                }

                int leftOwner = strOwner[suffixes[left].index];
                if (leftOwner != -1) {
                    freq.put(leftOwner, freq.get(leftOwner) - 1);
                    if (freq.get(leftOwner) == 0) freq.remove(leftOwner);
                }
                left++;
            }
        }

        return result;
    }

}

