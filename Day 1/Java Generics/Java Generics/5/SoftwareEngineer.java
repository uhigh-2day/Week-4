public class SoftwareEngineer extends JobRole {
    public SoftwareEngineer(String candidateName) {
        super(candidateName);
    }

    @Override
    public void evaluate() {
        System.out.println("Evaluating Software Engineer Resume for " + getCandidateName());
    }
}
