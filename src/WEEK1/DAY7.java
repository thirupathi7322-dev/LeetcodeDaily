class Solution {
    long totalSum = 0;
    long maxProduct = 0;
    int MOD = 1000000007;

    public int maxProduct(TreeNode root) {
        totalSum = getSum(root);
        getMaxProduct(root);
        return (int)(maxProduct % MOD);
    }

    private long getSum(TreeNode root) {
        if (root == null) return 0;
        return root.val + getSum(root.left) + getSum(root.right);
    }

    private long getMaxProduct(TreeNode root) {
        if (root == null) return 0;
        long subtreeSum = root.val + getMaxProduct(root.left) + getMaxProduct(root.right);
        maxProduct = Math.max(maxProduct, (totalSum - subtreeSum) * subtreeSum);
        return subtreeSum;
    }
}