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
    int count = 0;
    public int averageOfSubtree(TreeNode root) {
        int [] temp= helper(root);
        return count;
    }
    public int[] helper(TreeNode node){
        if(node==null){
            return new int[]{0,0};
        }
        int [] left = helper(node.left);
        int [] right = helper(node.right);

        int sum = node.val+left[0]+right[0];
        int n = left[1]+right[1]+1;
        int avg = sum/n;
        if(avg==node.val){
            count++;
        }
        return new int[]{sum,n};
    }
}