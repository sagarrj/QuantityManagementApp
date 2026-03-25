package bank;

/*
We are developing a banking transaction monitoring system that tracks accounts, transactions, and detects patterns.

The program includes three classes: `Account`, `Transaction`, and `TransactionMonitor`.

Classes:
* The `Account` class represents a bank account.
* The `Transaction` class holds information about a single transaction.
* The `TransactionMonitor` class manages all transactions and provides fraud detection methods.

To begin with, we present you with two tasks:
1-1) Read through and understand the code below. Please take as much time as necessary, and feel free to run the code.
1-2) The test for TransactionMonitor is not passing due to a bug in the code. Make the necessary changes to TransactionMonitor to fix the bug.
*/

/*
2) We want to add a new function called "detectLargeWithdrawalPattern" to the TransactionMonitor class.
This function detects if an account has made multiple large withdrawals within a short time period,
which could indicate suspicious activity.

The function should return true if:
- There are 3 or more withdrawals of $5000 or more
- All occurring within the same calendar month

Otherwise, return false.

For example:
Transactions for account A001:
- 2024-02-05: Withdrawal $6000
- 2024-02-10: Withdrawal $5500
- 2024-02-15: Withdrawal $7000
→ Returns true (3 large withdrawals in February)

Transactions for account A002:
- 2024-02-05: Withdrawal $6000
- 2024-03-10: Withdrawal $5500
→ Returns false (only 2 withdrawals, and in different months)

To assist you in testing this new function, we have provided the testDetectLargeWithdrawalPattern function.
*/

import java.io.*;
import java.util.*;
import org.junit.*;

class Account {
    /** Data about a bank account. */
    String accountNumber;
    String accountHolder;
    String accountType;     // "Checking", "Savings", "Credit"
    
    Account(String accountNumber, String accountHolder, String accountType) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.accountType = accountType;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Account account = (Account) other;
        return accountNumber.equals(account.accountNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber);
    }
}

class Transaction {
    /** Data about a bank transaction. */
    Account account;
    String type;            // "Deposit", "Withdrawal", "Transfer"
    double amount;
    String date;            // Format: "YYYY-MM-DD"
    String time;            // Format: "HH:MM"
    
    Transaction(Account account, String type, double amount, String date, String time) {
        this.account = account;
        this.type = type;
        this.amount = amount;
        this.date = date;
        this.time = time;
    }
}

class TransactionMonitor {
    /**
     * Manages transactions and provides fraud detection capabilities.
     */
    ArrayList<Transaction> transactions = new ArrayList<>();

    TransactionMonitor() {
    }

    void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    int getTotalTransactions() {
        return transactions.size();
    }

    double getTotalDeposits() {
        return transactions.stream()
            .filter(t -> t.type.equals("Deposit"))
            .mapToDouble(t -> t.amount)
            .sum();
    }

    double getTotalWithdrawals() {
        return transactions.stream()
            .filter(t -> t.type.equals("Withdrawal"))
            .mapToDouble(t -> t.amount)
            .sum();
    }

    double getAverageTransactionAmount() {
        /** 
         * Returns the average transaction amount.
         * BUG: This method has a bug - fix it!
         */
        double total = transactions.stream().mapToDouble(t -> t.amount).sum();
        return total / getTotalTransactions();
    }

    int getTransactionCountForAccount(String accountNumber) {
        /** Returns the count of transactions for a specific account. */
        return (int) transactions.stream()
            .filter(t -> t.account.accountNumber.equals(accountNumber))
            .count();
    }

    public boolean detectLargeWithdrawalPattern(String accountNumber) {
        // Write your code here to solve this problem
        return false;
    }
}

public class Solution {
    public static void main(String[] args) {
        testTransaction();
        testTransactionMonitor();
        testDetectLargeWithdrawalPattern();
    }

    public static void testTransaction() {
        System.out.println("Running testTransaction");
        Account account = new Account("A001", "John Doe", "Checking");
        Transaction transaction = new Transaction(account, "Deposit", 1000.0, "2024-02-01", "10:30");

        Assert.assertEquals(account, transaction.account);
        Assert.assertEquals("Deposit", transaction.type);
        Assert.assertEquals(1000.0, transaction.amount, 0.01);
    }

    public static void testTransactionMonitor() {
        System.out.println("Running testTransactionMonitor");
        TransactionMonitor monitor = new TransactionMonitor();

        Assert.assertEquals(0, monitor.getTotalTransactions());
        Assert.assertEquals(0.0, monitor.getTotalDeposits(), 0.01);

        Account acc1 = new Account("A001", "Alice", "Checking");
        Account acc2 = new Account("A002", "Bob", "Savings");

        Transaction t1 = new Transaction(acc1, "Deposit", 1000.0, "2024-02-01", "10:00");
        Transaction t2 = new Transaction(acc1, "Withdrawal", 500.0, "2024-02-02", "11:00");
        Transaction t3 = new Transaction(acc2, "Deposit", 2000.0, "2024-02-03", "12:00");

        monitor.addTransaction(t1);
        monitor.addTransaction(t2);
        monitor.addTransaction(t3);

        Assert.assertEquals(3, monitor.getTotalTransactions());
        Assert.assertEquals(3000.0, monitor.getTotalDeposits(), 0.01);
        Assert.assertEquals(500.0, monitor.getTotalWithdrawals(), 0.01);
        Assert.assertEquals(1166.67, monitor.getAverageTransactionAmount(), 0.01);
        Assert.assertEquals(2, monitor.getTransactionCountForAccount("A001"));
    }

    public static void testDetectLargeWithdrawalPattern() {
        System.out.println("Running testDetectLargeWithdrawalPattern");
        TransactionMonitor monitor = new TransactionMonitor();

        Account acc1 = new Account("A001", "Alice", "Checking");
        Account acc2 = new Account("A002", "Bob", "Savings");

        // Account A001: 3 large withdrawals in same month
        Transaction t1 = new Transaction(acc1, "Withdrawal", 6000.0, "2024-02-05", "10:00");
        Transaction t2 = new Transaction(acc1, "Withdrawal", 5500.0, "2024-02-10", "11:00");
        Transaction t3 = new Transaction(acc1, "Withdrawal", 7000.0, "2024-02-15", "12:00");

        // Account A002: 2 large withdrawals in different months
        Transaction t4 = new Transaction(acc2, "Withdrawal", 6000.0, "2024-02-05", "13:00");
        Transaction t5 = new Transaction(acc2, "Withdrawal", 5500.0, "2024-03-10", "14:00");

        monitor.addTransaction(t1);
        monitor.addTransaction(t2);
        monitor.addTransaction(t3);
        monitor.addTransaction(t4);
        monitor.addTransaction(t5);

        Assert.assertTrue(monitor.detectLargeWithdrawalPattern("A001"));
        Assert.assertFalse(monitor.detectLargeWithdrawalPattern("A002"));
    }
}
