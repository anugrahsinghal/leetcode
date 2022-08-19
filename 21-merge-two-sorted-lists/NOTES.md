​#### Edge cases
- don't forget that **list can be of diff length**
- **Dont use `||`** - both list in same loop lead to many extra cases
- but instead **think `&&`** and when one list is null, the ***other list automatically becomes the one to be added to end as they are both already sorted***

```
// Algo

// 1->2->4->NULL
// 1->3->4->NULL

// 1. 1 pointer each for both lists
// 2. Assign a new empty dummy Node [O(1)] extra space
// 3. Whichever element is greater in both list add to the end of dummy node
// 4. if any list pointer not at end then add all its nodes to the new list end
// 5. return the new list next node

```

```
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while(l1 != null && l2 != null) {
            int v1 = l1.val;
            int v2 = l2.val;
            if(v1<=v2) {
                dummy.next = new ListNode(v1);
                l1 = l1.next;
                dummy = dummy.next;
            } else {
                dummy.next = new ListNode(v2);
                l2 = l2.next;
                dummy = dummy.next;
            }
        }
        
        if(l1!=null) {
            dummy.next = l1;
        } else if(l2!=null) {
            dummy.next = l2;
        }
        
        return head.next;
    }
}


```
