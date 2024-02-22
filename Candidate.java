public class Candidate {
    public String skill1 = "java";

    public Boolean willGetHired() {
        Company cp = new Company();
        return cp.openPositions(this).equals("applicable");
    }

    public static void main(String args[]) {
        Candidate bb = new Candidate();
        bb.skill1 = "Python";
        System.out.println(bb.willGetHired());
        Candidate aa = new Candidate();
        System.out.println(aa.skill1);
        System.out.println(aa.willGetHired());
    }

}
