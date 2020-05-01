/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author tojol
 */
public class Guest {
   private int guestNo;
   private int phoneNumber;
   private String fName;
   private String lName;
   private String mInit;
   private String sex;

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getGuestNo() {
        return guestNo;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getmInit() {
        return mInit;
    }

    @Override
    public String toString() {
        return "Guest{" + "guestNo=" + guestNo + ", phoneNumber=" + phoneNumber + ", fName=" + fName + ", lName=" + lName + ", mInit=" + mInit + ", sex=" + sex + '}';
    }

    public String getSex() {
        return sex;
    }

    public Guest(int guestNo, int phoneNumber, String fName, String lName, String mInit, String sex) {
        this.guestNo = guestNo;
        this.phoneNumber = phoneNumber;
        this.fName = fName;
        this.lName = lName;
        this.mInit = mInit;
        this.sex = sex;
    }
}
