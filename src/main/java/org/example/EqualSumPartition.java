package org.example;

import static org.example.SubsetSum.subsetSum;

public class EqualSumPartition {

    public static boolean equalSumPartition(int[] array,int size){
        Long addition = 0L;
        for(int i =0;i<size;i++){
            addition = addition+array[i];
        }
        if(addition%2!=0)
            return false;
        else{
            return subsetSum(array, size,(int) (addition/2));
        }
    }

    public static void main(String[] args) {
        int[] array = {2, 3, 7, 8, 10};
        int size = array.length;
        System.out.println(equalSumPartition(array, size));
    }
}
