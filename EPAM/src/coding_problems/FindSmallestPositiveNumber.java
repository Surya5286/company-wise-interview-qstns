package coding_problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindSmallestPositiveNumber {
    public static void main(String[] args) {
        int[] arr = {3, 4, -1, 1};
        System.out.println("The smallest missing positive number is: " + findSmallestMissingPositiveUsingSorting(arr));

        int[] arr2 = {1, 2, 0};
        System.out.println("The smallest missing positive number is: " + findSmallestMissingPositiveUsingSorting(arr2));

        int[] arr3 = {7, 8, 9, 11, 12};
        System.out.println("The smallest missing positive number is: " + findSmallestMissingPositiveUsingOptimalApproach(arr3));

        int[] arr4 = {-3, -2, -1};
        System.out.println("The smallest missing positive number is: " + findSmallestMissingPositiveUsingOptimalApproach(arr4));

        int[] arr5 = {-3, -2, -1, 1, 2, 3};
        System.out.println("The smallest missing positive number is: " + findSmallestMissingPositiveUsingSet(arr5));
    }

    // TC - O[NlogN] SC - O[1]
    private static int findSmallestMissingPositiveUsingSorting(int[] arr) {

        if(arr == null || arr.length == 0)
            return 1;

        Arrays.sort(arr);

        int smallestMissing = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == smallestMissing) {
                smallestMissing++;
            } else if (arr[i] > smallestMissing) {
                break; // No need to check further
            }
        }

        return smallestMissing;
    }

    // TC - O[n] SC - O[n]
    private static int findSmallestMissingPositiveUsingSet(int[] arr) {
        int smallestMissing = 1;

        if(arr == null || arr.length == 0)
            return smallestMissing;

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > 0)
                set.add(arr[i]);
        }

        while (set.contains(smallestMissing)) {
            smallestMissing++;
        }

        return smallestMissing;
    }

    // TC - O[n] SC - O[1]
    private static int findSmallestMissingPositiveUsingOptimalApproach(int[] arr) {

        // Edge Cases
        if(arr == null || arr.length == 0)
            return 1;

        /*
            As in above approach - how we used an external set, now we will update the same concept but within the same array.+
            Step1:- First iterate through the list and update all negative numbers to n+1
            Step2:- Iterate through loop,
                get the absolute value of index then check
                if value == 0, continue
                Get the value's index position -> update that value in that position to negative
            Step3:- Loop through array, if index is positive -> return (index + 1)


        */

        int n = arr.length;

        // Step1
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] <= 0 || arr[i] > n)
                arr[i] = n+1;
        }

        // Step2
        for (int i = 0; i < n; i++) {
            int num = Math.abs(arr[i]);
            if(num == n+1)
                continue;   // Skip placeholder value
            int index = num-1;  // Convert to 0 Based index
            if(arr[index] > 0)
                arr[index] = -arr[index];   // Mark as present by making negative.
        }

        // Step3
        for (int i = 0; i < n; i++) {
            if(arr[i] > 0)
                return i+1;
        }

        return n+1;
    }
}
