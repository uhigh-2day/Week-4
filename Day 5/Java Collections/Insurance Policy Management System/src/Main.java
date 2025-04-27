import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        PolicyManager manager = new PolicyManager();

        // Sample policies
        manager.addPolicy(new Policy("P1001", "Alice", LocalDate.now().plusDays(10)));
        manager.addPolicy(new Policy("P1002", "Bob", LocalDate.now().plusDays(40)));
        manager.addPolicy(new Policy("P1003", "Charlie", LocalDate.now().minusDays(5)));
        manager.addPolicy(new Policy("P1004", "Alice", LocalDate.now().plusDays(25)));

        // Retrieve by policy number
        System.out.println("Policy P1002: " + manager.getPolicyByNumber("P1002"));

        // Policies expiring in 30 days
        System.out.println("\nPolicies expiring in next 30 days:");
        manager.getPoliciesExpiringInNext30Days().forEach(System.out::println);

        // Policies by holder
        System.out.println("\nPolicies for Alice:");
        manager.getPoliciesByHolder("Alice").forEach(System.out::println);

        // Remove expired policies
        System.out.println("\nRemoving expired policies...");
        manager.removeExpiredPolicies();

        // Show all current policies
        System.out.println("\nCurrent policies:");
        manager.printAllPoliciesInOrder();
    }
}
