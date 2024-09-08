
class Solution {
    public int minDistance(String word1, String word2) {

        int n = word1.length();
        int m= word2.length();

        int []prev = new int [m+1];
        int []cur = new int [m+1];
        
        for(int j=0;j<=m;j++) prev[j]=j;

        
        for(int i=1;i<=n;i++){
            
            cur[0]=i;
            for(int j=1;j<=m;j++){

                if(word1.charAt(i-1)==word2.charAt(j-1)){

                    cur[j]= prev[j-1]; // if word1 and word2 are same no operation is required to convert

                }
                else{ // if words are different "1" operation is required and how many more is recursively calculated

                    int insert = 1+ cur[j-1];
                    int delete = 1+ prev[j];
                    int replace = 1+ prev[j-1];
                    cur[j] = Math.min(insert,Math.min(delete,replace));
                }
            }
            prev = (int [])(cur.clone());
        }
        return prev[m];
    }
}
