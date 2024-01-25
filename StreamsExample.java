import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class StreamsExample {

    public static void main(String args[]){
    List<String> colors = Arrays.asList("Red", "Green", "Blue", "Pink", "Brown");
        colors = colors.stream().filter(color -> !color.startsWith("R")).collect(new CollectorImplementation<>());
        for(String color: colors){
            System.out.println(color);
        }
    }
    /*CREATING A CUSTOM COLLECTOR THAT CONVERTS A COLLECTED STREAM INTO A LIST*/
    public static class CollectorImplementation<T,A, R> implements Collector<T, List<T>, List<T>>
    {

        @Override
        public Supplier<List<T>> supplier() {
            Supplier<List<T>> obj = ()-> new ArrayList<T>();
            return obj;
        }

        @Override
        public BiConsumer<List<T>, T> accumulator() {
            BiConsumer<List<T>, T> obj = (list, item) -> list.add(item);
            return obj;
        }

        @Override
        public BinaryOperator<List<T>> combiner() {
            BinaryOperator<List<T>> obj = (left, right)-> {left.addAll(right);return left; };
            return obj;
        }

        @Override
        public Function<List<T>, List<T>> finisher()
        {
            return list->list;
        }
        /*SETTING THE CHARACTERISTICS OF THE COLLECTOR AS CONCURRENT SO A TO ENABLE MULTI-THREAD ACCUMULATION*/
        @Override
        public Set<Characteristics> characteristics() {
            return EnumSet.of(Characteristics.CONCURRENT);
        }
    }


}
