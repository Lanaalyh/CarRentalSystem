package datastructureproject;

import java.util.Scanner;

public class Customer {

    private String FullName;
    private int ID;
    private String Phone_Number;
    private String Email;

    public Customer(String FullName, int ID, String Phone_Number, String Email) {
        this.FullName = FullName;
        this.ID = ID;
        this.Phone_Number = Phone_Number;
        this.Email = Email;
    }

   @Override
public String toString() {
    return 
           "\nFull Name: " + FullName + "\n" +
           "ID: " + ID + "\n" +
           "Phone Number: " + Phone_Number + "\n" +
           "Email: " + Email;
}


    public String getFullName() {
        return FullName;
    }

    public void setFullName(String FullName) {
        this.FullName = FullName;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getPhone_Number() {
        return Phone_Number;
    }

    public void setPhone_Number(String Phone_Number) {
        this.Phone_Number = Phone_Number;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

}