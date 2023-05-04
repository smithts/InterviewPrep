package leetcode.two_pointers;

import java.util.*;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        //Hashset will insist on uniqueness of lists,
        //      though the ordering of the list may imply uniqueness
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }

        Set<List<Integer>> found = new HashSet<>();
        int i, j, k;

        Arrays.sort(nums);

        for (i = 0; i < nums.length - 2; i++) {
            j = i + 1;
            k = nums.length -1;
            while (j < k) {
                int currentSum = nums[i] + nums[j] + nums[k];
                if (currentSum == 0) {
                    found.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                } else if (currentSum > 0) {
                    k--;
                } else if (currentSum < 0) {
                    j++;
                }
            }
        }

        return new ArrayList<>(found);

    }
}
