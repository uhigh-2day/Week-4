import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Individual resumes
        Resume<SoftwareEngineer> seResume = new Resume<>(new SoftwareEngineer("Alice"));
        Resume<DataScientist> dsResume = new Resume<>(new DataScientist("Bob"));
        Resume<ProductManager> pmResume = new Resume<>(new ProductManager("Charlie"));

        // Process individual resumes
        ResumeProcessor.processSingleResume(seResume);
        ResumeProcessor.processSingleResume(dsResume);
        ResumeProcessor.processSingleResume(pmResume);

        System.out.println("\n--- Screening Pipeline ---");

        // Resume pipeline (all job roles)
        List<JobRole> resumePipeline = new ArrayList<>();
        resumePipeline.add(new SoftwareEngineer("Dave"));
        resumePipeline.add(new DataScientist("Eve"));
        resumePipeline.add(new ProductManager("Frank"));

        ResumeProcessor.processResumePipeline(resumePipeline);
    }
}
