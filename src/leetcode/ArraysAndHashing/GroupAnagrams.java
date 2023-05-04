package leetcode.ArraysAndHashing;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Creating hashmap to ensure uniqueness of keys
        Map<String,List<String>> map = new HashMap<>();

        for (String s : strs) {
            //Alphabetizeing the strings to determine with are anagrams of one another
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sOrdered = new String(chars);

            if (map.containsKey(sOrdered)) {
                // if already seen anagram, update list of associated words
                map.get(sOrdered).add(s);
            } else {
                // if not seen, create new record and add to map
                List<String> value = new ArrayList<>();
                value.add(s);
                map.put(sOrdered, value);
            }
        }

        // return resulting values from the map
        return new ArrayList<>(map.values());
    }
}
