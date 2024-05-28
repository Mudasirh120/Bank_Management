import com.sun.jdi.PathSearchingVirtualMachine;

import java.util.Scanner;
public class Login {
    private static String username;
    private static String password;
    private static String storedUsername;
    private static String storedPassword;
    private static String recoverykey;
    private static int pin;
    private static boolean loggedIn = false;
    private static int choice;
    public static void register(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("\t\t\t\t\t\t\t  Username: ");
        storedUsername = scanner.nextLine();
        System.out.print("\t\t\t\t\t\t\t  Password: ");
        storedPassword = scanner.nextLine();
        System.out.print("\t\t\t\t\t\t\t  Recoveey key : ");
        recoverykey= scanner.nextLine();
        System.out.print("\t\t\t\t\t\t\t  Tramsaction Pin: ");
        pin = scanner.nextInt();
        System.out.println("\n\n\t\t\t\t\t\t\t Successful Signup.");
        login();
    }
    public static void login(){
        Scanner scanner=new Scanner(System.in);
        while (loggedIn==false) {
            System.out.print("\n\n\t\t\t\t\t\t Username: ");
            username= scanner.nextLine();
            System.out.print("\n\n\t\t\t\t\t\t Password: ");
            password = scanner.nextLine();
            if (username.equals(storedUsername) && password.equals(storedPassword)) {
                loggedIn = true;
                System.out.println("Login successful!");
            }
            else if (username.equals(storedUsername) && !password.equals(storedPassword)) {
                System.out.println("\n\n\t\t\t\t\tIncorrect password.");
                System.out.println("\n\n\t\t\tPress Y to change password, R to Register, and N to Retry login.");
                char pchange = scanner.nextLine().charAt(0);
                if (pchange == 'R' || pchange == 'r') {
                    register();
                }
                else if (pchange == 'Y' || pchange == 'y') {
                    while (true) {
                        System.out.println("\n\n\t\t\t\t\t Enter login credentials.\n\n");
                        System.out.print("\n\n\t\t\t\t\tEnter your Username: ");
                        String newUsername= scanner.nextLine();
                        if (newUsername.equals(storedUsername)) {
                            System.out.println("Enter your Recovery key :");
                            String newRecovery = scanner.nextLine();
                            if (newRecovery.equals(recoverykey)) {
                                System.out.print("\n\n\t\t\t\t\tEnter new password: ");
                                storedPassword = scanner.nextLine();
                                break;
                            }else{
                                System.out.println("\n\n\t\t\tPress Y to retry, R to Register, and L to login.");
                                 pchange = scanner.nextLine().charAt(0);
                                if (pchange == 'R' || pchange == 'r') {
                                    register();
                                }
                                else if (pchange == 'L' || pchange == 'l') {
                                    login();
                                }
                            }
                        } else
                        {
                            System.out.println("\n\n\t\t\t\t\tNo match for user.");
                            System.out.println("\n\n\t\t\t\t\tPress Y to retry and N to Retry login.");
                            pchange = scanner.nextLine().charAt(0);
                            if (pchange == 'N' || pchange == 'n') {
                                break;
                            }
                        }
                    }
                }                    }
            else if (!username.equals(storedUsername) && password.equals(storedPassword))
            {                        System.out.println("\n\n\t\t\t\t\tIncorrect Username.");
            } else
            {                        System.out.println("\n\n\t\t\t\t\tUnregistered user.");
                System.out.println("\n\n\t\t\t\t\tTo retry press 1.");
                System.out.println("\n\n\t\t\t\t\tTo go back to Register press 2.");
                choice = scanner.nextInt();
                if (choice == 2) {
                    register();
                    loggedIn = false;
                    break;
                }
            }
        }
    }
    public static void loginPage() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\n\t\t\t\t\t\t\t   Welcome to IMF \n\n");
        System.out.println("\n\n\n\t\t\t\t\t\t\t\t1. Login");
        System.out.println("\t\t\t\t\t\t\t\t2. Register");
        System.out.println("\t\t\t\t\t\t\t      Choose an option.");
        choice = scanner.nextInt();
        switch (choice) {
            case 1:
             login()  ;
        break;
        case 2:
            register();


            break;
            default:
                System.out.println("\n\n\t\t\t\t\tInvalid choice. Please choose 1 or 2.");
                break;        }
        }
    }