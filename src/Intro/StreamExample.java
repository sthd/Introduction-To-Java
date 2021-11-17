package Intro;

import java.util.Arrays;
import java.util.List;

public class StreamExample {

    public static void main(String[] args) {

        //4 counting strings that are empty
        List<String> strings = Arrays.asList("abc", "", "bc", "efg","abcd", "", "jkl");
        //get count of empty string
        long count = strings.stream().filter(string -> (string.isEmpty())).count();

        //4a counting strings that are not empty
        long countNotEmptyString = strings.stream().filter(string -> (!string.isEmpty())).count();
        System.out.println("strings that are empty " + count);

        //4b printing strings that are not empty
        strings.stream().filter(string -> (!string.isEmpty())).forEach(System.out::println);

        //4c adding squared value of each number and prints it
        int sum = Arrays.stream(new int[] {2, 3, 4, 12}).map(x -> x + x).sum();
        System.out.println("Sum of squared values is: " + sum);
    }
}
