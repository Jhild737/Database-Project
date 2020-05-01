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
public class Room {
    private int roomNo;

    public void setRoomTypeId(int roomTypeId) {
        this.roomTypeId = roomTypeId;
    }
    private int roomTypeId;

    @Override
    public String toString() {
        return "Room{" + "roomNo=" + roomNo + ", roomTypeId=" + roomTypeId + '}';
    }

    public int getRoomNo() {
        return roomNo;
    }

    public int getRoomTypeId() {
        return roomTypeId;
    }

    public Room(int roomNo, int roomTypeId) {
        this.roomNo = roomNo;
        this.roomTypeId = roomTypeId;
    }
}
