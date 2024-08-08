package app;

public class ArrayUtils {
    public static int[] mergeSort(int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }
        int middle = array.length / 2;
// Create two subarrays
        int[] leftSubarray = new int[middle];
        int[] rightSubarray = new int[array.length - middle];
// Populate the left and right subarrays
        for (int i = 0; i < middle; i++) {
            leftSubarray[i] = array[i];
        }
        for (int i = middle; i < array.length; i++) {
            rightSubarray[i - middle] = array[i];
        }
        mergeSort(leftSubarray);
        mergeSort(rightSubarray);

        // Merge the sorted subarrays
        merge(array, leftSubarray, rightSubarray);
        return array;
    }
    private static void merge(int[] array, int[] leftSubarray, int[] rightSubarray) {
        int i = 0; // Index for the left subarray
        int j = 0; // Index for the right subarray
        int k = 0; // Index for the merged array
        while (i < leftSubarray.length && j < rightSubarray.length) {
            if (leftSubarray[i] < rightSubarray[j]) {
                array[k++] = leftSubarray[i++];
            } else {
                array[k++] = rightSubarray[j++];
            }
        }
        // Copy any remaining elements from leftSubarray and rightSubarray
        while (i < leftSubarray.length) {
            array[k++] = leftSubarray[i++];
        }
        while (j < rightSubarray.length) {
            array[k++] = rightSubarray[j++];
        }

    }

    public static int binarySearch(int[] sortedArray, int target) {
        return binarySearch0(sortedArray,0,sortedArray.length, target);
    }

    private static int binarySearch0(int[] a, int fromIndex, int toIndex,
                                     int key) {
        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = a[mid];

            if (midVal < key)
                low = mid + 1;
            else if (midVal > key)
                high = mid - 1;
            else
                return mid; // key found
        }
        return -(low + 1);  // key not found.
    }

}
