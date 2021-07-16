import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=112 lang=java
 *
 * [112] 路径总和
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
    // 递归
    // public boolean hasPathSum(TreeNode root, int sum) {
    //     if (root == null) {
    //         return false;
    //     }
    //     if (root.left == null && root.right == null) {
    //         return sum - root.val == 0;
    //     }
    //     return hasPathSum(root.left, sum - root.val)
    //             || hasPathSum(root.right, sum - root.val);
    // }

    // 标准dfs
    boolean res = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        dfs(root, targetSum);
        return res;
    }

    private void dfs(TreeNode root, int num) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            if (num - root.val == 0){
                res = true;
                return;
            }
        }
        // if (root.left != null) {
        //     dfs(root.left,num - root.val);
        // }
        // if (root.right != null){
        //     dfs(root.right, num - root.val);
        // }
        
        dfs(root.left,num - root.val);
        dfs(root.right, num - root.val);

        // 两种写法，一中加 root == null, 这样就不用筛选
        // 另一种，不加 root == null, 这样就要加筛选条件
    }
}
// @lc code=end

