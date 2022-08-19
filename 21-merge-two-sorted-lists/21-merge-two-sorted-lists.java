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
        if(l1 == null && l2 == null) {
            return l1;
        } 
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }
        
        ListNode dummy = new ListNode(0);
        var dummyHead = dummy;
        
        /*
        a
        1->2->4
        b
        1->3->4
        
        
        dummy = 0
        
        if(a <= b) {1<=1
            dummy.next = l1;0-1
            dummy = dummy.next;
            
            l1 = l1.next;
            dummy.next = null;
        }
        
        */
        
        while(l1 != null || l2 != null) {
            int a = l1 == null ? -101 : l1.val;//2
            int b = l2 == null ? -101 : l2.val;//1
            // a = null, b != null
            // a != null, b = null
            if(b == -101) {
                dummy.next = l1;
                dummy = dummy.next;    
                l1 = l1.next;
                dummy.next = null;
            } else if(a == -101) {
                dummy.next = l2;
                dummy = dummy.next;    
                l2 = l2.next;
                dummy.next = null;
            } else if(a <= b) {
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
        
        return dummyHead.next;
    }
    
    
    // void print(ListNode l) {
    //     var temp = l;
    //     while(temp != null) {
    //         System.out.print(temp.val);
    //         System.out.print("->");
    //         temp = temp.next;
    //     }
    //     System.out.println("null");
    // }
}