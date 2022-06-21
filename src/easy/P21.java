/*
21. Merge Two Sorted Lists
Easy

You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

 

Example 1:

# c.f. figure

Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]

Example 2:

Input: list1 = [], list2 = []
Output: []

Example 3:

Input: list1 = [], list2 = [0]
Output: [0]

 

Constraints:

    The number of nodes in both lists is in the range [0, 50].
    -100 <= Node.val <= 100
    Both list1 and list2 are sorted in non-decreasing order.


*/


package easy;

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
public class P21 {
    
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode walk1 = list1, walk2 = list2;
        ListNode tail = null, head = null;
        while (walk1 != null || walk2 != null) {
            
            if (walk1 == null) {
                while (walk2 != null) {
                    // by the two initial checks
                    // the initial lists are non-empty
                    // therefore at this point tail != null
                    assert tail != null;
                    tail.next = walk2;
                    tail = walk2; // or tail = tail.next i.e. advance the tail
                    walk2 = walk2.next;
                }
                break;
            }
            
            if (walk2 == null) {
                while (walk1 != null) {
                    assert tail != null;
                    tail.next = walk1;
                    tail = walk1;
                    walk1 = walk1.next;
                } 
                break;
            }
            
            if (walk1.val <= walk2.val) {
                if (head == null) {
                    head = walk1;
                    tail = head;
                } else {
                    tail.next = walk1;
                    tail = walk1;
                }
                walk1 = walk1.next;   
            }
            
            else {
                if (head == null) {
                    head = walk2;
                    tail = head;
                } else {
                    tail.next = walk2;
                    tail = walk2;
                }
                walk2 = walk2.next;
            }
        }
        
        return head;
    }
}

 
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
