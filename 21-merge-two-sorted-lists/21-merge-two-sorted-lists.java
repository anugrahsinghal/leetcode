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
        ListNode dummy = new ListNode(0);
        var dummyHead = dummy;
        
        while(l1 != null && l2 != null) {
            int a = l1.val;
            int b = l2.val;
            if(a <= b) {
                dummy.next = l1;
                dummy = dummy.next;    
                l1 = l1.next;
                dummy.next = null;
            } else if(b != -101){ //&& b < a) {
                dummy.next = l2;
                dummy = dummy.next;    
                l2 = l2.next;
                dummy.next = null;
            }
        }
        if(l1 != null) {
            dummy.next = l1;
        } else if(l2 != null) {
            dummy.next = l2;
        }
        
        return dummyHead.next;
    }
    
}