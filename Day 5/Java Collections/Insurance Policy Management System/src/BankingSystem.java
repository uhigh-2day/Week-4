import java.util.*;

public class BankingSystem {
    private HashMap<String, Double> accounts = new HashMap<>();
    private TreeMap<Double, List<String>> balanceSorted = new TreeMap<>();
    private Queue<WithdrawalRequest> withdrawalQueue = new LinkedList<>();

    public void addAccount(String accountNumber, double initialBalance) {
        accounts.put(accountNumber, initialBalance);
        balanceSorted.putIfAbsent(initialBalance, new ArrayList<>());
        balanceSorted.get(initialBalance).add(accountNumber);
    }

    public void queueWithdrawal(String accountNumber, double amount) {
        withdrawalQueue.add(new WithdrawalRequest(accountNumber, amount));
    }

    public void processWithdrawals() {
        while (!withdrawalQueue.isEmpty()) {
            WithdrawalRequest req = withdrawalQueue.poll();
            if (accounts.containsKey(req.accountNumber)) {
                double currentBalance = accounts.get(req.accountNumber);
                if (currentBalance >= req.amount) {
                    updateBalance(req.accountNumber, currentBalance - req.amount);
                } else {
                    System.out.println("Insufficient funds for account " + req.accountNumber);
                }
            } else {
                System.out.println("Account not found: " + req.accountNumber);
            }
        }
    }

    private void updateBalance(String accountNumber, double newBalance) {
        double oldBalance = accounts.get(accountNumber);
        accounts.put(accountNumber, newBalance);
        balanceSorted.get(oldBalance).remove(accountNumber);
        if (balanceSorted.get(oldBalance).isEmpty()) {
            balanceSorted.remove(oldBalance);
        }
        balanceSorted.putIfAbsent(newBalance, new ArrayList<>());
        balanceSorted.get(newBalance).add(accountNumber);
    }

    public void displayAccountsByBalance() {
        for (Map.Entry<Double, List<String>> entry : balanceSorted.entrySet()) {
            for (String account : entry.getValue()) {
                System.out.println("Account: " + account + ", Balance: " + entry.getKey());
            }
        }
    }
}

class WithdrawalRequest {
    String accountNumber;
    double amount;

    public WithdrawalRequest(String accountNumber, double amount) {
        this.accountNumber = accountNumber;
        this.amount = amount;
    }
}

class BankingSystemMain {
    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();

        bank.addAccount("ACC1001", 5000);
        bank.addAccount("ACC1002", 3000);
        bank.addAccount("ACC1003", 7000);

        bank.queueWithdrawal("ACC1001", 1000);
        bank.queueWithdrawal("ACC1002", 3500);
        bank.queueWithdrawal("ACC1003", 2000);

        bank.processWithdrawals();

        System.out.println("Accounts sorted by balance:");
        bank.displayAccountsByBalance();
    }
}

