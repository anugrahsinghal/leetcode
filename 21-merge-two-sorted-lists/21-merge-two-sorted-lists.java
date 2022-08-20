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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-101);
        ListNode head = dummy;
        
        while(l1 != null && l2 != null) {
            int a = l1.val;
            int b = l2.val;
            
            if(a <= b) {
                dummy.next = l1;
                l1 = l1.next;
            } else {
                dummy.next = l2;
                l2 = l2.next;
            }
            dummy.next.next = null;
            dummy = dummy.next;
        }
        
        if(l1 != null) {
            dummy.next = l1;
        } else {
            dummy.next = l2;
        }
        
        return head.next;
    }
}