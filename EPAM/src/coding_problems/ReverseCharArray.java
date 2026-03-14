package coding_problems;

import java.util.Arrays;

public class ReverseCharArray {

    public static void main(String[] args) {

        String str = "hello";
        char[] charArray = str.toCharArray();

        System.out.println(Arrays.toString(reverseCharArray(charArray)));
    }

    private static char[] reverseCharArray(char[] arr) {

        if(arr == null || arr.length == 0)
            return new char[0];

        int start = 0, end =  arr.length - 1;

        while (start < end) {

            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }

        return arr;
    }
}
