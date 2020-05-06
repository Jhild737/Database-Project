/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Model.Guest;
import Model.Reservation;
import Model.Room;
import Model.RoomType;
import database.Database;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author tojol
 */
public class CreateReservation extends javax.swing.JFrame {

    /**
     * Creates new form CreateReservation
     */
    public CreateReservation() {
        initComponents();
        availRooms.setVisible(false);
        roomsLabel.setVisible(false);
        bookRoom.setVisible(false);
        List<Guest> guestList = Database.getAllGuests();
        guests.removeAllItems();
        guestList.forEach((myGuest) -> {
            guests.addItem(myGuest.getGuestNo() + " - " + myGuest.getfName() + " " + myGuest.getmInit() + " " + myGuest.getlName());
        });
        Date today = Calendar.getInstance().getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        checkInDate.setText(sdf.format(today));
        seeRoomsBtn.addActionListener((ActionEvent e) -> {
            if(checkInDate.getText().equals("") || numDays.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Please fill out both fields");
            }
            
            try {
                Date checkIn = sdf.parse(checkInDate.getText());
                List<Room> rooms = Database.getOpenRoomsForDateRange(checkIn, Integer.parseInt(numDays.getText()));
                for(Room myRoom : rooms){
                    RoomType rt = Database.getRoomInformation(myRoom.getRoomNo());
                    String roomInfo = "Room Number: " + myRoom.getRoomNo()
                            + ", Description: " + rt.getDescription() + ", "
                            + "Daily Cost: " + rt.getCostDaily();
                    availRooms.removeAllItems();
                    availRooms.addItem(roomInfo);
                    roomsLabel.setVisible(true);
                    availRooms.setVisible(true);
                    bookRoom.setVisible(true);
                    checkInDate.setEditable(false);
                    numDays.setEditable(false);
                }
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Please enter date in proper format(MM/DD/YYYY)");
            }
        });
        bookRoom.addActionListener((ActionEvent e) -> {
            String guestNumString = guests.getSelectedItem().toString().split(" ")[0];
            System.out.println(guestNumString);
            int guestNo = Integer.parseInt(guestNumString);
            try {
                Date checkInDate = sdf.parse(this.checkInDate.getText());
                int days = Integer.parseInt(numDays.getText());
                int roomNo = Integer.parseInt(availRooms.getSelectedItem().toString().split(" ")[2]);
                
            } catch (ParseException ex) {
                
            }
            
            
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        guests = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        checkInDate = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        numDays = new javax.swing.JTextField();
        seeRoomsBtn = new javax.swing.JButton();
        availRooms = new javax.swing.JComboBox<>();
        roomsLabel = new javax.swing.JLabel();
        bookRoom = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Create a new reservation");

        jLabel2.setText("Select a guest: ");

        guests.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("Enter Check In Date(MM/DD/YYYY):");

        jLabel4.setText("Number of Days Staying: ");

        numDays.setText("0");

        seeRoomsBtn.setText("See available Rooms");

        availRooms.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        roomsLabel.setText("Available Rooms:");

        bookRoom.setText("Book Room");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(guests, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(seeRoomsBtn)
                    .addComponent(checkInDate, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numDays, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(availRooms, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(roomsLabel)
                    .addComponent(bookRoom))
                .addContainerGap(329, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(guests, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkInDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(numDays, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(seeRoomsBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roomsLabel)
                .addGap(3, 3, 3)
                .addComponent(availRooms, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bookRoom)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CreateReservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateReservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateReservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateReservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateReservation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> availRooms;
    private javax.swing.JButton bookRoom;
    private javax.swing.JTextField checkInDate;
    private javax.swing.JComboBox<String> guests;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField numDays;
    private javax.swing.JLabel roomsLabel;
    private javax.swing.JButton seeRoomsBtn;
    // End of variables declaration//GEN-END:variables
}