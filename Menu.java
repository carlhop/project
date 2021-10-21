package dev;
//Created by Carl Reginald Hopkins
import java.util.Scanner;

public class Menu
{
    protected boolean isFinishedBanking;
    protected boolean areCustomerDetailsCorrect;
    private String choices;

    private Scanner scanner = new Scanner(System.in);
    private SavingsAccount savingsAccount = new SavingsAccount();
    private CheckingAccount checkingAccount = new CheckingAccount();
    int previousTransaction;

    public void prompt()
    {
        isFinishedBanking = false;
        System.out.print("= ");
        choices = scanner.nextLine();
    }

    public void processPrompt()
    {
        if (choices.toLowerCase().equals("exit"))
        {
            System.out.println("\nThanks for banking with Hopkins International. Have a great day.");
            isFinishedBanking = true;
        }

        else if (choices.toLowerCase().equals("home"))
        {
            System.out.println();
            greetUser();
        }

        else if (choices.toLowerCase().equals("sub menu"))
        {
            showChoices();
        }

        else if (choices.toLowerCase().equals("savings"))
        {
            if(savingsAccount.isUserCustomer)
            {
                System.out.println("You already have an account open with us.");
            }


            else
            {
                do
                {
                    openSavingsAccountPrompt();
                    System.out.println("\nAre these details correct? Yes/no");
                    printCustomerSavingsDetails();
                    prompt();

                    if (choices.toLowerCase().equals("no"))
                    {
                        areCustomerDetailsCorrect = false;
                    }

                    else
                    {
                        areCustomerDetailsCorrect = true;
                        savingsAccount.openSavingsAccount();
                        System.out.println("\nYour Savings Account has successfully been open.");
                    }
                } while(!areCustomerDetailsCorrect);
            }
        }
        else if (choices.toLowerCase().equals("checking")) {
            if (checkingAccount.isUserCustomer) {
                System.out.println("You already have an account open with us.");
            } else
            {
                do {
                    openCheckingAccountPrompt();
                    System.out.println("\nAre these details correct? Yes/no");
                    printCustomerCheckingDetails();
                    prompt();

                    if (choices.toLowerCase().equals("no")) {
                        areCustomerDetailsCorrect = false;
                    } else {
                        areCustomerDetailsCorrect = true;
                        checkingAccount.openCheckingAccount();
                        System.out.println("\nYour Checking Account has successfully been open.");
                    }
                } while (!areCustomerDetailsCorrect);
            }
        }

        else if (choices.toLowerCase().equals("deposit savings"))
        {
            if (!savingsAccount.isUserCustomer)
            {
                System.out.println("\nYou must open an account first in order to deposit at \" HIB\".\n");
            }

            else
            {
                System.out.println("\nEnter amount you with to deposit.");
                prompt();
                savingsAccount.depositFunds(choices);
                System.out.println("\nTransaction complete. your new balance is: $" + savingsAccount.getAccountBalance());
            }
        }
        else if (choices.toLowerCase().equals("deposit checking"))
        {
            if (!checkingAccount.isUserCustomer)
            {
                System.out.println("\nYou must open an account first in order to deposit at \" HIB\".\n");
            }

            else
            {
                System.out.println("\nEnter amount you with to deposit.");
                prompt();
                checkingAccount.depositFunds(choices);
                System.out.println("\nTransaction complete. your new balance is: $" + checkingAccount.getCheckAccountBalance());
            }
        }


        else if (choices.toLowerCase().equals("check savings"))
        {
            if (!savingsAccount.isUserCustomer)
            {
                System.out.println("\nYou must open an account in order to use this option at \" HIB\".\n");
            }
            System.out.println();
            System.out.println("Your Savings Account balance is: $" + savingsAccount.getAccountBalance());
        }
        else if (choices.toLowerCase().equals("check checking"))
        {
            if (!checkingAccount.isUserCustomer)
            {
                System.out.println("\nYou must open an account in order to use this option at \" HIB\".\n");
            }
            System.out.println();
            System.out.println("Your checking Account balance is: $" + checkingAccount.getCheckAccountBalance());
        }

        else if (choices.toLowerCase().equals("withdraw savings"))
        {
            if (!savingsAccount.isUserCustomer)
            {
                System.out.println("\nYou must open an Savings Account first in order to withdraw at \" HIB\".\n");
            }

            else
            {
                System.out.println("\nEnter amount you with to withdraw savings.");
                prompt();

                if (savingsAccount.checkAccountForAvailableFunds(choices))
                {
                    System.out.println("\nInsufficient Funds Your available balance is: $" + savingsAccount.getAccountBalance());
                }
                else
                {
                    savingsAccount.withdrawFunds(choices);
                    System.out.println("\nTransaction complete.  your new balance is: $" + savingsAccount.getAccountBalance());
                }
            }
        }
        else if (choices.toLowerCase().equals("withdraw checking"))
        {
            if (!checkingAccount.isUserCustomer)
            {
                System.out.println("\nYou must open an Savings Account first in order to withdraw at \" HIB\".\n");
            }

            else
            {
                System.out.println("\nEnter amount you with to withdraw.");
                prompt();

                if (checkingAccount.checkAccountForAvailableFunds(choices))
                {
                    System.out.println("\nInsufficient Funds Your available balance is: $" + checkingAccount.getCheckAccountBalance());
                }
                else
                {
                    checkingAccount.withdrawFunds(choices);
                    System.out.println("\nTransaction complete.  your new balance is: $" + checkingAccount.getCheckAccountBalance());
                }
            }
        }

        else
        {
            System.out.println("Invalid response");
        }
    }

    public void openSavingsAccountPrompt()
    {
        System.out.println("Enter your first name.");
        prompt();
        savingsAccount.setCustomerFirstName(choices);
        System.out.println("Enter your last name.");
        prompt();
        savingsAccount.setCustomerLastName(choices);
        System.out.println("Enter your address.");
        prompt();
        savingsAccount.setCustomerAddress(choices);
        System.out.println("Enter your city, state.");
        prompt();
        savingsAccount.setCustomerAddress(choices);
        System.out.println("Enter your phone number.");
        prompt();
        savingsAccount.setCustomerPhoneNumber(choices);
        System.out.println("Enter your email address.");
        prompt();
        savingsAccount.setCustomerEmailAddress(choices);

        System.out.println("Enter amount to deposit into your new account.");
        prompt();
        // If left blank defaults to zero.
        if (choices.equals(""))
        {
            choices = "0";
        }
        savingsAccount.setAccountBalance(choices);
    }

    public void openCheckingAccountPrompt()
    {
        System.out.println("Enter your first name.");
        prompt();
        checkingAccount.setCustomerFirstName(choices);
        System.out.println("Enter your last name.");
        prompt();
        checkingAccount.setCustomerLastName(choices);
        System.out.println("Enter your address.");
        prompt();
        checkingAccount.setCustomerAddress(choices);
        System.out.println("Enter your city, state.");
        prompt();
        checkingAccount.setCustomerAddress(choices);
        System.out.println("Enter your phone number.");
        prompt();
        checkingAccount.setCustomerPhoneNumber(choices);
        System.out.println("Enter your email address.");
        prompt();
        checkingAccount.setCustomerEmailAddress(choices);

        System.out.println("Enter amount to deposit into your new account.");
        prompt();
        // If left blank defaults to zero.
        if (choices.equals(""))
        {
            choices = "0";
        }
        checkingAccount.setCheckAccountBalance(choices);
    }



    public void printCustomerSavingsDetails()
    {
        System.out.printf("Name: %s %s\nAddress: %s\nTelephone number: %s\nEmail address: %s\nBeginning balance : $%s\n\n",
                savingsAccount.getCustomerFirstName(), savingsAccount.getCustomerLastName(),
                savingsAccount.getCustomerAddress(),
                savingsAccount.getCustomerPhoneNumber(),
                savingsAccount.getCustomerEmailAddress(),
                savingsAccount.getAccountBalance());


    }
    public void printCustomerCheckingDetails()
    {
        System.out.printf("Name: %s %s\nAddress: %s\nTelephone number: %s\nEmail address: %s\nBeginning balance : $%s\n\n",
                checkingAccount.getCustomerFirstName(), checkingAccount.getCustomerLastName(),
                checkingAccount.getCustomerAddress(),
                checkingAccount.getCustomerPhoneNumber(),
                checkingAccount.getCustomerEmailAddress(),
                checkingAccount.getCheckAccountBalance());

    }

    public void greetUser()
    {
        System.out.println("Welcome to Hopkins International Bank. ");
        System.out.println("1. Type \"sub menu\" for a list of choices");
        System.out.println("2. Type \"home\" to get back to main menu");
        System.out.println("3. Type \"exit\" to exit.");
    }


    public void showChoices()
    {
        System.out.println("Here are your choices:");
        System.out.println("1. Type \"savings\" to open an Savings Account");
        System.out.println("2. Type \"checking\" to open an Checking Account");
        System.out.println("3. Type \"deposit savings\" to deposit funds into savings");
        System.out.println("4. Type \"deposit checking\" to deposit funds into checking");
        System.out.println("5. Type \"check savings\" to check savings balance");
        System.out.println("6. Type \"check checking\" to check checking balance");
        System.out.println("7. Type \"withdraw savings\" to make a withdraw into savings");
        System.out.println("8. Type \"withdraw checking\" to make a withdraw into checking");
    }



    }

