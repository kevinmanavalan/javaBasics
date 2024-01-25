public class Company {
    public String openPositions(Candidate guy){
        if("java" == guy.skill1) {
            return "applicable";
        }
        else return "not applicable";

    }
}
