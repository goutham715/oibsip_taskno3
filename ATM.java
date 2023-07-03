import java.util.*;

class ATM {
    public static void main(String args[]) {
        final Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the ATM! Where you can perform the following operations");
        System.out.println("Enter the userID");
        int userID = sc.nextInt();
        System.out.println("Enter the UserPIN");
        int userPIN = sc.nextInt();
        int balance = 10000;
        List<String> transactionHistory = new ArrayList<>();
        if (userID == 100 && userPIN == 1234) {
            System.out.println("You have Entered the correct UserID and UserPIN");
            boolean quit = false;
            while (!quit) {
                System.out.println("\nATM - Menu:");
                System.out.println("1. View Transaction History");
                System.out.println("2. Withdraw");
                System.out.println("3. Deposit");
                System.out.println("4. Transfer");
                System.out.println("5. Quit");
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        if (transactionHistory.isEmpty()) {
                            System.out.println("No transaction history");
                        } else {
                            for (String transaction : transactionHistory) {
                                System.out.println(transaction);
                            }
                        }
                        break;
                    case 2:
                        System.out.println("Enter the amount to withdraw: ");
                        int withdrawAmount = sc.nextInt();
                        if (withdrawAmount > balance) {
                            System.out.println("Insufficient balance");
                        } else {
                            balance -= withdrawAmount;
                            System.out.println("Withdrawal successful. Remaining balance: " + balance);
                            transactionHistory.add("Withdrawal amount: " + withdrawAmount);
                        }
                        break;
                    case 3:
                        System.out.println("Enter the amount to deposit: ");
                        int depositAmount = sc.nextInt();
                        balance += depositAmount;
                        System.out.println("Deposited successfully. New balance: " + balance);
                        transactionHistory.add("Deposit: " + depositAmount);
                        break;
                    case 4:
                        System.out.print("Enter the amount to transfer: ");
                        int transferAmount = sc.nextInt();
                        if (transferAmount > balance) {
                            System.out.println("Insufficient balance!");
                        } else {
                            System.out.print("Enter the payee account number: ");
                            int accountNum = sc.nextInt();

                            System.out.println("Transfer successful.");
                            balance -= transferAmount;
                            System.out.println("Remaining balance: " + balance);
                            transactionHistory.add("Transfer to " + accountNum + ": " + transferAmount);
                        }
                        break;
                    case 5:
                        quit = true;
                        System.out.println("Thank you for using the ATM");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            }
        } else {
            System.out.println("You have entered the wrong UserID and UserPIN");
        }
    }
}
