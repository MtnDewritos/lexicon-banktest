import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Bank {

    private HashMap<Integer,User> usersMap = new HashMap<>();
    private HashMap<Integer, HashMap<Integer, Account>> accountsMap = new HashMap<>();
    private User loggedInUser;

    public boolean login(){
        Scanner scan = new Scanner(System.in);

        int attempts = 0;
        while(attempts < 3){
            System.out.println("Enter SSN: ");
            int ssn = Integer.parseInt(scan.nextLine());


            System.out.println("Enter password: ");
            int password = Integer.parseInt(scan.nextLine());

            System.out.println("login");
            if(usersMap.containsKey(ssn)){
                if(usersMap.get(ssn).getPassword() == password){
                    loggedInUser = usersMap.get(ssn);
                    accountMenu();
                    return true;
                }
                else{
                    attempts++;
                    System.out.println("Incorrect PIN");
                }
            }
            else{
                attempts++;
                System.out.println("User does not exist");
            }
        }
        return false;

    }

    public void createAccount(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter SSN: ");
        int ssn = Integer.parseInt(scan.nextLine());

        System.out.println("Enter password: ");
        int password = Integer.parseInt(scan.nextLine());

        usersMap.put(ssn, new User(ssn, password));



        System.out.println("created account");
        int accountNr1 = 123;
        int accountNr2 = 456;
        accountsMap.put(ssn, new HashMap<Integer,Account>(
                Map.ofEntries(
                        Map.entry(accountNr1, new Account(accountNr1, 1000)),
                        Map.entry(accountNr2, new Account(accountNr2, 2000))
                )
            )
        );
    }

    public void accountMenu(){
        Scanner scan = new Scanner(System.in);

        boolean active = true;
        while(active){
            System.out.println("Account management");
            System.out.println("1. Show accounts");
            System.out.println("2. Make a transfer");
            System.out.println("3. Exit");
            String selection = scan.nextLine();
            switch (selection) {
                case "1":
                    listAccounts();
                    break;
                case "2":
                    transfer();
                    break;
                case "3":
                    active = false;
                    break;
            }
        }
    }

    public void transfer(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter account number to transfer from: ");
        int accountNrFrom = Integer.parseInt(scan.nextLine());


        System.out.println("Enter account number to transfer to: ");
        int accountNrTo = Integer.parseInt(scan.nextLine());

        System.out.println("Enter amount to transfer: ");
        int amount = Integer.parseInt(scan.nextLine());

        Account fromAccount = accountsMap.get(loggedInUser.getSSN()).get(accountNrFrom);
        Account toAccount = accountsMap.get(loggedInUser.getSSN()).get(accountNrTo);

        fromAccount.setBalance(fromAccount.getBalance()-amount);
        toAccount.setBalance(toAccount.getBalance()+amount);

    }

    public void listAccounts(){
        HashMap<Integer, Account> accounts = accountsMap.get(loggedInUser.getSSN());
        for(Account a : accounts.values()){
            System.out.println("Account number: " + a.getAccountNr());
            System.out.println("Balance: " + a.getBalance());
        }
    }

}
