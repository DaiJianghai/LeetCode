import java.util.ArrayList;
import java.util.List;

import publicStructure.TreeNode;

/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] 二叉树的中序遍历
 */

// @lc code=start

//Definition for a binary tree node.
//  public class TreeNode {
//      int val;
//      TreeNode left;
//      TreeNode right;
//      TreeNode() {}
//      TreeNode(int val) { this.val = val; }
//      TreeNode(int val, TreeNode left, TreeNode right) {
//          this.val = val;
//          this.left = left;
//          this.right = right;
//      }
//  }


 
class Solution {
    // 递归
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        traverse(root, res);
        return res;
    }

    public void traverse(TreeNode root, List<Integer> res){
        if (root == null) return;
        traverse(root.left, res);
        res.add(root.val);
        traverse(root.right, res);
    }

    // 非递归
    public List<Integer> inorderTraversal_2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }

            TreeNode cur = stack.pop();
            res.add(cur.val);
            root = cur.right;
        }

        return res;
    }

    public static void main(String[] args) {
        // Solution solution = new Solution();
        // TreeNode 
        // List<Integer> res = solution.inorderTraversal(root);
    }

}
// @lc code=end

