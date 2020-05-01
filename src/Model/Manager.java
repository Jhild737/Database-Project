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
    private int SSN;
    private int phoneNumber;
    private String fName;
    private String lName;

    @Override
    public String toString() {
        return "Manager{" + "staffId=" + staffId + ", SSN=" + SSN + ", phoneNumber=" + phoneNumber + ", fName=" + fName + ", lName=" + lName + ", mInit=" + mInit + ", sex=" + sex + ", address=" + address + ", salary=" + salary + '}';
    }
    private String mInit;
    private String sex;
    private String address;
    private int salary;

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getStaffId() {
        return staffId;
    }

    public int getSSN() {
        return SSN;
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

    public String getAddress() {
        return address;
    }

    public int getSalary() {
        return salary;
    }

    public Manager(int staffId, int SSN, int phoneNumber, String fName, String lName, String mInit, String sex, String address, int salary) {
        this.staffId = staffId;
        this.SSN = SSN;
        this.phoneNumber = phoneNumber;
        this.fName = fName;
        this.lName = lName;
        this.mInit = mInit;
        this.sex = sex;
        this.address = address;
        this.salary = salary;
    }
}
