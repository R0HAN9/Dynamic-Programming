// Last Stone Weight II

class Solution {
    public int lastStoneWeightII(int[] stones) {
        // Calculate the total sum of all stones
        int totSum = 0;
        for (int x : stones) {
            totSum += x;
        }

        // Create a DP table to memoize results, initialized to -1
        int[][] dp = new int[stones.length][totSum + 1];
        for (int[] arr : dp) Arrays.fill(arr, -1);

        // Use recursion to find the closest sum to totSum / 2
        int diff = recursion(0, stones, totSum / 2, dp);

        // Return the minimum possible difference between the two groups
        return totSum - 2 * diff;
    }

    // Helper function for recursion with memoization
    public int recursion(int index, int[] stones, int W, int[][] dp) {
        // Base case: if we are at the last stone
        if (index == stones.length - 1) {
            // If the last stone can be included within the weight limit, return its value
            if (stones[index] <= W) return stones[index];
            else return 0; // Otherwise, return 0 as it cannot be included
        }

        // If the result is already computed, return it
        if (dp[index][W] != -1) return dp[index][W];

        // Recursive case: Option 1 - Do not take the current stone
        int notTake = recursion(index + 1, stones, W, dp);

        // Recursive case: Option 2 - Take the current stone if it fits in the weight limit
        int take = Integer.MIN_VALUE; // Initialize with a very small value
        if (stones[index] <= W) {
            take = stones[index] + recursion(index + 1, stones, W - stones[index], dp);
        }

        // Store and return the maximum value of the two options
        return dp[index][W] = Math.max(notTake, take);
    }
}

