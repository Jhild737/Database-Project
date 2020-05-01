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
public class RoomType {
    private int roomTypeId;
    private double costDaily;

    public RoomType(int roomTypeId, double costDaily, String description) {
        this.roomTypeId = roomTypeId;
        this.costDaily = costDaily;
        this.description = description;
    }

    public int getRoomTypeId() {
        return roomTypeId;
    }

    public double getCostDaily() {
        return costDaily;
    }

    public String getDescription() {
        return description;
    }
    private String description;

    public void setDescription(String description) {
        this.description = description;
    }
}
