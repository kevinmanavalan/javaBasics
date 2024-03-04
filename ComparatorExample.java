import java.util.*;

public class ComparatorExample {
//    static List<String> names = Arrays.asList("kevin", "add", "ffg", "qer", "dsfsd");
//    public static void main (String args[]){
//        for(String name : names){
//            System.out.println(name);
//        }
//       names.sort((str1, str2) ->str1.length()>str2.length() ? 1 : -1);
//
//        for(String name: names){
//            System.out.println(name);
//        }
//        ArrayList<String> arr = new ArrayList<>(new LinkedList());
//    }

    static class Student {
        String name;
        int age;

        Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public static void main(String args[]) {
            List<Student> studentList = new ArrayList<>();
            studentList.add(new Student("Kevin", 24));
            studentList.add(new Student("Kevin", 25));
            studentList.add(new Student("Sam", 24));
            studentList.add(new Student("Jake", 24));
            studentList.add(new Student("Paul", 24));

            for (Student student : studentList) {
                System.out.println(student.name + " " + student.age);
            }
            Collections.sort(
                    studentList,
                    Comparator.comparing(student -> student.getAge()));
            for (Student student : studentList) {
                System.out.println(student.name + " " + student.age);
            }

        }
    }
}
