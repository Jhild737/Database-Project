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
public class Manager {
    private int staffId;
    private int phoneNumber;
    private String fName;
    private String lName;

    @Override
    public String toString() {
        return "Manager{" + "staffId=" + staffId +  ", phoneNumber=" + phoneNumber + ", fName=" + fName + ", lName=" + lName + ", mInit=" + mInit + ", sex=" + sex +  ", salary=" + salary + '}';
    }
    private String mInit;
    private String sex;
    private int salary;

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getStaffId() {
        return staffId;
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

    public String getSex() {
        return sex;
    }

    

    public int getSalary() {
        return salary;
    }

    public Manager(int staffId, int phoneNumber, String fName, String mInit, String lName, String sex, int salary) {
        this.staffId = staffId;
        this.phoneNumber = phoneNumber;
        this.fName = fName;
        this.lName = lName;
        this.mInit = mInit;
        this.sex = sex;
        this.salary = salary;
    }

    public Manager(int phoneNumber, String fName, String mInit, String lName, String sex, int salary) {
        this.phoneNumber = phoneNumber;
        this.fName = fName;
        this.lName = lName;
        this.mInit = mInit;
        this.sex = sex;
        this.salary = salary;
    }
    
}
