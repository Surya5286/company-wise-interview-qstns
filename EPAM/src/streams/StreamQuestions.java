package streams;

import java.util.Arrays;

public class StreamQuestions {

    public static void main(String[] args) {

        // 1. Array of Strings is provided, need to find longest length using Streams
        String str = "Array of Strings provided need to find longest length using Streams";
        int longest = getLongestWordLengthFromString(str);
        System.out.println(longest);
    }

    private static int getLongestWordLengthFromString(String str) {

        String[] words = str.split(" ");
        System.out.println(Arrays.toString(words));
        return Arrays.stream(words)
                .filter(word -> !word.isEmpty())
                .mapToInt(String::length)
                .max()
                .orElse(0);
    }
}
