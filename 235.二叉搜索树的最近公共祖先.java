/*
 * @lc app=leetcode.cn id=235 lang=java
 *
 * [235] 二叉搜索树的最近公共祖先
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {

    // 该题可以利用二叉搜索树性质
    TreeNode res = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        lca(root, p , q);
        return res;
    }
    
    public void lca(TreeNode root, TreeNode p , TreeNode q){
        if((root.val - p.val)*(root.val - q.val) <= 0){ // 分摊两侧
            res = root;
        }else if(root.val < p.val && root.val < q.val){
            lca(root.right, p , q);
        }else{
            lca(root.left, p , q);
        }
    }
}
// @lc code=end

