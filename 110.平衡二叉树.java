/*
 * @lc app=leetcode.cn id=110 lang=java
 *
 * [110] 平衡二叉树
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
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int lh = getHeight(root.left);
        int rh = getHeight(root.right);
        if (Math.abs(lh-rh) <= 1 && isBalanced(root.left) && isBalanced(root.right))
            return true;
        return false;
    }

    public int getHeight(TreeNode root){
        if (root == null) return 0;
        return (Math.max(getHeight(root.left), getHeight(root.right))) + 1;
    }
}
// @lc code=end

