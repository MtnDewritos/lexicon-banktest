package BankTest;

public class User {

    private final int ssn;
    private int password;


    public User(int ssn, int password){
        this.ssn = ssn;
        this.password = password;

    }

    public int getSSN() {
        return ssn;
    }

    public int getPassword() {
        return password;
    }
}
