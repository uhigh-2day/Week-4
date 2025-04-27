public class DataScientist extends JobRole {
    public DataScientist(String candidateName) {
        super(candidateName);
    }

    @Override
    public void evaluate() {
        System.out.println("Evaluating Data Scientist Resume for " + getCandidateName());
    }
}
