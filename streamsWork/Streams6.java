package streamsWork;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


//LIST THE DUPLICATE ELEMENTS

public class Streams6 {
    public static void main(String args[]) {
        List<Integer> list = Arrays.asList(1, 7, 8, 9, 5, 2, 36, 4, 78, 222, 24, 9);
        System.out.println(list);
        Set<Integer> newlist = list.stream().filter(e -> Collections.frequency(list, e) > 1).collect(Collectors.toSet());
        System.out.println(newlist);
    }
}
