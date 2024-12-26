// Generate Parentheses

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>(); // List to store the valid combinations of parentheses
        
        // Start the DFS with initial parameters
        dfs(0, 0, "", n, res);
        
        return res; // Return the result list
    }

    private void dfs(int openP, int closeP, String s, int n, List<String> res) {
        // Base case: If the number of open and close parentheses equals n and the length is valid
        if (openP == closeP && openP + closeP == n * 2) {
            res.add(s); // Add the valid combination to the result list
            return; // End the recursion
        }

        // If we can add more open parentheses
        if (openP < n) {
            dfs(openP + 1, closeP, s + "(", n, res); // Add an open parenthesis and recurse
        }

        // If we can add more close parentheses (only if it doesn't exceed the open ones)
        if (closeP < openP) {
            dfs(openP, closeP + 1, s + ")", n, res); // Add a close parenthesis and recurse
        }
    }    
}
