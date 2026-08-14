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
    int ans=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }
    public int dfs(TreeNode node){
        if(node==null){
            return 0;
        }
        int left=Math.max(0,dfs(node.left));
        int right=Math.max(0,dfs(node.right));

        int current =node.val+left+right;
        ans=Math.max(ans,current);
        return node.val+Math.max(left,right);
    }
}