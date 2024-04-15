package streamsWork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class JuiceWorld {
    private String fruit;

    public JuiceWorld(String fruit) {
        this.fruit = fruit;
    }

    public static Stream<JuiceWorld> stream(JuiceWorld[] data) {
        return stream(data);
    }
}

public class CustomStream {
    public static void main(String args[]) {
//        JuiceWorld[] data = {
//                new JuiceWorld("apple"),
//                new JuiceWorld("banana"),
//                new JuiceWorld("orange")};
//        JuiceWorld.stream(data);

        List<JuiceWorld> data = new ArrayList<>();
        
    }
}
