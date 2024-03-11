package ATM;

import java.util.Scanner;


class BankAccount {
 private double balance;

 public BankAccount(double balance) {
     this.balance = balance;
 }

 public double getBalance() {
     return balance;
 }

 public void deposit(double amount) {
     balance += amount;
 }

 public boolean withdraw(double amount) {
     if (amount <= balance) {
         balance -= amount;
         return true;
     } else {
         return false;
     }
 }
}

//ATM class to represent the ATM machine
public class ATM {
 private BankAccount account;

 public ATM(BankAccount account) {
     this.account = account;
 }

 public void displayMenu() {
     System.out.println("Welcome to the ATM.");
     System.out.println("1. Withdraw");
     System.out.println("2. Deposit");
     System.out.println("3. Check Balance");
     System.out.println("4. Exit");
 }

 public void withdraw(double amount) {
     if (account.withdraw(amount)) {
         System.out.println("Withdrawal successful. Remaining balance: " + account.getBalance());
     } else {
         System.out.println("Insufficient balance. Withdrawal failed.");
     }
 }

 public void deposit(double amount) {
     account.deposit(amount);
     System.out.println("Deposit successful. New balance: " + account.getBalance());
 }

 public void checkBalance() {
     System.out.println("Current balance: " + account.getBalance());
 }

 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);

     System.out.print("Enter initial balance: ");
     double initialBalance = scanner.nextDouble();
     BankAccount userAccount = new BankAccount(initialBalance);
     ATM atm = new ATM(userAccount);

     int choice;
     do {
         atm.displayMenu();
         System.out.print("Enter your choice: ");
         choice = scanner.nextInt();

         switch (choice) {
             case 1:
                 System.out.print("Enter amount to withdraw: ");
                 double withdrawAmount = scanner.nextDouble();
                 atm.withdraw(withdrawAmount);
                 break;
             case 2:
                 System.out.print("Enter amount to deposit: ");
                 double depositAmount = scanner.nextDouble();
                 atm.deposit(depositAmount);
                 break;
             case 3:
                 atm.checkBalance();
                 break;
             case 4:
                 System.out.println("Exiting...");
                 break;
             default:
                 System.out.println("Invalid choice. Please try again.");
         }
     } while (choice != 4);

     scanner.close();
 }
}

