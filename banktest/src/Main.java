import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {
        Bank b = new Bank();
        boolean active = true;
        while (active) {
            System.out.println("Bank Application");
            System.out.println("1. Create account");
            System.out.println("2. Log in");
            System.out.println("3. Exit");

            String selection = sc.nextLine();
            switch (selection) {
                case "1":
                    b.createAccount();
                    break;
                case "2":
                    b.login();
                    break;
                case "3":
                    active = false;
                    break;
            }
        }
    }



}