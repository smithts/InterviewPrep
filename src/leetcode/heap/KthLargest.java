package leetcode.heap;

import java.util.PriorityQueue;

public class KthLargest {
    private PriorityQueue<Integer> pq;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>(k);
        for (int num : nums) {
            add(num);
        }
        while (pq.size() > k) {
            pq.poll();
        }
    }

    public int add(int n) {
        if (pq.size() < k)
            pq.offer(n);
        else if (pq.peek() < n) {
            pq.poll();
            pq.offer(n);
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
