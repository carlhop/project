package dev;
//Created by Carl Reginald Hopkins
import java.util.Scanner;

public class IdMenu {
    protected boolean isRegisterIdentification;
    private String choices;

    private Scanner scanner = new Scanner(System.in);
    private Identification identification = new Identification();

    public void prompt() {
        isRegisterIdentification = false;
        System.out.print("= ");
        choices = scanner.nextLine();
    }
    public void openIdentificationPrompt() {
        System.out.println("\n\nEnter your Log in");
        prompt();
        identification.setLogIn(choices);

        System.out.println("\nEnter your Password");
        prompt();
        identification.setPassword(choices);

        System.out.println("Log in and password created!");
    }
}