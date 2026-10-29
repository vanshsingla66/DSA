package DP;
import java.util.*;
public class super_egg_drop {
    public static void main(String[] args) {
        int k=1,n=2;
        int[][] dp = new int[n+1][k+1];
        for(int[] a:dp){
            Arrays.fill(a,-1);
        }
        System.out.println(solve(n, k, dp));
    }
    public static int solve(int n , int e, int[][] dp){
        if(n==0||n==1||e==1){
            return n;
        }
        if(dp[n][e]!=-1){
            return dp[n][e];
        }
        int ans = Integer.MAX_VALUE;
        for(int f=1;f<=n;f++){
            int b = solve(f-1, e-1, dp);
            int ub = solve(n-f, e, dp);
            int t = Math.max(b,ub)+1;
            ans= Math.max(ans,t);
        }
        return ans;
    }
}
