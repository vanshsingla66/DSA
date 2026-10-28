package DP;

import java.util.Arrays;

public class valentine_magic {
    public static void main(String[] args) {
        int[] boys = {1,2,3,4};
        int[] girls = {2,3,4,5,6};
        Arrays.sort(boys);
        Arrays.sort(girls);
        System.out.print(min_diff(boys, girls, 0, 0));
    }
    public static int min_diff(int[] boys,int[] girls, int i,int j){
        if(i==boys.length){
            return 0;
        }
        if(j==girls.length){
            return 999999;
        }
        int sel = Math.abs(boys[i]-girls[j])+min_diff(boys, girls, i+1, j+1);
        int rej = min_diff(boys, girls, i, j+1);
        return Math.min(sel,rej);
    }
}
