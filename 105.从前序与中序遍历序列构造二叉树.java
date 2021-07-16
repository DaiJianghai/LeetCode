import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) return null;
        return build(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    public TreeNode build(int[] preorder, int ps, int pe, int[] inorder, int is,  int ie){
        if (is > ie) return null;
        int root_index = -1;
        for (int i = is; i <= ie; i++) {
            if (inorder[i] == preorder[ps]) root_index = i;
        }
        int part_size = root_index - is;
        TreeNode root = new TreeNode(inorder[root_index]);
        TreeNode leftTree = build(preorder, ps + 1, ps + part_size, inorder, is, root_index - 1);
        TreeNode rightTree = build(preorder, ps + part_size + 1, pe, inorder, root_index + 1, ie);
        root.left = leftTree;
        root.right = rightTree;
        return root;
    }
}
// @lc code=end

