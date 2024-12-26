// Unique Paths

class Solution {
    public int uniquePaths(int m, int n) {
        // Initialize a 1D array to represent the previous row (starting with all 1s)
        int[] aboveRow = new int[n];
        Arrays.fill(aboveRow, 1); // The first row has only 1 way to reach any cell
        
        // Iterate over each row starting from the second row
        for (int row = 1; row < m; row++) {
            // Create a new array for the current row
            int[] currentRow = new int[n];
            Arrays.fill(currentRow, 1); // The first column always has 1 way to reach
            
            // Fill the current row based on the values from the previous row
            for (int col = 1; col < n; col++) {
                // Current cell = sum of ways from the left cell and the cell above
                currentRow[col] = currentRow[col - 1] + aboveRow[col];
            }
            
            // Update the previous row to the current row for the next iteration
            aboveRow = currentRow;
        }
        
        // The bottom-right corner value is the answer
        return aboveRow[n - 1];        
    }
}

