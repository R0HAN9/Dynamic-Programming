// Last Stone Weight II

class Solution {
    public int lastStoneWeightII(int[] stones) {
        int totSum=0;
        for(int x:stones){
            totSum+=x;
        }
        int [][]dp=new int[stones.length][totSum+1];
        for(int []arr:dp)Arrays.fill(arr,-1);
        int diff=recursion(0,stones,totSum/2,dp);

        return totSum-2*diff;
    }
    public int recursion(int index,int []stones,int W,int [][]dp){
        if(index==stones.length-1){
            if(stones[index]<=W)return stones[index];
            else return 0;
        }
        if(dp[index][W]!=-1)return dp[index][W];
        int notTake=recursion(index+1,stones,W,dp);
        int take=Integer.MIN_VALUE;

        if(stones[index]<=W){
            take=stones[index]+recursion(index+1,stones,W-stones[index],dp);
        }

        return dp[index][W]=Math.max(notTake,take);
    }
}
