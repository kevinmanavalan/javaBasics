import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class LambdaLearning<E> {

    private List<E> fruits = new ArrayList<>();

    public int prod(int num) {
        return num * 2;
    }


    public int div(int num) {
        return num / 2;
    }

    public int sum(int num) {
        return num + 2;
    }

    public Basket getMypreferedFruit(Function<List<E>, E> prefLogic, int kg) {

        E prefFruit = prefLogic.apply(fruits);
        //

        return new Basket(kg + " kilos of  " + prefFruit);
    }

    public static void main(String args[]) {
        LambdaLearning<String> tt = new LambdaLearning<>();
        Function<Integer, Integer> prod = tt::prod;
        Function<Integer, Integer> div = tt::div;
        Function<Integer, Integer> sum = tt::sum;
        System.out.println(sum.apply(div.apply(prod.apply(3))));


        Basket fruitBasket = tt.getMypreferedFruit(list -> {
            String myFirst = null;
            String mySecond = null;
            for (String fruit : list) {
                if (fruit.equals("Apple"))
                    myFirst = fruit;
                if (fruit.equals("Orange"))
                    mySecond = fruit;
            }
            return myFirst != null ? myFirst : mySecond;
        }, 2);
        System.out.println(fruitBasket.myFruit);
    }


    static class Basket {
        String myFruit = null;

        public Basket(String fruit) {
            this.myFruit = fruit;
        }
    }


}
