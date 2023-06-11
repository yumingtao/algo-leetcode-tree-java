import com.ymt.leetcode.tree.TreeNode;

public class Solution1 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }
        targetSum = targetSum - root.val;
        if(root.left == null && root.right == null){
            return targetSum == 0;
        }
        return hasPathSum(root.right, targetSum) || hasPathSum(root.left, targetSum);
    }
    
    public static void main(String[] args){
        System.out.println("hello");
    }
}