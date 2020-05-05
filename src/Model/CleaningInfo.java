/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author tojol
 */
public class CleaningInfo {
    private int housekeeperId;
    private int roomNo;
    private Date dateCleaned;

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        return "CleaningInfo{" + "housekeeperId=" + housekeeperId + ", roomNo=" + roomNo + ", dateCleaned=" + sdf.format(dateCleaned) + '}';
    }

    public int getHousekeeperId() {
        return housekeeperId;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public Date getDateCleaned() {
        return dateCleaned;
    }

    public CleaningInfo(int housekeeperId, int roomNo, Date dateCleaned) {
        this.housekeeperId = housekeeperId;
        this.roomNo = roomNo;
        this.dateCleaned = dateCleaned;
    }
    
}
