package leetcode.linked_lists;

public class ReverseInPlace {

    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode previous = null;

        while (current != null) {
            ListNode next = current;
            current = current.next;
            next.next = previous;
            previous = next;
        }

        return previous;
    }

}
