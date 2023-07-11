package org.example;

import java.util.Arrays;

public class Knapsack_0_1 {
    static int[][] dp;

    public static void main(String[] args) {
        int[] weights = {1,3,4,5};
        int[] values = {1,4,5,7};
        int capacity = 7;
        int size = weights.length;
        //  Recursive Way
//        System.out.println("Maximum Profit is "+knapsack(weights,values,capacity,size));

        //  Memoization Way
        dp = new int[capacity+1][size+1];
        for(int []line:dp){
            Arrays.fill(line,-1);
        }
        System.out.println("Maximum Profit is "+knapsackMemoization(weights,values,capacity,size));
    }

    public static int knapsack(int[] weights, int[] value, int capacity, int size) {
        //  Base Condition
        if (capacity == 0 || size == 0) {
            return 0;
        }

        //  Choice Diagram
        if (weights[size - 1] <= capacity) {
            return Math.max(
                    //  Include the item
                    value[size - 1] + knapsack(weights, value, capacity - weights[size - 1], size - 1),
                    //  Do not include the item
                    knapsack(weights, value, capacity, size - 1)
            );
        } else {
            //  Not possible to include the item
            return knapsack(weights, value, capacity, size - 1);
        }
    }

    public static int knapsackMemoization(int[]weights,int[] value,int capacity, int size){
        //  Base condition
        if(capacity==0 || size==0){
            return 0;
        }
        if(dp[capacity][size]!=-1){
            return dp[capacity][size];
        }
        //  Choice Diagram
        else if(weights[size-1]<capacity){
            return Math.max(
                    //  Include the Item
                    value[size-1] + knapsackMemoization(weights,value,capacity-weights[size-1],size-1),
                    //  Do not include the item
                    knapsackMemoization(weights, value, capacity, size-1)
                    );
        }else{
            //  Not possible to include the item
            return knapsackMemoization(weights, value, capacity, size-1);
        }
    }
}
