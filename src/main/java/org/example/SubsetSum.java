package org.example;

public class SubsetSum {
    public static boolean subsetSum(int[] array, int size, int sum) {
        boolean[][] t = new boolean[size + 1][sum + 1];
        for (int i = 0; i < size + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (i == 0) {
                    t[i][j] = false;
                }
                if (j == 0) {
                    t[i][j] = true;
                }
            }
        }
        for (int i = 1; i < size + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {

                if (array[i - 1] <= j) {
                    t[i][j] = (t[i-1][j - array[i - 1]]) || t[i - 1][j];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }
        return t[size][sum];
    }

    public static void main(String[] args) {

        int[] array = {2,3,7,8,10};
        int sum = 6;
        int size = array.length;
        System.out.println(subsetSum(array, size, sum));
    }
}
