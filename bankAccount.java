package dev;

public class bankAccount {
    String customer_name;
    String account_type;
    int balance;

    public bankAccount(String customer_name,String account_type, int balance){
        super();
        this.customer_name = customer_name;
        this.account_type = account_type;
        this.balance = balance;

    }

    public bankAccount() {
    super();
    }
}
