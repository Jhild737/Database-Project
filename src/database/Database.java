/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import Model.FDeskAgent;
import Model.Guest;
import Model.Housekeeper;
import Model.Manager;
import Model.Reservation;
import Model.Room;
import Model.RoomType;
import Model.Schedule;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author tojol
 */
public class Database {
    final static String ID = "thurle1";
    final static String PW = "Cosc*qwe9";
    final static String SERVER = "jdbc:mysql://triton.towson.edu:3360/?serverTimezone=EST#/thurle1db";
    public static boolean addFDeskAgent(FDeskAgent agent){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch(ClassNotFoundException e){
            System.out.println(e);
            return false;
        }
        try{
            Connection conn = DriverManager.getConnection(SERVER, ID, PW);
            Statement stmt = conn.createStatement();
            String staffInsert = "INSERT INTO thurle1db.Staff " + 
                                 "VALUES(" + agent.getSSN() + ", " + 
                                 agent.getPhoneNumber() + ", " + 
                                 agent.getStaffId() + ", '" + agent.getfName() + 
                                 "', '" + agent.getmInit() + "', '" +
                                 agent.getlName() + "', '" + agent.getAddress() + 
                                 "', '" + agent.getSex() + "');";
            stmt.executeUpdate(staffInsert);
        } catch (SQLException e){
            System.out.println(e);
            return false;
        } finally{
            try{
                Connection conn = DriverManager.getConnection(SERVER, ID, PW);
                Statement stmt = conn.createStatement();
                String agentInsert = "INSERT INTO thurle1db.FDeskAgent " +
                                     "Values(" + agent.getStaffId() + ", " + 
                                     agent.getWage() + ", " + agent.getManagerId() + 
                                     ");";
                stmt.executeUpdate(agentInsert);
                return true;
            } catch(SQLException e){
                System.out.println(e);
                return false;
            } 
        }
    }
    public static boolean addHousekeeper(Housekeeper keeper){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch(ClassNotFoundException e){
            System.out.println(e);
            return false;
        }
        try{
            Connection conn = DriverManager.getConnection(SERVER, ID, PW);
            Statement stmt = conn.createStatement();
            String staffInsert = "INSERT INTO thurle1db.Staff " + 
                                 "VALUES(" + keeper.getSSN() + ", " + 
                                 keeper.getPhoneNumber() + ", " + 
                                 keeper.getStaffId() + ", '" + keeper.getfName() + 
                                 "', '" + keeper.getmInit() + "', '" +
                                 keeper.getlName() + "', '" + keeper.getAddress() + 
                                 "', '" + keeper.getSex() + "');";
            stmt.executeUpdate(staffInsert);
        } catch (SQLException e){
            System.out.println(e);
            return false;
        } finally{
            try{
                Connection conn = DriverManager.getConnection(SERVER, ID, PW);
                Statement stmt = conn.createStatement();
                String keeperInsert = "INSERT INTO thurle1db.Housekeeper " +
                                     "Values(" + keeper.getStaffId() + ", " + 
                                     keeper.getWage() + ", " + keeper.getManagerId() + 
                                     ");";
                stmt.executeUpdate(keeperInsert);
                return true;
            } catch(SQLException e){
                System.out.println(e);
                return false;
            } 
        }
    }
    public static List<FDeskAgent> getAgentsFromDB(){
        List<FDeskAgent> agents = new LinkedList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch(ClassNotFoundException e){
            System.out.println(e);
            return agents;
        }
        try{
            Connection conn = DriverManager.getConnection(SERVER,ID,PW);
            Statement stmt = conn.createStatement();
            ResultSet resAgent = stmt.executeQuery("SELECT * "
                            + "FROM thurle1db.FDeskAgent as agent, thurle1db.Staff as staff "
                            + "WHERE agent.staffId = staff.staffId;");
            while (resAgent.next()){
                FDeskAgent myAgent = new FDeskAgent(resAgent.getInt("staffId"), 
                    resAgent.getInt("SSN"), resAgent.getInt("phoneNumber"), 
                    resAgent.getString("fName"), resAgent.getString("mInit"), 
                    resAgent.getString("lName"), resAgent.getString("address"), 
                    resAgent.getString("sex"), resAgent.getDouble("wage"), 
                    resAgent.getInt("managerId"));
                agents.add(myAgent);
            }
            
        } catch(SQLException e){
            System.out.println(e);
        }
        return agents;
    }
    public static List<Housekeeper> getHousekeepersFromDB(){
        List<Housekeeper> keepers = new LinkedList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch(ClassNotFoundException e){
            System.out.println(e);
            return keepers;
        }
        try{
            Connection conn = DriverManager.getConnection(SERVER,ID,PW);
            Statement stmt = conn.createStatement();
            ResultSet resAgent = stmt.executeQuery("SELECT * "
                            + "FROM thurle1db.Housekeeper as keeper, thurle1db.Staff as staff "
                            + "WHERE keeper.staffId = staff.staffId;");
            while (resAgent.next()){
                Housekeeper myKeeper = new Housekeeper(resAgent.getInt("staffId"), 
                    resAgent.getInt("SSN"), resAgent.getInt("phoneNumber"), 
                    resAgent.getString("fName"), resAgent.getString("mInit"), 
                    resAgent.getString("lName"), resAgent.getString("address"), 
                    resAgent.getString("sex"), resAgent.getDouble("wage"), 
                    resAgent.getInt("managerId"));
                keepers.add(myKeeper);
            }
            
        } catch(SQLException e){
            System.out.println(e);
        }
        return keepers;
    }
    public static boolean addManager(Manager manager){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch(ClassNotFoundException e){
            System.out.println(e);
            return false;
        }
        try{
            Connection conn = DriverManager.getConnection(SERVER, ID, PW);
            Statement stmt = conn.createStatement();
            String managerInsert = "INSERT INTO thurle1db.Manager " + 
                                 "VALUES(" + manager.getStaffId()  
                    + ", " + manager.getSSN() + ", " +  manager.getPhoneNumber()
                    + ", '" + manager.getfName() + "', '" + manager.getmInit() 
                    + "', '" + manager.getlName() + "', '" + manager.getSex()  
                    + "', '" + manager.getAddress() + "', " + manager.getSalary() + ");";
            System.out.println(managerInsert);
            stmt.executeUpdate(managerInsert);
            return true;
        } catch (SQLException e){
            System.out.println(e);
            return false;
        } 
    }
    
    public static FDeskAgent getAgentByID(int staffId){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch(ClassNotFoundException e){
            System.out.println(e);
            return null;
        }
        try{
            Connection conn = DriverManager.getConnection(SERVER, ID, PW);
            Statement stmt = conn.createStatement();
            String getAgentByID = "SELECT * "
                    + "FROM thurle1db.Staff as Staff, thurle1db.FDeskAgent as Agent "
                    + "WHERE Staff.staffId = Agent.staffId "
                    + "AND Staff.staffId = " + staffId + ";";
            ResultSet rs = stmt.executeQuery(getAgentByID);
            rs.next();
            FDeskAgent myAgent = new FDeskAgent(rs.getInt("staffId"), 
                    rs.getInt("SSN"), rs.getInt("phoneNumber"), 
                    rs.getString("fName"), rs.getString("mInit"), 
                    rs.getString("lName"), rs.getString("address"), 
                    rs.getString("sex"), rs.getDouble("wage"), 
                    rs.getInt("managerId"));
            return myAgent;
        } catch(SQLException e){
            System.out.println(e);
            return null;
        }
    }
    public static Housekeeper getHousekeeperByID(int staffId){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch(ClassNotFoundException e){
            System.out.println(e);
            return null;
        }
        try{
            Connection conn = DriverManager.getConnection(SERVER, ID, PW);
            Statement stmt = conn.createStatement();
            String getAgentByID = "SELECT * "
                    + "FROM thurle1db.Staff as Staff, thurle1db.Housekeeper as Keeper "
                    + "WHERE Staff.staffId = Keeper.staffId "
                    + "AND Staff.staffId = " + staffId + ";";
            ResultSet rs = stmt.executeQuery(getAgentByID);
            rs.next();
            Housekeeper myKeeper = new Housekeeper(rs.getInt("staffId"), 
                    rs.getInt("SSN"), rs.getInt("phoneNumber"), 
                    rs.getString("fName"), rs.getString("mInit"), 
                    rs.getString("lName"), rs.getString("address"), 
                    rs.getString("sex"), rs.getDouble("wage"), 
                    rs.getInt("managerId"));
            return myKeeper;
        } catch(SQLException e){
            System.out.println(e);
            return null;
        }
    }
    public static boolean createGuest(Guest guest){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch(ClassNotFoundException e){
            System.out.println(e);
            return false;
        }
        try{
            Connection conn = DriverManager.getConnection(SERVER, ID, PW);
            Statement stmt = conn.createStatement();
            String insertGuest = "INSERT INTO thurle1db.Guest "
                    + "(`phoneNumber`, `fName`, `mInit`, `lName`, `sex`) "
                    + "VALUES (" + guest.getPhoneNumber() + ", '"
                    + guest.getfName() + "', '" + guest.getmInit() + "', '"
                    + guest.getlName() + "', '" + guest.getSex() + "');";
            stmt.executeUpdate(insertGuest);
            return true;
        } catch (SQLException e){
            System.out.println(e);
            return false;
        }
    }
    public static boolean createReservation(Reservation myRes){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch(ClassNotFoundException e){
            System.out.println(e);
            return false;
        }
        try{
            Connection conn = DriverManager.getConnection(SERVER,ID,PW);
            Statement stmt = conn.createStatement();
            String pattern = "yyyy-MM-dd";
            SimpleDateFormat format = new SimpleDateFormat(pattern);
            String insertReservation = "INSERT INTO thurle1db.Reservation "
                    + "(`checkInDate`, `noDaysStaying`, `guestNo`, "
                    + "`fDeskAgentNo`, `roomNo`) "
                    + "VALUES('" + format.format(myRes.getCheckInDate())  
                    + "', " + myRes.getNoDaysStaying()
                    + ", " + myRes.getGuestNo() + ", " + myRes.getfDeskAgentNo()
                    + ", " + myRes.getRoomNo() + ");";
            stmt.executeUpdate(insertReservation);
            return true;
        } catch (SQLException e){
            System.out.println(e);
            return false;
        }
    }
    public static List<Reservation> getReservationsForToday(){
        Date todaysDate = Calendar.getInstance().getTime();
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        String todaysDateString = format.format(todaysDate);
        List<Reservation> reservations = new LinkedList();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch(ClassNotFoundException e){
            System.out.println(e);
            return null;
        }
        try{
            Connection conn = DriverManager.getConnection(SERVER, ID, PW);
            Statement stmt = conn.createStatement();
            String getTodaysReservations = "SELECT * "
                    + "FROM thurle1db.Reservation "
                    + "WHERE checkInDate = '" + todaysDateString + "';";
            ResultSet rs = stmt.executeQuery(getTodaysReservations);
            while (rs.next()){
                Reservation myRes = new Reservation(rs.getInt("reservationNumber"), 
                    rs.getDate("checkInDate"), rs.getInt("noDaysStaying"), 
                    rs.getInt("guestNo"), rs.getInt("fDeskAgentNo"), 
                    rs.getInt("roomNo"));
                reservations.add(myRes);
            }
            return reservations;
        } catch(SQLException e){
            System.out.println(e);
            return null;
        }
        
        
    }
    public static Guest getGuestInfoFromGuestNumber(int guestNo){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch(ClassNotFoundException e){
            System.out.println(e);
            return null;
        }
        try{
            Connection conn = DriverManager.getConnection(SERVER, ID, PW);
            Statement stmt = conn.createStatement();
            String getGuest = "SELECT * "
                    + "FROM thurle1db.Guest "
                    + "WHERE guestNo = " + guestNo + ";";
            ResultSet rs = stmt.executeQuery(getGuest);
            rs.next();
            Guest myGuest = new Guest(rs.getInt("guestNo"), rs.getInt("phoneNumber"),
                rs.getString("fName"), rs.getString("mInit"), rs.getString("lName"),
                rs.getString("sex"));
            return myGuest;
        } catch(SQLException e){
            System.out.println(e);
            return null;
        }
    }
    public static List<Guest> getAllGuests(){
        List<Guest> guests = new LinkedList();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch(ClassNotFoundException e){
            System.out.println(e);
            return null;
        }
        try{
            Connection conn = DriverManager.getConnection(SERVER, ID, PW);
            Statement stmt = conn.createStatement();
            String getGuests = "SELECT * "
                    + "FROM thurle1db.Guest;";
            ResultSet rs = stmt.executeQuery(getGuests);
            while(rs.next()){
                Guest myGuest = new Guest(rs.getInt("guestNo"), rs.getInt("phoneNumber"),
                    rs.getString("fName"), rs.getString("mInit"), rs.getString("lName"),
                    rs.getString("sex"));
                guests.add(myGuest);
            }
            return guests;
        } catch(SQLException e){
            System.out.println(e);
            return null;
        }
    }
    public static RoomType getRoomInformation(int roomNo){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch(ClassNotFoundException e){
            System.out.println(e);
            return null;
        }
        try{
            Connection conn = DriverManager.getConnection(SERVER, ID, PW);
            Statement stmt = conn.createStatement();
            String getRoomInfo = "SELECT costDaily, description "
                    + "FROM thurle1db.Room as room, thurle1db.RoomType as type "
                    + "WHERE room.roomTypeId = type.roomTypeId "
                    + "AND room.roomNo = " + roomNo + ";";
            ResultSet rs = stmt.executeQuery(getRoomInfo);
            rs.next();
            RoomType type = new RoomType(rs.getInt("costDaily"), rs.getString("description"));
            return type;
        } catch(SQLException e){
            System.out.println(e);
            return null;
        }
    }
    
    public static List<Room> getOpenRoomsForDateRange(Date checkIn, int range){
        List<Room> rooms = new LinkedList();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch(ClassNotFoundException e){
            System.out.println(e);
            return null;
        }
        try{
            Connection conn = DriverManager.getConnection(SERVER, ID, PW);
            Statement stmt = conn.createStatement();
            String pattern = "yyyy-MM-dd";
            SimpleDateFormat format = new SimpleDateFormat(pattern);
            String getRooms = "SELECT * "
                    + "FROM thurle1db.Room "
                    + "WHERE roomNo NOT IN ( SELECT roomNo "
                    + "FROM thurle1db.Reservation "
                    + "WHERE(( '" + format.format(checkIn) + "'< checkInDate "
                    + "AND checkInDate < ADDDATE('" + format.format(checkIn)
                    + "', INTERVAL " + range + " DAY)) "
                    + "OR ('" + format.format(checkIn) + "' < ADDDATE(checkInDate, INTERVAL noDaysStaying DAY) "
                    + "AND ADDDATE(checkInDate, INTERVAL noDaysStaying DAY) < "
                    + "ADDDATE('" + format.format(checkIn) + "', INTERVAL " + range + " DAY)) "
                    + "OR (checkInDate <= '" + format.format(checkIn) + "' "
                    + "AND ADDDATE('" + format.format(checkIn) +"', INTERVAL "+ range +" DAY) "
                    + "<= ADDDATE(checkInDate, INTERVAL noDaysStaying DAY))));";
            ResultSet rs = stmt.executeQuery(getRooms);
            while(rs.next()){
                Room myRoom = new Room(rs.getInt("roomNo"), rs.getInt("roomTypeId"));
                rooms.add(myRoom);
            }
            return rooms;
        } catch(SQLException e){
            System.out.println(e);
            return null;
        }
    }
    public static boolean assignManagerFDesk(FDeskAgent agent){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch(ClassNotFoundException e){
            System.out.println(e);
            return false;
        }
        try {
            Connection conn = DriverManager.getConnection(SERVER, ID, PW);
            Statement stmt = conn.createStatement();
            String updateManager = "UPDATE thurle1db.FDeskAgent "
                    + "SET managerId = " + agent.getManagerId()
                    + " WHERE staffId = " + agent.getStaffId() + ";";
            stmt.executeUpdate(updateManager);
            return true;
        } catch(SQLException e){
            System.out.println(e);
            return false;
        }
    }
    public static boolean assignManagerKeeper(FDeskAgent agent){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch(ClassNotFoundException e){
            System.out.println(e);
            return false;
        }
        try {
            Connection conn = DriverManager.getConnection(SERVER, ID, PW);
            Statement stmt = conn.createStatement();
            String updateManager = "UPDATE thurle1db.Housekeeper "
                    + "SET managerId = " + agent.getManagerId()
                    + " WHERE staffId = " + agent.getStaffId() + ";";
            stmt.executeUpdate(updateManager);
            return true;
        } catch(SQLException e){
            System.out.println(e);
            return false;
        }
    }
    public static boolean assignSchedule(Schedule sched){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch(ClassNotFoundException e){
            System.out.println(e);
            return false;
        }
        try{
            Connection conn = DriverManager.getConnection(SERVER, ID, PW);
            Statement stmt = conn.createStatement();
            String formatString = "yyyy-MM-dd";
            SimpleDateFormat format = new SimpleDateFormat(formatString);
            String scheduleQuery = "INSERT INTO thurle1db.Schedule "
                    + "VALUES(" + sched.getStaffNo() + ", '" 
                    + format.format(sched.getDate()) + "', '" 
                    + sched.getStartTime() + "', '" 
                    + sched.getEndTime() + "');";
            stmt.executeUpdate(scheduleQuery);
            return true;
        } catch(SQLException e){
            System.out.println(e);
            return false;
        }
    }
    
    public static List<Schedule> getScheduleForDay(Date date){
        List<Schedule> schedules = new LinkedList();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch(ClassNotFoundException e){
            System.out.println(e);
            return null;
        }
        try{
            Connection conn = DriverManager.getConnection(SERVER, ID, PW);
            Statement stmt = conn.createStatement();
            String formatString = "yyyy/MM/dd";
            SimpleDateFormat sdf = new SimpleDateFormat(formatString);
            String selectString = "SELECT * "
                    + "FROM thurle1db.Schedule "
                    + "WHERE date = '" + sdf.format(date) + "';";
            ResultSet rs = stmt.executeQuery(selectString);
            while(rs.next()){
                Schedule mySchedule = new Schedule(rs.getInt("staffNo"), date, 
                        LocalTime.parse(rs.getString("startTime")), 
                        LocalTime.parse(rs.getString("endTime")));
                schedules.add(mySchedule);
            }
            return schedules;
        }catch(SQLException e){
            System.out.println(e);
            return null;
        }
    }
    
    //JUST FOR TESTING PURPOSES
    public static void main(String[] args) {
        //FDeskAgent myAgent = new FDeskAgent(3, 123456789, 111111111, "Bob", "J", "Smith", "Some address", "F", 12.50, 2);
        //addFDeskAgent(myAgent);
        //Housekeeper myKeeper = new Housekeeper(3, 123456799, 111111111, "Jane", "J", "Doe", "Some address 2", "F", 13.0, 2);
        //addHousekeeper(myKeeper);
        //List<FDeskAgent> list = getAgentsFromDB();
        //List<Housekeeper> list2 = getHousekeepersFromDB();
        //Manager myManager = new Manager(4, 222334444, 1104567898, "John", "Doe", "F", "M", "Some Address 3", 50000);
        //Database.addManager(myManager);
        //FDeskAgent myAgent = Database.getAgentByID(1);
        //Guest myGuest = new Guest(1234567890, "Tim", "J", "Hurley", "M");
        //Database.createGuest(myGuest);
        //Date myDate = Calendar.getInstance().getTime();
        //Reservation myReservation = new Reservation(myDate, 3, 1, 1, 1);
        //System.out.println(Database.createReservation(myReservation));
        //System.out.println(Database.getReservationsForToday());
        //System.out.println(Database.getGuestInfoFromGuestNumber(1));
        //System.out.println(Database.getAllGuests());
        //System.out.println(Database.getRoomInformation(1));
        //SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        /*try {
            Date date = format.parse("2020-05-11");
            System.out.println(Database.getOpenRoomsForDateRange(date, 3));
        } catch (ParseException ex) {
            System.out.println(ex);
        } */
        //FDeskAgent agent = Database.getAgentByID(1);
        //agent.setManagerId(4);
        //System.out.println(Database.assignManagerFDesk(agent));
        //Date date = Calendar.getInstance().getTime();
        //LocalTime startTime = LocalTime.of(10, 30);
        //LocalTime endTime = LocalTime.of(15, 30);
        //Schedule mySchedule = new Schedule(1, date, startTime, endTime);
        //System.out.println(Database.assignSchedule(mySchedule));
        System.out.println(Database.getScheduleForDay(Calendar.getInstance().getTime()));
    }
    
}
