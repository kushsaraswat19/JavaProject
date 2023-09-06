import java.util.*;
import java.time.LocalDateTime;

class Transaction{
    private int txId;
    private final LocalDateTime txTime = LocalDateTime.now();
    private long accNo;

    public Transaction(int txId, long accNo) {
        this.txId = txId;
        this.accNo = accNo;
    }

    public long getAccNo() {
        return accNo;
    }

    public void setAccNo(long accNo) {
        this.accNo = accNo;
    }

    public int getTxId() {
        return txId;
    }

    public void setTxId(int txId) {
        this.txId = txId;
    }

    public LocalDateTime getTxTime() {
        return txTime;
    }

    @Override
    public String toString() {
        return "txId=" + txId +
                ", txTime=" + txTime +
                ", accNo=" + accNo;
    }
}

class Account{

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", accountNumber=" + accountNumber +
                ", balance=" + balance;
    }

    private final String name;
    private final long accountNumber;
    private long balance;

    public Account(String name, long accountNumber) {
        this.name = name;
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }
}

public class BankApplication{
    static Vector<Account> accounts = new Vector<>();
    static  Vector<Transaction> transactions = new Vector<>();

    public static void main(String[] args){

        System.out.println("--> BANK APPLICATION <--");
        System.out.println("--> Main Menu <--");
        System.out.println("--> 1. Open Account. <--");
        System.out.println("--> 2. Deposit <--");
        System.out.println("--> 3. Withdraw <--");
        System.out.println("--> 4. View All Accounts <--");
        System.out.println("--> 5. View Account Details <--");
        System.out.println("--> 6. View Transaction History <--");
        System.out.println("--> 7. Search Account <--");
        System.out.println("--> 8. exit <--");

        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter a choice.");
        System.out.println("--> [1/2/3/4/5/6/7] <--");
        
        int ch = sc.nextInt();

       while(true){
           switch (ch) {
               case 1 -> {
                   System.out.println("Please Enter the details.");

                   System.out.println("Account Number");
                   long accNo = sc.nextLong();

                   System.out.println("Name");
                   String name = sc.next();
                   Account ac = new Account(name, accNo);
                   accounts.add(ac);
                   System.out.println("Account Opened Successfully.");
                   System.out.println("\n");
               }
               case 2 -> {
                   System.out.println("Please enter the amount number.");
                   long accNo = sc.nextLong();

                   System.out.println("Please enter the amount to be deposited.");
                   long depositAmt = sc.nextLong();

                   for(Account ac : accounts){
                       if(ac.getAccountNumber() == accNo){
                           transactions.add(new Transaction(Integer.parseInt(String.valueOf(accNo))+1, accNo));
                           ac.setBalance(ac.getBalance()+depositAmt);
                           System.out.println("Amount Deposited Successfully.");
                       }
                       else{
                           System.out.println("Please enter correct account number.");
                       }
                   }
                   System.out.println("\n");
               }
               case 3 -> {
                   System.out.println("Please enter the amount number.");
                   long accNo = sc.nextLong();

                   System.out.println("Please enter the amount to be withdrawn.");
                   long withdrawAmt = sc.nextLong();

                   for(Account ac : accounts){
                       if(ac.getAccountNumber() == accNo){
                           if(ac.getBalance() >= withdrawAmt){
                               ac.setBalance(ac.getBalance() - withdrawAmt);
                               transactions.add(new Transaction(Integer.parseInt(String.valueOf(accNo))+1, accNo));
                               System.out.println("Amount Withdrawn Successfully.");
                           }
                           else{
                               System.out.println("Insufficient Funds.");
                           }
                       }
                       else{
                           System.out.println("Please enter correct account number.");
                       }
                   }
                   System.out.println("\n");
               }
               case 4 -> {
                   System.out.println("Please enter the account number : ");
                   long accNo = sc.nextLong();
                   for(Account ac : accounts){
                       if(ac.getAccountNumber() == accNo){
                           System.out.println(ac);
                       }
                   }
                   System.out.println("\n");
               }
               case 5 -> {
                   System.out.println("Please enter the account number : ");
                   long accNo = sc.nextLong();
                   for (Transaction tx : transactions){
                       if(tx.getAccNo() == accNo){
                           System.out.println(tx);
                       }
                   }
                   System.out.println("\n");
               }
               case 6 -> {
                   System.out.println("Please enter the amount number.");
                   long accNo = sc.nextLong();
                   for(Account ac : accounts){
                       if(ac.getAccountNumber() == accNo){
                           System.out.println(ac);
                       }
                   }
                   System.out.println("\n");
               }
               case 7 -> {
                   System.out.println("--> Bye Bye! <--");
                   System.exit(0);
                   System.out.println("\n");
               }
               default -> System.out.println("--> Please enter a valid choice. <--");
           }
        System.out.println("Please Enter a choice.");
        System.out.println("--> [1/2/3/4/5/6/7] <--");
        ch = sc.nextInt();
       }
    }
}
    
}
