import java.util.List;

public class ResumeProcessor {

    // Generic method to process a single resume
    public static <T extends JobRole> void processSingleResume(Resume<T> resume) {
        System.out.print("Processing: ");
        resume.process();
    }

    // Wildcard method to process a list of job roles
    public static void processResumePipeline(List<? extends JobRole> jobRoles) {
        for (JobRole role : jobRoles) {
            role.evaluate();
        }
    }
}
