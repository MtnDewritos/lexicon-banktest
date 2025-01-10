package BankTest;

public class Account {

    private final int accountNr;
    private int balance;
    private AccountType accountType;

    public Account(int accountNr, int balance, AccountType accountType){
        this.accountNr = accountNr;
        this.balance = balance;
        this.accountType = accountType;
    }

    public enum AccountType{
        INCOME,
        SAVINGS;
    }

    public int getAccountNr() {
        return accountNr;
    }

    public int getBalance() {
        return balance;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
