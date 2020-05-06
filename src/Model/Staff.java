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
public class Staff {
    private int staffId;
    private int phoneNumber;
    private String fName;
    private String mInit;
    private String lName;
    private String sex;

    public int getStaffId() {
        return staffId;
    }

    

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getmInit() {
        return mInit;
    }

    public void setmInit(String mInit) {
        this.mInit = mInit;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

   

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Staff{" + "staffId=" + staffId  + ", phoneNumber=" + phoneNumber + ", fName=" + fName + ", mInit=" + mInit + ", lName=" + lName + ", sex=" + sex + '}';
    }

    public Staff(int staffId, int phoneNumber, String fName, String mInit, String lName, String sex) {
        this.staffId = staffId;
        this.phoneNumber = phoneNumber;
        this.fName = fName;
        this.mInit = mInit;
        this.lName = lName;
        this.sex = sex;
    }
    public Staff(int phoneNumber, String fName, String mInit, String lName, String sex) {
        this.phoneNumber = phoneNumber;
        this.fName = fName;
        this.mInit = mInit;
        this.lName = lName;
        this.sex = sex;
    }
}
