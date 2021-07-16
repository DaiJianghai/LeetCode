/*
 * @lc app=leetcode.cn id=101 lang=java
 *
 * [101] 对称二叉树
 */

// @lc code=start
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
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return helper(root.left, root.right);
    }

    public boolean helper(TreeNode leftRoot, TreeNode rightRoot){
        if (leftRoot == null && rightRoot == null) return true;
        if (leftRoot == null || rightRoot == null) return false;
        if (leftRoot.val != rightRoot.val) return false;
        return helper(leftRoot.left, rightRoot.right) && helper(leftRoot.right, rightRoot.left) ;
    }
}
// @lc code=end

