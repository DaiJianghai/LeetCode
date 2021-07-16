/*
 * @lc app=leetcode.cn id=103 lang=java
 *
 * [103] 二叉树的锯齿形层序遍历
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null) return res;
        int layer = 0;
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                temp.add(cur.val);
                if (layer % 2 == 1){
                    if (cur.left != null)  q.offer(cur.left);
                    if (cur.right != null) q.offer(cur.right);
                }else if(layer % 2 == 0){
                    if (cur.right != null) q.offer(cur.right);
                    if (cur.left != null)  q.offer(cur.left);
                }
   
            }
            res.add(temp);
            layer++;
        }

        return res;
    }
}
// @lc code=end

