package streamsWork;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Streams2 {
    public static void main(String args[]) {
        double avg = 0.0;
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        avg = list.stream().collect(Collectors.averagingInt(Integer::intValue));
        System.out.println(avg);
    }
}




