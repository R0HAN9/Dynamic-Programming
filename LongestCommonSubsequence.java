// Shortest Common Supersequence 

class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[][] t = new int[m+1][n+1];
        
        // Construct the LCS table
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    t[i][j] = t[i-1][j-1]+1;
                }
                else{
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                }
            }
        }
        
        // Build the shortest common supersequence
        StringBuilder sb = new StringBuilder();
        int i=m,j=n;
        while(i>0&&j>0){
            if(str1.charAt(i-1) == str2.charAt(j-1)){
                sb.append(str1.charAt(i-1));
                i--;
                j--;
            }
            else if(t[i-1][j] > t[i][j-1]){
                sb.append(str1.charAt(i-1));
                i--;
            }
            else{
                sb.append(str2.charAt(j-1));
                j--;
            }
        }
        
        // Append remaining characters of str1 and str2
        while(i>0){
            sb.append(str1.charAt(i-1));
            i--;
        }
        while(j>0){
            sb.append(str2.charAt(j-1));
            j--;
        }
        
        return sb.reverse().toString();
    }
}
