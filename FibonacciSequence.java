// Min Cost Climbing Stairs


class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];

        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < n; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }

        return Math.min(dp[n - 1], dp[n - 2]);
    }
}

// 2. Fibonacci Number

class Solution {
    public int fib(int n) {
        
        if (n <= 1) return n;
        int[] fibNum = new int[n + 1];

        fibNum[0] = 1;
        fibNum[1] = 1;

        for (int i = 2; i <= n; i++) {
            fibNum[i] = fibNum[i - 1] + fibNum[i - 2];
        }

        return fibNum[n - 1];
    }
}


// LEETCODE DAILY

class Solution {
    public int maxWidthRamp(int[] nums) {
        
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (stack.isEmpty() || nums[stack.peek()] > nums[i]) {
                stack.push(i);
            }
        }

        int answer = 0;
        for (int i = n-1; i > 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {

                answer = Math.max(answer, i - stack.peek());
                stack.pop();
            }
        }
        return answer;
    }
}
