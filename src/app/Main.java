package app;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] myArray = {4, 6, -1, 7, 8, 17};
        int key = 7;

        System.out.println("Before the merge: " + Arrays.toString(myArray));

        int[] sortedArray = ArrayUtils.mergeSort(myArray);

        System.out.println("After the merge: " + Arrays.toString(sortedArray));

        String searchIndex = Integer.toString(ArrayUtils.binarySearch(sortedArray,key));
        System.out.printf("The index of the key %s is %s. %n", key, searchIndex);

    }

}