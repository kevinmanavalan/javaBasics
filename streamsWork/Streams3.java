package streamsWork;

import java.util.Arrays;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;


//IMPLEMENTING THE FLATMAP() OF THE STREAM CLASS


public class Streams3 {
    public static void main(String args[]) {
        List<List<String>> namesNested = Arrays.asList(
                Arrays.asList("Jeff", "Bezos"),
                Arrays.asList("Bill", "Gates"),
                Arrays.asList("Mark", "Zuckerberg"));

        List<String> namesFlatStream = namesNested.stream()
                .flatMap(Collection::stream).collect(Collectors.toList());
        assertEquals(namesFlatStream.size(), namesNested.size() * 2);
    }

}
