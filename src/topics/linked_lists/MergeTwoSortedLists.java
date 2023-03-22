package topics.linked_lists;

public class MergeTwoSortedLists {

    /*
        You are given the heads of two sorted linked lists list1 and list2.

        Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.

        Return the head of the merged linked list.
    */

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }

        ListNode merged;
        ListNode mergedCrawler;

        //Set head node
        if (list1.val < list2.val) {
            merged = list1;
            list1 = list1.next;
        } else {
            merged = list2;
            list2 = list2.next;
        }
        mergedCrawler = merged;

        //process until one list is empty
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                mergedCrawler.next = list1;
                list1 = list1.next;
            } else {
                mergedCrawler.next = list2;
                list2 = list2.next;
            }
            mergedCrawler = mergedCrawler.next;
        }

        //append remaining elements
        if (list1 == null) {
            mergedCrawler.next = list2;
        } else {
            mergedCrawler.next = list1;
        }

        //finished
        return merged;

    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


}