package dev;
//Created by Carl Reginald Hopkins
public class Identification {
    private Identification CustomerIdentification;
    public boolean isRegisterIdentification = false;
    private String LogIn;
    private String Password;


    public Identification(String LogIn, String Password)
    {
    this.LogIn = LogIn;
    this.Password = Password;
    }

    public Identification() {

    }

    public String getLogIn()
    {
        return LogIn;
    }

    public void setLogIn(String LogIn)
    {
        this.LogIn = LogIn;
    }

    public String getPassword()
    {
        return Password;
    }

    public void setPassword(String Password)
    {
        this.Password = Password;
    }

    public void openIdentification() {
        CustomerIdentification = new Identification(LogIn, Password);
        isRegisterIdentification = true;


    }
}





