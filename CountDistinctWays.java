// Decode Ways

class Solution {
    public int numDecodings(String s) {
        // If the string starts with '0', it cannot be decoded
        if (s.charAt(0) == '0') {
            return 0;
        }

        int n = s.length();
        int[] dp = new int[n + 1]; // DP array to store the number of ways to decode up to each index
        dp[0] = dp[1] = 1; // Base cases: one way to decode an empty string or a single character (if valid)

        for (int i = 2; i <= n; i++) {
            // Get the value of the current single digit
            int one = Character.getNumericValue(s.charAt(i - 1));
            // Get the value of the two-digit number formed by the current and previous character
            int two = Integer.parseInt(s.substring(i - 2, i));

            // Check if the single digit can form a valid character (1-9)
            if (1 <= one && one <= 9) {
                dp[i] += dp[i - 1]; // Add ways to decode the string without the current character
            }
            // Check if the two-digit number can form a valid character (10-26)
            if (10 <= two && two <= 26) {
                dp[i] += dp[i - 2]; // Add ways to decode the string without the last two characters
            }
        }

        return dp[n]; // Return the total number of ways to decode the string
    }
}

