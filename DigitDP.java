// Numbers At Most N Given Digit Set

class Solution {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        String strN = Integer.toString(n);
        int k = strN.length();
        int digitsCount = digits.length;
        
        // Count numbers with fewer digits than n
        int result = 0;
        for (int i = 1; i < k; i++) {
            result += Math.pow(digitsCount, i);
        }
        
        // Count numbers with the same number of digits as n
        boolean isPrefixValid = true;
        for (int i = 0; i < k; i++) {
            
            
            isPrefixValid = false;
            for (String digit : digits) {
                if (digit.charAt(0) < strN.charAt(i)) {
                    result += Math.pow(digitsCount, k - i - 1);
                } else if (digit.charAt(0) == strN.charAt(i)) {
                    isPrefixValid = true;
                }
            }

            if(isPrefixValid == false) return result ;
        }
        
        // Include the number n itself if it is valid
        result += 1;
        
        return result ;
    }
}
