import java.time.LocalDate;
import java.util.*;

public class PolicyManager {
    private HashMap<String, Policy> policyMap = new HashMap<>();
    private LinkedHashMap<String, Policy> orderedPolicies = new LinkedHashMap<>();
    private TreeMap<LocalDate, List<Policy>> expiryMap = new TreeMap<>();

    public void addPolicy(Policy policy) {
        String policyNumber = policy.getPolicyNumber();
        LocalDate expiry = policy.getExpiryDate();

        policyMap.put(policyNumber, policy);
        orderedPolicies.put(policyNumber, policy);

        expiryMap.putIfAbsent(expiry, new ArrayList<>());
        expiryMap.get(expiry).add(policy);
    }

    public Policy getPolicyByNumber(String policyNumber) {
        return policyMap.get(policyNumber);
    }

    public List<Policy> getPoliciesExpiringInNext30Days() {
        List<Policy> expiringSoon = new ArrayList<>();
        LocalDate today = LocalDate.now();
        LocalDate end = today.plusDays(30);

        expiryMap.subMap(today, true, end, true).values().forEach(expiringSoon::addAll);
        return expiringSoon;
    }

    public List<Policy> getPoliciesByHolder(String holderName) {
        List<Policy> result = new ArrayList<>();
        for (Policy policy : policyMap.values()) {
            if (policy.getPolicyHolderName().equalsIgnoreCase(holderName)) {
                result.add(policy);
            }
        }
        return result;
    }

    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();
        NavigableMap<LocalDate, List<Policy>> expired = expiryMap.headMap(today, false);
        for (List<Policy> policyList : expired.values()) {
            for (Policy policy : policyList) {
                String number = policy.getPolicyNumber();
                policyMap.remove(number);
                orderedPolicies.remove(number);
            }
        }
        expired.clear();
    }

    public void printAllPoliciesInOrder() {
        System.out.println("All Policies (Insertion Order):");
        for (Policy policy : orderedPolicies.values()) {
            System.out.println(policy);
        }
    }
}
