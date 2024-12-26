// Numbers At Most N Given Digit Set

class Solution {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        // Convert the number n to its string representation for digit-by-digit comparison
        String strN = Integer.toString(n);
        int k = strN.length(); // Number of digits in n
        int digitsCount = digits.length; // Number of digits in the given set
        
        // Count numbers with fewer digits than n
        int result = 0;
        for (int i = 1; i < k; i++) {
            // Add all possible numbers with 'i' digits using the given digit set
            result += Math.pow(digitsCount, i);
        }
        
        // Check numbers with the same number of digits as n
        boolean isPrefixValid = true; // To ensure the prefix matches part of n
        for (int i = 0; i < k; i++) {
            
            isPrefixValid = false; // Reset prefix validity for the current digit
            
            for (String digit : digits) {
                if (digit.charAt(0) < strN.charAt(i)) {
                    // If the digit is smaller, count all combinations for remaining positions
                    result += Math.pow(digitsCount, k - i - 1);
                } else if (digit.charAt(0) == strN.charAt(i)) {
                    // If the digit matches, continue checking the next digit
                    isPrefixValid = true;
                }
            }

            // If no valid prefix matches, stop further processing
            if (isPrefixValid == false) return result;
        }
        
        // Include n itself if it can be formed with the given digits
        result += 1;
        
        return result;
    }
}

