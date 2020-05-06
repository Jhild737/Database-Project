package UI;

import Model.Guest;
import java.awt.EventQueue;
import database.*;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;

import java.awt.Color;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.JTextArea;
import java.awt.ScrollPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Mains {

    private JFrame frmHotelDatabaseManager;
    private String[] tColumns = {"First Name", "Last Name", "Room Number"};
    private Object[][] data = {}; 
    private JTable table;
    private JTextField txtFirstName;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Mains window = new Mains();
                    window.frmHotelDatabaseManager.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Mains() {
        initialize();
    }

    public class Reservation {

        private JFrame frame;
        private JTextField textField;
        private Object[][] data = {{"42", "2", "125", "Double"}};
        private JTextField textField_1;
        private JLabel lblNewLabel_2;
        private JButton btnNewButton;
        private JTable table;
        private String[] tColumns = {"Room", "Type", "Cost Daily", "Description"};
        private JTextField txtRoomNum;
        private JLabel lblNewLabel_3;
        private JButton btnReserve;

        /**
         * Launch the application.
         */
        /**
         * Create the application.
         */
        public Reservation() {
            initialize();
        }

        public void createReservation() {
            //take data from text boxes and add to database
        }

        /**
         * Initialize the contents of the frame.
         */
        private void initialize() {
            frame = new JFrame();
            frame.setBounds(100, 100, 470, 268);
            frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            frame.getContentPane().setLayout(null);

            JLabel lblNewLabel = new JLabel("Date From");
            lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
            lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
            lblNewLabel.setBounds(10, 43, 96, 13);
            frame.getContentPane().add(lblNewLabel);

            JLabel lblNewLabel_1 = new JLabel("Date To");
            lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
            lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
            lblNewLabel_1.setBounds(10, 86, 96, 13);
            frame.getContentPane().add(lblNewLabel_1);

            textField = new JTextField();
            textField.setBounds(10, 57, 96, 19);
            frame.getContentPane().add(textField);
            textField.setColumns(10);

            textField_1 = new JTextField();
            textField_1.setBounds(12, 101, 96, 19);
            frame.getContentPane().add(textField_1);
            textField_1.setColumns(10);

            lblNewLabel_2 = new JLabel("Reservations");
            lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
            lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
            lblNewLabel_2.setBounds(116, 10, 183, 13);
            frame.getContentPane().add(lblNewLabel_2);

            btnNewButton = new JButton("Today");
            btnNewButton.setBounds(116, 56, 85, 21);
            frame.getContentPane().add(btnNewButton);
            btnNewButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    SimpleDateFormat s = new SimpleDateFormat("MM/dd/yyyy");
                    Date today = new Date();
                    textField.setText(s.format(today));
                }
            });

            JScrollPane scrollPane = new JScrollPane();
            scrollPane.setBounds(222, 33, 224, 188);
            frame.getContentPane().add(scrollPane);

            table = new JTable(data, tColumns);
            scrollPane.setViewportView(table);
            table.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
            table.setFillsViewportHeight(true);

            lblNewLabel_3 = new JLabel("Room Number");
            lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
            lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
            lblNewLabel_3.setBounds(10, 130, 96, 13);
            frame.getContentPane().add(lblNewLabel_3);

            btnReserve = new JButton("Reserve");
            btnReserve.setBounds(10, 174, 191, 33);
            frame.getContentPane().add(btnReserve);
            btnReserve.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    createReservation();
                    frame.setVisible(false);
                }
            });
        }
    }

    public void initEmployeeWindow() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Reservation window = new Reservation();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        //Get Today's reservations and guest info

        List<Model.Reservation> reservations = Database.getReservationsForToday();
        this.data = new String[reservations.size()][3];
        for(int i = 0; i < reservations.size(); i++){
            Guest guest = Database.getGuestInfoFromGuestNumber(reservations.get(i).getGuestNo());
            this.data[i][0] = guest.getfName();
            this.data[i][1] = guest.getlName();
            this.data[i][2] = Integer.toString(reservations.get(i).getRoomNo());
        }
        
        
        frmHotelDatabaseManager = new JFrame();
        frmHotelDatabaseManager.setBackground(Color.GRAY);
        frmHotelDatabaseManager.setTitle("Hotel Database Manager");
        frmHotelDatabaseManager.setBounds(100, 100, 628, 389);
        frmHotelDatabaseManager.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmHotelDatabaseManager.getContentPane().setLayout(null);

        JButton btnSchedule = new JButton("Schedules");
        btnSchedule.setBounds(479, 89, 128, 33);
        frmHotelDatabaseManager.getContentPane().add(btnSchedule);

        btnSchedule.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShowSchedule sch = new ShowSchedule();
                sch.setVisible(true);
            }
        
        });
        JButton btnEmployee = new JButton("Employee Zone");
        btnEmployee.setBounds(479, 46, 128, 33);
        frmHotelDatabaseManager.getContentPane().add(btnEmployee);
            
        btnEmployee.addActionListener((ActionEvent e) -> {
            EmployeeZone ez = new EmployeeZone();
            ez.setVisible(true);
        });
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 38, 213, 282);
        frmHotelDatabaseManager.getContentPane().add(scrollPane);

        table = new JTable(data, tColumns);
        scrollPane.setViewportView(table);
        table.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        table.setFillsViewportHeight(true);

        ButtonGroup btn = new ButtonGroup();

        JLabel lblTableLabel = new JLabel("Guests");
        lblTableLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblTableLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblTableLabel.setBounds(10, 10, 213, 18);
        frmHotelDatabaseManager.getContentPane().add(lblTableLabel);

        JPanel panel = new JPanel();
        panel.setBounds(245, 38, 262, 282);
        frmHotelDatabaseManager.getContentPane().add(panel);
        panel.setLayout(null);

        JLabel lblFName = new JLabel("First Name");
        lblFName.setHorizontalAlignment(SwingConstants.CENTER);
        lblFName.setBounds(10, 10, 197, 13);
        panel.add(lblFName);

        txtFirstName = new JTextField();
        txtFirstName.setBounds(10, 23, 197, 19);
        panel.add(txtFirstName);
        txtFirstName.setColumns(10);

        textField = new JTextField();
        textField.setColumns(10);
        textField.setBounds(10, 65, 197, 19);
        panel.add(textField);
        JLabel lblMInit = new JLabel("Middle Initial");
        lblMInit.setHorizontalAlignment(SwingConstants.CENTER);
        lblMInit.setBounds(10, 52, 197, 13);
        panel.add(lblMInit);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(10, 107, 197, 19);
        panel.add(textField_1);

        JLabel lblLName = new JLabel("Last Name");
        lblLName.setHorizontalAlignment(SwingConstants.CENTER);
        lblLName.setBounds(10, 94, 197, 13);
        panel.add(lblLName);

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(10, 149, 197, 19);
        panel.add(textField_2);

        JLabel lblPhoneNumber = new JLabel("Phone Number");
        lblPhoneNumber.setHorizontalAlignment(SwingConstants.CENTER);
        lblPhoneNumber.setBounds(10, 136, 197, 13);
        panel.add(lblPhoneNumber);

        JLabel lblSex = new JLabel("Gender");
        lblSex.setHorizontalAlignment(SwingConstants.CENTER);
        lblSex.setBounds(10, 178, 96, 13);
        panel.add(lblSex);

        JRadioButton rdbtnMale = new JRadioButton("Male");
        rdbtnMale.setBounds(10, 193, 70, 21);
        panel.add(rdbtnMale);

        JRadioButton rdbtnFemale = new JRadioButton("Female");
        rdbtnFemale.setBounds(10, 211, 70, 21);
        panel.add(rdbtnFemale);

        btn.add(rdbtnMale);
        btn.add(rdbtnFemale);

        JButton btnAddGuest = new JButton("Add Guest");
        btnAddGuest.setBounds(10, 251, 96, 21);
        panel.add(btnAddGuest);

        btnAddGuest.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if((!rdbtnMale.isSelected() && !rdbtnFemale.isSelected()) || 
                        lblLName.getText().equals("") || 
                        lblFName.getText().equals("") ||
                        lblPhoneNumber.getText().equals("")||
                        lblMInit.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter all fields");
                } else{
                    String sex;
                    if(rdbtnMale.isSelected()){
                        sex = "M";
                    } else{
                        sex = "F";
                    }
                    int phone = Integer.parseInt(textField_2.getText());
                    Guest g = new Guest(phone, txtFirstName.getText(), textField.getText(), textField_1.getText(), sex);
                    Database.createGuest(g);
                    JOptionPane.showMessageDialog(null, "Added Guest");
                    rdbtnMale.setSelected(false);
                    rdbtnFemale.setSelected(false);
                    txtFirstName.setText("");
                    textField.setText("");
                    textField_1.setText("");
                    textField_2.setText("");
                }
            }
        
        });
        
        JButton btnReserve = new JButton("Check In/Reserve");
        btnReserve.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateReservation res = new CreateReservation();
                res.setVisible(true);
                res.addWindowListener(new WindowAdapter(){
                    @Override
                    public void windowClosed(WindowEvent e) {
                        super.windowClosed(e);
                        List<Model.Reservation> reservations = Database.getReservationsForToday();
                        String test[][] = new String[reservations.size()][3];
                        for(int i = 0; i < reservations.size(); i++){
                            Guest guest = Database.getGuestInfoFromGuestNumber(reservations.get(i).getGuestNo());
                            test[i][0] = guest.getfName();
                            test[i][1] = guest.getlName();
                            test[i][2] = Integer.toString(reservations.get(i).getRoomNo());
                        }
                        String[] tColumns = {"First Name", "Last Name", "Room Number"};
                        DefaultTableModel model = new DefaultTableModel(test, tColumns);
                        table.setModel(model);
                    }
                    
                });
            }
        
        });
        /*btnReserve.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                initEmployeeWindow();
            }
        });*/
        btnReserve.setBounds(113, 251, 139, 21);
        panel.add(btnReserve);

        JLabel lblTableLabel_1 = new JLabel("Guest Information");
        lblTableLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblTableLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblTableLabel_1.setBounds(252, 10, 213, 18);
        frmHotelDatabaseManager.getContentPane().add(lblTableLabel_1);

    }
}
