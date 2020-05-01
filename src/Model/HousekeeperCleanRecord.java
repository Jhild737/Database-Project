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
public class HousekeeperCleanRecord {
    private int housekeeperId;
    private int roomNo;

    public HousekeeperCleanRecord(int housekeeperId, int roomNo, Date dateCleaned) {
        this.housekeeperId = housekeeperId;
        this.roomNo = roomNo;
        this.dateCleaned = dateCleaned;
    }

    @Override
    public String toString() {
        return "HousekeeperCleanRecord{" + "housekeeperId=" + housekeeperId + ", roomNo=" + roomNo + ", dateCleaned=" + dateCleaned + '}';
    }
    private Date dateCleaned;

    public int getHousekeeperId() {
        return housekeeperId;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public Date getDateCleaned() {
        return dateCleaned;
    }
}
