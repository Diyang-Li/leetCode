package tree;

/**
 * @author Diyang Li
 * @create 2022-08-06 5:13 PM
 */
public class _437_PathSumIII {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int count = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return count;

        rootSum(root, targetSum);

        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);

        return count;
    }

    /**
     * method 1: O(n^2)
     * @param root
     * @param targetSum
     */
    public void rootSum(TreeNode root, long targetSum){
        if(root == null) return;

        targetSum -= root.val;

        if(targetSum == 0) {
            count++;

        };

        rootSum(root.left, targetSum);
        rootSum(root.right, targetSum);
    }

    // 前缀树： https://www.bilibili.com/video/BV1Z44y1T7sk?spm_id_from=333.337.search-card.all.click&vd_source=82c20631d4fe5c73eeeb14130d72a5be
    //[1,-2,-3,1,3,-2,null,-1]
    //-1   (1,-2)(1,-2, 1, -1), (-2, 1) (-1)
}
