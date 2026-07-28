class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] lastSeen = new int[128];

        for (int i = 0; i < 128; i++) {
            lastSeen[i] = -1;
        }

        int maxLength = 0;
        int start = 0;

        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);

            if (lastSeen[ch] >= start) {
                start = lastSeen[ch] + 1;
            }

            lastSeen[ch] = end;
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }
}
