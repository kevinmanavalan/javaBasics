package streamsWork;

import java.util.Comparator;
import java.util.List;
import java.util.Arrays;

//GET MAX VALUE

public class Streams7 {
    public static void main(String args[]) {
        List<Integer> list = Arrays.asList(1, 7, 8, 9, 5, 2, 36, 4, 78, 222, 24, 9);
        System.out.println("Max Val " + list.stream().max((a, b) -> a > b ? 1 : -1).get());
        System.out.println("Max Val " + list.stream().max(Comparator.comparing(Integer::valueOf)).get());
    }
}
