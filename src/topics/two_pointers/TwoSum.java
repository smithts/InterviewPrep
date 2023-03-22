package topics.two_pointers;

public class TwoSum {

    /*
    Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.

    Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.

    The tests are generated such that there is exactly one solution. You may not use the same element twice.

    Your solution must use only constant extra space.
    */
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        int p1 = 0;
        int p2 = nums.length - 1;
        int currentSum;

        while (p1 < p2) {
            currentSum = nums[p1] + nums[p2];
            if(currentSum > target) {
                p2--;
            } else if (currentSum < target) {
                p1++;
            } else {
                result[0] = p1 + 1;
                result[1] = p2 + 1;
                return result;
            }
        }

        return result;
    }
}
