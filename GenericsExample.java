public class GenericsExample {
    static class KeyBoard<T> {
        T key;

        public KeyBoard(T key) {
            this.key = key;
        }

        public void keyPressed() {
            System.out.println("The " + key + " has been pressed");
        }

        public T action() {
            return (T) key;
        }

        public static void main(String args[]) {
            KeyBoard<String> alpha = new KeyBoard<>("A");
            alpha.keyPressed();
            System.out.println(alpha.action().getClass().getName());

            KeyBoard<Integer> numeric = new KeyBoard<>(1);
            numeric.keyPressed();
            System.out.println(numeric.action().getClass().getName());

            KeyBoard<Boolean> bool = new KeyBoard<>(true);
            bool.keyPressed();
            System.out.println(bool.action().getClass().getName());
        }
    }
}
