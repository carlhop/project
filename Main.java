package dev;

import dev.data.AccountData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Created by Carl Reginald Hopkins
public class Main {
    public static void main(String[] args) {
       /* AccountData data = new AccountData();
        data.getbankAccount();
        bankAccount mybankAccount = new bankAccount();
        mybankAccount.account_type = "savings";
        bankAccount mybankaccount2 = new bankAccount("Tom Brady", "Savings", 70);*/
        IdMenu idmenu = new IdMenu();
        idmenu.openIdentificationPrompt();
        System.out.println("");
        Menu menu = new Menu();
                menu.greetUser();
                do {
                    menu.prompt();
                    menu.processPrompt();
                }
                while (!menu.isFinishedBanking);
    }
        }






