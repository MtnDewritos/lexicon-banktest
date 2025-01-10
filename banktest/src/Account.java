public class Account {

    private final int accountNr;
    private int balance;

    public Account(int accountNr, int balance){
        this.accountNr = accountNr;
        this.balance = balance;
    }

    public int getAccountNr() {
        return accountNr;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
