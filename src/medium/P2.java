/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 

Example 1:

Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.

Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]

Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]

 

Constraints:

    The number of nodes in each linked list is in the range [1, 100].
    0 <= Node.val <= 9
    It is guaranteed that the list represents a number that does not have leading zeros.


*/


package medium;

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
public class P2 {
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return add(l1, l2, 0);
    }
    
    /**
    * uses the first list to store the addition and extends it with the second
    * if the latter is longer
    */
    private ListNode add(ListNode n1, ListNode n2, int rem) {
        if (n1 == null) return continueWith(n2, rem);
        else if (n2 == null) return continueWith(n1, rem);
        int sum = n1.val + n2.val + rem;
        n1.val = sum % 10;
        n1.next = add(n1.next, n2.next, sum / 10);
        return n1;  
    }
    
    private ListNode continueWith(ListNode n, int rem) {
        if (n == null) {
            if (rem == 0) return null;
            return new ListNode(rem);
        }
        int sum = n.val + rem;
        n.val = sum % 10;
        n.next = continueWith(n.next, sum / 10);
        return n;
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
