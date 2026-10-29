package DP;

public class optimal_game_strategy {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        System.out.println(solve(arr,0,arr.length-1));
    }
    private static int solve(int[] arr, int i, int j){
        if(i>=j){
            return 0;
        }
        if(i+1==j){
            return Math.max(arr[i], arr[j]);
        }
        int x = arr[i] + Math.min(solve(arr, i+1, j-1),solve(arr, i+2, j));
        int y = arr[j] + Math.min(solve(arr, i+1, j-1),solve(arr, i, j-2));
        return Math.max(x,y);
    }
}
