/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import Model.FDeskAgent;
import Model.Housekeeper;
import Model.Manager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    }
    
}
