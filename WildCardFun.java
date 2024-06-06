import java.util.LinkedList;
import java.util.List;

public class WildCardFun {
    static class Sample1<T extends List> {

    }
    static class Sample2<T>{
        public void sample(Sample1<? super List> sample){

        }
    }

    public static void main(String[] args) {
//        new WildCardFun.Sample2().sample(new LinkedList());
        Sample1<?> obj = new Sample1<>();

        if (obj instanceof Sample1<?>){

        }
    }
}

