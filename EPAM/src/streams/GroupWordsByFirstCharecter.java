package streams;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupWordsByFirstCharecter {

    public static void main(String[] args) {

        List<String> wordsList = List.of("apple", "banana", "mango", "car", "bike", "animal");
        Map<Character, List<String>> map = groupWordsByFirstLetter(wordsList);
        System.out.println(map);
    }

    private static Map<Character, List<String>> groupWordsByFirstLetter(List<String> words) {

        // Method1
        return words.stream()
                .collect(Collectors.groupingBy(s -> s.charAt(0)));
       /*

         // Method 2
         words.stream()
                .collect(Collectors.groupingBy(s -> s.charAt(0), Collectors.toList()));

        // Method 3 - Using toMap & advanced merging concepts
        words.stream()
                .collect(Collectors.toMap(
                        s -> s.charAt(0), s -> new ArrayList<>(List.of(s)),
                        (l1, l2) -> {
                            l1.addAll(l2);
                            return l1;
                        }));

       */
    }

}
