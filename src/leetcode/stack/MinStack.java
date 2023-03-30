package leetcode.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class MinStack {

    private List<Integer> values;
    private PriorityQueue minQueue;


    public MinStack() {
        values = new ArrayList<>();
        minQueue = new PriorityQueue<>();
    }

    public void push(int val) {
        values.add(val);
        minQueue.offer(val);
    }

    public void pop() {
        int i = values.get(values.size() - 1);
        values.remove(values.size() - 1);
        minQueue.remove(i);

    }

    public int top() {
        int i = values.get(values.size() - 1);
        minQueue.remove(i);
        return values.remove(values.size() - 1);
    }

    public int getMin() {
        int i = (int) minQueue.peek();
        minQueue.poll();
        return i;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
