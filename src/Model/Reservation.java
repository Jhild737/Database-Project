/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author tojol
 */
public class Reservation {
    private int reservationNumber;
    private Date checkInDate;
    private int noDaysStaying;
    private int guestNo;
    private int fDeskAgentNo;
    private int roomNo;

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public void setNoDaysStaying(int noDaysStaying) {
        this.noDaysStaying = noDaysStaying;
    }

    public int getReservationNumber() {
        return reservationNumber;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public int getNoDaysStaying() {
        return noDaysStaying;
    }

    public int getGuestNo() {
        return guestNo;
    }

    public int getfDeskAgentNo() {
        return fDeskAgentNo;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public Reservation(int reservationNumber, Date checkInDate, int noDaysStaying, int guestNo, int fDeskAgentNo, int roomNo) {
        this.reservationNumber = reservationNumber;
        this.checkInDate = checkInDate;
        this.noDaysStaying = noDaysStaying;
        this.guestNo = guestNo;
        this.fDeskAgentNo = fDeskAgentNo;
        this.roomNo = roomNo;
    }
}
