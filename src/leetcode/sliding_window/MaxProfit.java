package leetcode.sliding_window;

public class MaxProfit {

    public int maxProfit(int[] prices) {
        int max = 0;
        int left = 0, right = 1;

        while (right < prices.length) {
            if (prices[left] < prices[right]) {
                left = right;
            } else {
                max = Math.max(max, prices[right] - prices[left]);
            }
            right++;
        }

        return max;
    }
}
