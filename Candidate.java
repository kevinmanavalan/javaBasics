public class Candidate {
    public String skill1 = "java";
    public Boolean willGetHired(){
        Company cp = new Company();
        return cp.openPositions(this).equals( "applicable");
    }

    public static void main(String args[]){
        Candidate bb = new Candidate();
        bb.skill1="Python";
        Candidate aa = new Candidate();
        System.out.println(aa.skill1);
    }

}
