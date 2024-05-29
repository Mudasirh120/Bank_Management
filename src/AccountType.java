import java.util.Scanner;

abstract class AccountType{
    String accountType;
    void AccountType(){
        int c;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose an account type : /n1. Saving Account /n2. Current Account ");
        c=scanner.nextInt();
        switch (c){
            case 1 :
                break;
            case 2 :
                break;
            default:
                System.out.println("Invalid Choice");
                break;
        }
    }
     abstract double transactionLimit();
     abstract double calculateInterest();
}