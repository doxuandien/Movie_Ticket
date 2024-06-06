/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modify;

import Models.Ticket;
import static Modify.Base.closeConnection;
import static Modify.Base.conn;
import static Modify.Base.statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class TicketModify extends Base {

    public static List<Ticket> loadTickets() {
        List<Ticket> ticketList = new ArrayList<>();
        openConnection();
        String sql = "select * "
                + "from ticket join schedule on ticket.schedule_id = schedule.id ";
        try {
            statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Ticket ticket = new Ticket(
                        resultSet.getInt("id"),
                        resultSet.getInt("user_id"),
                        resultSet.getInt("schedule_id"),
                        resultSet.getString("seat_code"),
                        resultSet.getFloat("total"),
                        resultSet.getString("created_at")
                );

                ticketList.add(ticket);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TicketModify.class.getName()).log(Level.SEVERE, null, ex);
        }
        closeConnection();
        return ticketList;
    }

    public static void insertTicket(Ticket ticket) {
        openConnection();

        String sql = "INSERT into ticket (user_id, schedule_id, seat_code, total, created_at)"
                + "VALUES(?, ?, ?, ?, ?)";
        try {
            Date date = new Date();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String strDate = dateFormat.format(date);

            statement = conn.prepareStatement(sql);
            statement.setInt(1, ticket.getUser_id());
            statement.setInt(2, ticket.getSchedule_id());
            statement.setString(3, ticket.getSeat_code());
            statement.setFloat(4, ticket.getTotal());
            statement.setString(5, strDate);

            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(TicketModify.class.getName()).log(Level.SEVERE, null, ex);
        }

        closeConnection();
    }

    public static List<Ticket> getTicketByUser_ID(int id) {
        List<Ticket> dataList = new ArrayList<>();
        openConnection();
        String sql = "SELECT * from ticket where user_id = ?";
        try {
            statement = conn.prepareCall(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Ticket ticket = new Ticket(
                        resultSet.getInt("id"),
                        resultSet.getInt("user_id"),
                        resultSet.getInt("schedule_id"),
                        resultSet.getString("seat_code"),
                        resultSet.getFloat("total"),
                        resultSet.getString("created_at")
                );
                dataList.add(ticket);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TicketModify.class.getName()).log(Level.SEVERE, null, ex);
        }
        closeConnection();
        return dataList;
    }

    public static List<Ticket> getTicketBySchedule_ID(int id) {
        List<Ticket> dataList = new ArrayList<>();
        openConnection();
        String sql = "SELECT * from ticket where schedule_id = ?";
        try {
            statement = conn.prepareCall(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Ticket ticket = new Ticket(
                        resultSet.getInt("id"),
                        resultSet.getInt("user_id"),
                        resultSet.getInt("schedule_id"),
                        resultSet.getString("seat_code"),
                        resultSet.getFloat("total"),
                        resultSet.getString("created_at")
                );
                dataList.add(ticket);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TicketModify.class.getName()).log(Level.SEVERE, null, ex);
        }
        closeConnection();
        return dataList;
    }
    
    public static List<Ticket> getAll(){
        List<Ticket> ticketList = new ArrayList<>();
        openConnection();
        String sql = "select * from ticket order by user_id";
                
        try {
            statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Ticket ticket = new Ticket(
                        resultSet.getInt("id"),
                        resultSet.getInt("user_id"),
                        resultSet.getInt("schedule_id"),
                        resultSet.getString("seat_code"),
                        resultSet.getFloat("total"),
                        resultSet.getString("created_at")
                );

                ticketList.add(ticket);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TicketModify.class.getName()).log(Level.SEVERE, null, ex);
        }
        closeConnection();
        return ticketList;
    }

    public static List<Ticket> FindByFullname(String fullname) {
        List<Ticket> TicketList = new ArrayList<>();
        openConnection();
        String sql = "select ticket .*, user.fullname as user_name , schedule.id "
                + "from ticket join user on ticket.user_id = user.id "
                + "join schedule on ticket.schedule_id = schedule.id where user.fullname like ?";
        try {

            statement = conn.prepareCall(sql);
            statement.setString(1, "%" + fullname + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Ticket ticket = new Ticket(
                        resultSet.getInt("id"),
                        resultSet.getInt("user_id"),
                        resultSet.getInt("schedule_id"),
                        resultSet.getString("seat_code"),
                        resultSet.getFloat("total"),
                        resultSet.getString("created_at")
                );

                TicketList.add(ticket);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TicketModify.class.getName()).log(Level.SEVERE, null, ex);
        }
        closeConnection();
        return TicketList;
    }
    
    public static List<Ticket> getDate(String date){
        List<Ticket> ticketList = new ArrayList<>();
        openConnection();
        String sql = "select * from ticket where created_at like ? order by user_id";
                
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, "%" + date + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Ticket ticket = new Ticket(
                        resultSet.getInt("id"),
                        resultSet.getInt("user_id"),
                        resultSet.getInt("schedule_id"),
                        resultSet.getString("seat_code"),
                        resultSet.getFloat("total"),
                        resultSet.getString("created_at")
                );

                ticketList.add(ticket);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TicketModify.class.getName()).log(Level.SEVERE, null, ex);
        }
        closeConnection();
        return ticketList;
    }
    
    public static void delete(int id){
        openConnection();

        String sql = "delete from ticket where id = ?";
        try {
            statement = conn.prepareCall(sql);

            statement.setInt(1, id);

            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(TicketModify.class.getName()).log(Level.SEVERE, null, ex);
        }

        closeConnection();
    }
    
    public static void deleteAll(String date){
        openConnection();

        String sql = "delete from ticket where created_at like ?";
        try {
            statement = conn.prepareCall(sql);

            statement.setString(1,"%" + date + "%");

            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(TicketModify.class.getName()).log(Level.SEVERE, null, ex);
        }

        closeConnection();
    }
}
