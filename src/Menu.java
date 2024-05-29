import java.util.Scanner;

public class Menu {
    public static void displayMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome ");
        System.out.println("Choose what to do ");
        System.out.println("1. View Details");
        System.out.println("2. Reset Pin");
        System.out.println("3. Change Account Type");
        System.out.println("4. Upgrade Card");
        System.out.println("5. Deposit Cash");
        System.out.println("6. Withdraw Cash ");
        System.out.println("7. Check Balance ");
        System.out.println("8. Logout");
        System.out.println("Make a Choice :");
        int mychoice;
        mychoice=scanner.nextInt();
        switch (mychoice){
            case 1 :
               Account.displayAccount();
               break;
            case 2 :
              ResetPin.changePin();
              break;
            case 8 :
              Login.loginPage();
              break;
            default:
                System.out.println("Invalid Input");
                displayMenu();
                break;
        }
    }
}
