import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

import com.sun.net.httpserver.Filter.Chain;

/*
 * @lc app=leetcode.cn id=257 lang=java
 *
 * [257] 二叉树的所有路径
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<List<Integer>> res_raw = new ArrayList<>();
        if (root == null) return new ArrayList<String>();
        dfs(root, new ArrayList<Integer>(), res_raw);
        List<String> res = post_process(res_raw);
        return res;
    }

    public void dfs(TreeNode root, List<Integer> chain, List<List<Integer>> res){
        chain.add(root.val);
        if (root.left == null && root.right == null){
            res.add(new ArrayList<>(chain));
        }

        if (root.left != null){
            
            dfs(root.left, chain, res);
            chain.remove(chain.size() - 1);
        }


        if (root.right != null){
            
            dfs(root.right, chain, res);
            chain.remove(chain.size() - 1);
        }

    }

    public List<String> post_process(List<List<Integer>> sequence){
        List<String> res = new ArrayList<>();
        for (List<Integer> item : sequence){
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < item.size() ; i++) {
                temp.append(item.get(i));
                if (i != item.size() - 1)
                    temp.append("->");
            }
            res.add(temp.toString());
        }

        return res;
    }
    
}
// @lc code=end

