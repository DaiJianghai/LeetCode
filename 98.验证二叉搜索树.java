/*
 * @lc app=leetcode.cn id=98 lang=java
 *
 * [98] 验证二叉搜索树
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
    // 中序遍历结果后，再测试是否有问题
    // public boolean isValidBST(TreeNode root) {
    //     List<Integer> res = new ArrayList<>();
    //     if (root == null) return true;
    //     traverse(root, res);
    //     for (int i = 1; i < res.size(); i++) {
    //         if (res.get(i) <= res.get(i-1)) return false; 
    //     }

    //     return true;
    // }

    // public void traverse(TreeNode root, List<Integer> res){
    //     if (root == null) return;
    //     traverse(root.left, res);
    //     res.add(root.val);
    //     traverse(root.right, res);
    // }

    // 生成序列的时候就判断
    // public boolean isValidBST(TreeNode root) {
    //     if (root == null) return true;
    //     Stack<TreeNode> stack = new Stack<>();
    //     Long lastVal = Long.MIN_VALUE;
    //     while(root != null || !stack.isEmpty()){
    //         while(root != null){
    //             stack.push(root);
    //             root = root.left;
    //         }

    //         TreeNode cur = stack.pop();
    //         if (cur.val <= lastVal) return false;
    //         lastVal = (long)cur.val;
    //         root = cur.right;
    //     }
    //     return true;
    // }

    // 递归
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean helper(TreeNode root, long min, long max){
        if (root == null) return true;
        if (root.val <= min || root.val >= max) return false;
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }

    
}
// @lc code=end

