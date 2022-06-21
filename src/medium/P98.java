/*
98. Validate Binary Search Tree
Medium

Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

    The left subtree of a node contains only nodes with keys less than the node's key.
    The right subtree of a node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees must also be binary search trees.

 

Example 1:

Input: root = [2,1,3]
Output: true

Example 2:

Input: root = [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.

 

Constraints:

    The number of nodes in the tree is in the range [1, 104].
    -231 <= Node.val <= 231 - 1


*/


package medium;


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class P98 {

    public boolean isValidBST(TreeNode root) {
        return checkBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    /**
     * Checks whether the tree rooted at {@code node} is a BST
     * @param node the current node
     * @param lo : The lower bound of the range where {@code node.val} is expected to fall
     * @param hi : The higher bound of the range where {@code node.val} is expected to fall
     * @return true if the tree rooted at node is a BST
     */
    private boolean checkBST(TreeNode node, long lo, long hi) {
        if (node == null) return true;
        if (node.val <= lo || node.val >= hi) return false;
        // now we know node.val is in between the range
        return checkBST(node.left, lo, node.val) && checkBST(node.right, node.val, hi);
    }

    /* without using long: use null to represent infinity */

    public boolean isValidBST2(TreeNode root) {
        return checkBST2(root, null, null);
    }

    private boolean checkBST2(TreeNode node, Integer lo, Integer hi) {
        if (node == null) return true;
        if (lo != null && node.val <= lo) return false;
        if (hi != null && node.val >= hi) return false;

        return checkBST2(node.left, lo, node.val) && checkBST2(node, node.val, hi);
    }

    /* inorder traversal: in a BST inorder traversal yields keys in increasing order */

    public boolean isValidBST3(TreeNode root) {
        return inorder(root, null);
    }

    /**
     * 
     * @param node current node
     * @param prev prevous value
     * @return true if the tree rooted at {@code node} is a BST
     */
    private boolean inorder(TreeNode node, Integer prev) {
        if (node == null) return true;
        if (!inorder(node.left, prev)) return false;
        if (prev != null && node.val <= prev) return false;
        prev = node.val;
        return inorder(node.right, prev);
    }
}



class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
 