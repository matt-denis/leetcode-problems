/*
Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.

 

Example 1:

Input: head = [1,1,2]
Output: [1,2]

Example 2:

Input: head = [1,1,2,3,3]
Output: [1,2,3]

 

Constraints:

    The number of nodes in the list is in the range [0, 300].
    -100 <= Node.val <= 100
    The list is guaranteed to be sorted in ascending order.


*/


package easy;

public class P83 {
    
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode trail = head, lead = head.next;
        while (lead != null) {
            if (lead.val == trail.val) {
                remove(trail); // remove lead
                lead = trail.next;
            } else {
                trail = lead;
                lead = lead.next;
            }
        }
        
        return head;
    }
    
    private void remove(ListNode precedent) {
        if (precedent.next == null) return;  // TODO: not needed??
        precedent.next = precedent.next.next;
    }
}
