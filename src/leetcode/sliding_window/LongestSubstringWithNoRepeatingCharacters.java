package leetcode.sliding_window;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithNoRepeatingCharacters {

    /*
        Given a string s, find the length of the longest substring without repeating characters.

        Example 1:

        Input: s = "abcabcbb"
        Output: 3
        Explanation: The answer is "abc", with the length of 3.
        Example 2:

        Input: s = "bbbbb"
        Output: 1
        Explanation: The answer is "b", with the length of 1.
        Example 3:

        Input: s = "pwwkew"
        Output: 3
        Explanation: The answer is "wke", with the length of 3.
        Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.


        Constraints:

        0 <= s.length <= 5 * 104
        s consists of English letters, digits, symbols and spaces.
    * */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        char[] chars = s.toCharArray();
        Map<Character,Integer> visitedChars = new HashMap<>();

        int longest = 0;
        char current;

        for (int i = 0, j = 0; i < chars.length; i++) {
            current = chars[i];
            if (visitedChars.containsKey(current)) {
                j = Math.max(j, visitedChars.get(current) + 1);
            }
            visitedChars.put(current, i);
            longest = Math.max(longest, i - j + 1);
        }
        return longest;
    }

}
