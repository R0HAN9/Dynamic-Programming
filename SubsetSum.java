// Partition Equal Subset Sum

class Solution {
    public boolean canPartition(int[] nums) {
        int N = nums.length;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += nums[i];
        }

        // Check if the total sum is odd, then it cannot be partitioned into two equal subsets
        if (sum % 2 != 0) {
            return false;
        }

        // Check if there exists a subset with sum equal to sum/2
        return subSetSum(nums, sum / 2, N);
    }

    static boolean subSetSum(int[] nums, int sum, int n) {
        boolean[][] dp = new boolean[n + 1][sum + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (i == 0)
                    dp[i][j] = false;
                if (j == 0)
                    dp[i][j] = true;
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][sum];
    }
}
