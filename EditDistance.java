
class Solution {
    public int minDistance(String word1, String word2) {

        int n = word1.length(); // Length of the first word
        int m = word2.length(); // Length of the second word

        // Arrays to store the previous and current row of the DP table
        int[] prev = new int[m + 1];
        int[] cur = new int[m + 1];

        // Initialize the base case for transforming an empty string to word2
        for (int j = 0; j <= m; j++) prev[j] = j;

        // Fill the DP table row by row
        for (int i = 1; i <= n; i++) {

            // Base case for transforming word1 to an empty string
            cur[0] = i;

            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // If characters are the same, no operation is needed
                    cur[j] = prev[j - 1];
                } else {
                    // If characters are different, consider the three operations
                    int insert = 1 + cur[j - 1];  // Insert operation
                    int delete = 1 + prev[j];    // Delete operation
                    int replace = 1 + prev[j - 1]; // Replace operation
                    cur[j] = Math.min(insert, Math.min(delete, replace)); // Choose the minimum cost
                }
            }

            // Move the current row to the previous row for the next iteration
            prev = cur.clone();
        }

        // The answer is in the last cell of the `prev` array
        return prev[m];
    }
}

