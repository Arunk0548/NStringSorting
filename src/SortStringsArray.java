import java.util.Arrays;

/**
 * Algorithm
 *
 * The divide-and-conquer strategy is used in quicksort. Below the recursion
 * step is described: Choose a pivot value. We take the value of the middle
 * element as pivot value, but it can be any value, which is in range of sorted
 * values, even if it doesn't present in the array. Partition. Rearrange
 * elements in such a way, that all elements which are lesser than the pivot go
 * to the left part of the array and all elements greater than the pivot, go to
 * the right part of the array. Values equal to the pivot can stay in any part
 * of the array. Notice, that array may be divided in non-equal parts. Sort both
 * parts. Apply quicksort algorithm recursively to the left and the right parts.
 * Partition algorithm in detail
 *
 * There are two indices i and j and at the very beginning of the partition
 * algorithm i points to the first element in the array and j points to the last
 * one. Then algorithm moves i forward, until an element with value greater or
 * equal to the pivot is found. Index j is moved backward, until an element with
 * value lesser or equal to the pivot is found. If i ≤ j then they are swapped
 * and i steps to the next position (i + 1), j steps to the previous one (j -
 * 1). Algorithm stops, when i becomes greater than j.
 *
 * After partition, all values before i-th element are less or equal than the
 * pivot and all values after j-th element are greater or equal to the pivot.
 *
 * @author Arun Kumar
 */
public class SortStringsArray {

    public SortStringsArray(String[] array) {

        System.out.println("Before Sorting :\n" + Arrays.toString(array));
        quickSort(array, 0, array.length - 1);

        printSortednDistinctElements(array);
    }

    private void printSortednDistinctElements(String[] array) {
        System.out.println("After Sorting : ");
        int count = 0;
        for (int j = 0; j < array.length;) {
            count = 1;
            for (int i = j + 1; i < array.length; i++) {
                if (array[i].equals(array[j])) {
                    count++;
                } else {
                    break;
                }

            }
            System.out.print(array[j] + ", ");
            j += count;
        }
    }

    private void quickSort(String[] a, int start, int end) {
        // index for the "left-to-right scan"
        int i = start;
        // index for the "right-to-left scan"
        int j = end;

        // only examine arrays of 2 or more elements.
        if (j - i >= 1) {
            // The pivot point of the sort method is arbitrarily set to the first element int the array.
            String pivot = a[i];
            // only scan between the two indexes, until they meet.
            while (j > i) {
                // from the left, if the current element is lexicographically less than the (original)
                // first element in the String array, move on. Stop advancing the counter when we reach
                // the right or an element that is lexicographically greater than the pivot String.
                while (a[i].compareTo(pivot) <= 0 && i <= end && j > i) {
                    i++;
                }
                // from the right, if the current element is lexicographically greater than the (original)
                // first element in the String array, move on. Stop advancing the counter when we reach
                // the left or an element that is lexicographically less than the pivot String.
                while (a[j].compareTo(pivot) >= 0 && j >= start && j >= i) {
                    j--;
                }
                // check the two elements in the center, the last comparison before the scans cross.
                if (j > i) {
                    swap(a, i, j);
                }
            }
            // At this point, the two scans have crossed each other in the center of the array and stop.
            // The left partition and right partition contain the right groups of numbers but are not
            // sorted themselves. The following recursive code sorts the left and right partitions.

            // Swap the pivot point with the last element of the left partition.
            swap(a, start, j);
            // sort left partition
            quickSort(a, start, j - 1);
            // sort right partition
            quickSort(a, j + 1, end);
        }
    }

    /**
     * This method facilitates the quickSort method's need to swap two elements,
     *
     */
    private void swap(String[] a, int i, int j) {
        String temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
