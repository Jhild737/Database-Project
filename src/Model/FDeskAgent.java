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
public class FDeskAgent extends Staff{
    private double wage;

    public double getWage() {
        return wage;
    }

    @Override
    public String toString() {
        return super.toString() + " " + "FDeskAgent{" + "wage=" + wage + ", managerId=" + managerId + '}';
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }
    private int managerId;
    public FDeskAgent(int staffId, int SSN, int phoneNumber, String fName, String mInit, String lName, String address, String sex, double wage, int managerId) {
        super(staffId, SSN, phoneNumber, fName, mInit, lName, address, sex);
        this.wage = wage;
        this.managerId = managerId;
    }
    
}
