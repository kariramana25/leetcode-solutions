/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Nth Node From End of List.
 * Memory Usage: 40.6 MB, less than 6.37% of Java online submissions for Remove Nth Node From End of List.
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head, slow = head, temp = head, prev = null;
        for (int i = 0; i < n; i++)
            fast = fast.next;

        while (fast != null){
            slow = slow.next;
            fast = fast.next;
        }

        while(temp != slow) {
            prev= temp;
            temp = temp.next;
        }
        if (prev != null)
            prev.next = prev.next.next;
        else
            head = head.next;
        return head;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        ListNode prev = dummy;

        for (int i = 0; i <= n; i++) {
            current = current.next;
        }

        while (current != null) {
            prev = prev.next;
            current = current.next;
        }
        prev.next = prev.next.next;

        return dummy.next;
    }
}