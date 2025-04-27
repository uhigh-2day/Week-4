public class ProductManager extends JobRole {
    public ProductManager(String candidateName) {
        super(candidateName);
    }

    @Override
    public void evaluate() {
        System.out.println("Evaluating Product Manager Resume for " + getCandidateName());
    }
}
