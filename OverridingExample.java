public class OverridingExample {
    public int speed(int fastness){
        return fastness;
    }
}
class Velocity extends OverridingExample{
    public int speed(int fastness){
        return fastness*2;
    }

    public static void main(String args[]){
        OverridingExample obj = new Velocity();
        System.out.println(obj.speed(10));
    }
}
