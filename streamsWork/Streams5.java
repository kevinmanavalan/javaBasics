package streamsWork;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//CONVERT TO UPPERCASE
public class Streams5 {
    public static void main(String args[]) {
        List<String> list = Arrays.asList("kev", "kEvi", "KEviN");
        list = list.stream().map(String::toUpperCase).collect(Collectors.toList());
        for (String item : list) {
            System.out.println(item);
        }
    }
}
