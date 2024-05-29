import java.util.Scanner;

class Account{
    public static void displayAccount(){
        Scanner scanner= new Scanner(System.in);
        String password;
        while(!password.equals(Login.getStoredPassword())) {
            System.out.println("Enter your password to display information.");
            password = scanner.nextLine();
            if (!password.equals(Login.getStoredPassword())) {
                char c;
                System.out.println("Press Y to retry and N to go Back");
                c=scanner.nextLine().charAt(0);
                if(c == 'n' || c =='N'){
                    Menu.displayMenu();
                }
            }
        }
            if (password.equals(Login.getStoredPassword())) {
                System.out.println("Displaying Information.");
                System.out.println("Name : " + Login.getStoredUsername());
                System.out.println("Account Number : " + Login.getAccountNumber());
                System.out.println("Password : " + Login.getStoredPassword());
                System.out.println("Recovery Key : " + Login.getRecoverykey());
                System.out.println("Transaction Pin : " + Login.getPin());
            }
    }
}
