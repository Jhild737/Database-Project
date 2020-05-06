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
public class Housekeeper extends Staff {
    private double wage;
    private int managerId;

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public int getManagerId() {
        return managerId;
    }

    @Override
    public String toString() {
        return super.toString() + " " + "Housekeeper{" + "wage=" + wage + ", managerId=" + managerId + '}';
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }
    public Housekeeper(int phoneNumber, String fName, String mInit, String lName, String sex, double wage, int managerId) {
        super(phoneNumber, fName, mInit, lName, sex);
        this.wage = wage;
        this.managerId = managerId;
    }

    public Housekeeper(int staffId, int phoneNumber, String fName, String mInit, String lName, String sex, double wage, int managerId) {
        super(staffId, phoneNumber, fName, mInit, lName, sex);
        this.wage = wage;
        this.managerId = managerId;
    }
    
}
