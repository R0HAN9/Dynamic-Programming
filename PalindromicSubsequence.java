// Longest Palindromic Subsequence

class Solution {
    public int f(int i, int j, char[] s, int dp[][])
    {
        // if pointers crosses each other return 0
        if(i>j) return 0;

        // if both pointers are at same index, return 1.
        if(i==j) return 1;

        // checking overlapping subproblems
        if(dp[i][j]!=-1) return dp[i][j];

         // if currnet character matches, return 1.
        if(s[i]==s[j])
        dp[i][j]= 2+f(i+1, j-1, s, dp);

        else
        dp[i][j]= Math.max(f(i+1,j,s, dp), f(i, j-1, s, dp));
        
        return dp[i][j];
    }
    public int longestPalindromeSubseq(String s) {
        int dp[][] = new int[s.length()][s.length()];
        for(int r[]:dp)  Arrays.fill(r,-1);
        
        return f(0, s.length()-1, s.toCharArray(), dp);
    }
}
