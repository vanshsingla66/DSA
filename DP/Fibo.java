package DP;

public class Fibo {

    // Using simple recursion:-
    // public static void main(String[] args) {
    //     int n = 5;
    //     System.out.println(Fib(n));
    // }
    // public static int Fib(int n){
    //     if(n==0 || n==1){
    //         return n;
    //     }
    //     return Fib(n-1) + Fib(n-2);
    // }


    // Using top down dp approach:-
    // public static void main(String[] args) {
    //     int n = 5;
    //     int[] dp = new int[n+1];
    //     System.out.println(FibTD(n,dp));
    // }
    // public static int FibTD(int n,int[] dp){
    //     if(n==0 || n==1){
    //         return n;
    //     }
    //     if(dp[n]!=0){
    //         return dp[n];
    //     }
    //     return dp[n] = FibTD(n-1,dp) + FibTD(n-2,dp);
    // }


    // Using bottom up dp approach:-
    public static void main(String[] args) {
        int n = 2;
        int[] dp = new int[n+1];
        dp[0]=0;
        if(n>0){
            dp[1]=1;
        }
        System.out.println(FibBU(n, dp));
    }
    public static int FibBU(int n, int[] dp){
        for(int i = 2;i<dp.length;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

}
