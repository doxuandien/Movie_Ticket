/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modify;

import Models.Movie;
import Models.Room;
import Models.Schedule;
import Models.Time;
import static Modify.Base.statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class ScheduleModify extends Base {

    public static List<Schedule> loadData() {
        List<Schedule> scheduleList = new ArrayList<>();
        openConnection();
        String sql = "select schedule .*, time.time as time_name, movie.title as movie_title,movie.cast as cast_name , room.room as room_name "
                + "from schedule join time on schedule.time_id = time.id "
                + "join movie on schedule.movie_id = movie.id "
                + "join room on schedule.room_id = room.id order by schedule.movie_id";

        try {
            statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Schedule schedule = new Schedule(
                        resultSet.getInt("id"),
                        resultSet.getString("date_schedule")
                );
                Movie movie = new Movie(
                        resultSet.getInt("id"),
                        resultSet.getString("movie_title"),
                        resultSet.getString("cast_name")
                );
                Time time = new Time(
                        resultSet.getInt("id"),
                        resultSet.getString("time_name")
                );
                Room room = new Room(
                        resultSet.getInt("id"),
                        resultSet.getString("room_name")
                );
                schedule.setMovie_id(movie);
                schedule.setTime_id(time);
                schedule.setRoom_id(room);

                scheduleList.add(schedule);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ScheduleModify.class.getName()).log(Level.SEVERE, null, ex);
        }
        closeConnection();
        return scheduleList;
    }

    public static void insert(Schedule schedule) {
        openConnection();
        try {
            String sql = "INSERT into schedule (movie_id,time_id,room_id,date_schedule) "
                    + "values (?,?,?,?)";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, schedule.getMovie_id().getId());
            statement.setInt(2, schedule.getTime_id().getId());
            statement.setInt(3, schedule.getRoom_id().getId());
            statement.setString(4, schedule.getDate_schedule());

            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ScheduleModify.class.getName()).log(Level.SEVERE, null, ex);
        }
        closeConnection();
    }

    public static List<Movie> getTitleList() {
        List<Movie> dataList = new ArrayList<>();
        openConnection();

        String sql = "select * from movie";
        try {
            statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Movie mov = new Movie(
                        resultSet.getInt("id"),
                        resultSet.getString("title")
                );
                dataList.add(mov);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MovieModify.class.getName()).log(Level.SEVERE, null, ex);
        }

        closeConnection();
        return dataList;
    }

    public static List<Time> getTimeList() {
        List<Time> dataList = new ArrayList<>();
        openConnection();

        String sql = "select * from time";
        try {
            statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Time time = new Time(
                        resultSet.getInt("id"),
                        resultSet.getString("time")
                );
                dataList.add(time);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MovieModify.class.getName()).log(Level.SEVERE, null, ex);
        }
        closeConnection();
        return dataList;
    }

    public static List<Room> getRoomList() {
        List<Room> dataList = new ArrayList<>();
        openConnection();

        String sql = "select * from room";
        try {
            statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Room room = new Room(
                        resultSet.getInt("id"),
                        resultSet.getString("room")
                );
                dataList.add(room);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MovieModify.class.getName()).log(Level.SEVERE, null, ex);
        }
        closeConnection();
        return dataList;
    }

    public static void deleteSchedule(int id) {
        openConnection();

        String sql = "delete from schedule where id = ?";
        try {
            statement = conn.prepareCall(sql);

            statement.setInt(1, id);

            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(MovieModify.class.getName()).log(Level.SEVERE, null, ex);
        }

        closeConnection();
    }

    public static List<Schedule> listMovieByTitle_Date(String title, String date) {
        List<Schedule> dataList = new ArrayList<>();
        openConnection();
        String sql = "Select schedule .*, movie.title as movie_title,time.time as time_name,room.room as room_name "
                + "from schedule join movie on schedule.movie_id = movie.id "
                + "join time on schedule.time_id = time.id "
                + "join room on schedule.room_id = room.id WHERE movie.title = ? AND date_schedule = ?";
        try {
            statement = conn.prepareCall(sql);
            statement.setString(1, title);
            statement.setString(2, date);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Schedule schedule = new Schedule(
                        resultSet.getInt("id"),
                        resultSet.getString("date_schedule")
                );
                Movie movie = new Movie(
                        resultSet.getInt("id"),
                        resultSet.getString("movie_title")
                );
                Time time = new Time(
                        resultSet.getInt("id"),
                        resultSet.getString("time_name")
                );
                Room room = new Room(
                        resultSet.getInt("id"),
                        resultSet.getString("room_name")
                );
                schedule.setMovie_id(movie);
                schedule.setTime_id(time);
                schedule.setRoom_id(room);

                dataList.add(schedule);
            }
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ScheduleModify.class.getName()).log(Level.SEVERE, null, ex);
        }
        closeConnection();
        return dataList;
    }

    public static List<Schedule> getSchedulebyID(int id) {
        List<Schedule> dataList = new ArrayList<>();
        openConnection();
        String sql = "select schedule .*, time.time as time_name, movie.title as movie_title,movie.cast as cast_name , room.room as room_name "
                + "from schedule join time on schedule.time_id = time.id "
                + "join movie on schedule.movie_id = movie.id "
                + "join room on schedule.room_id = room.id where schedule.id = ?";
        try {
            statement = conn.prepareCall(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Schedule schedule = new Schedule(
                        resultSet.getInt("id"),
                        resultSet.getString("date_schedule")
                );
                Movie movie = new Movie(
                        resultSet.getInt("id"),
                        resultSet.getString("movie_title")
                );
                Time time = new Time(
                        resultSet.getInt("id"),
                        resultSet.getString("time_name")
                );
                Room room = new Room(
                        resultSet.getInt("id"),
                        resultSet.getString("room_name")
                );
                schedule.setMovie_id(movie);
                schedule.setTime_id(time);
                schedule.setRoom_id(room);

                dataList.add(schedule);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TicketModify.class.getName()).log(Level.SEVERE, null, ex);
        }
        closeConnection();
        return dataList;
    }

    public static List<Schedule> checkMovieInSchedule(int id) {
        List<Schedule> dataList = new ArrayList<>();
        openConnection();
        String sql = "Select schedule .*, movie.title as movie_title "
                + "from schedule join movie on schedule.movie_id = movie.id where movie.id = ?";

        try {
            statement = conn.prepareCall(sql);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Schedule schedule = new Schedule(
                        resultSet.getInt("id"),
                        resultSet.getString("date_schedule")
                );
                Movie movie = new Movie(
                        resultSet.getInt("id"),
                        resultSet.getString("movie_title")
                );
                schedule.setMovie_id(movie);
                dataList.add(schedule);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ScheduleModify.class.getName()).log(Level.SEVERE, null, ex);
        }
        closeConnection();
        return dataList;
    }

    public static boolean checkDuplicate(int room_id, int time_id,String date_schedule) {
        boolean check = false;
        openConnection();
        String sql = "SELECT * from schedule where room_id = ? and time_id = ? and date_schedule = ?";
        try {
            statement = conn.prepareCall(sql);
            statement.setInt(1, room_id);
            statement.setInt(2, time_id);
            statement.setString(3, date_schedule);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                closeConnection();
                check = false;
            } else {
                closeConnection();
                check = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ScheduleModify.class.getName()).log(Level.SEVERE, null, ex);
        }
        closeConnection();
        return check;
    }
    
    
    // testing
    public static List<Schedule> listMovieByDate(){
    List<Schedule> dataList = new ArrayList<>();
        openConnection();
        
        String sql = "Select schedule .*, movie.title as movie_title,movie.img as img "
                + "from schedule join movie on schedule.movie_id = movie.id "    
                + "WHERE schedule.date_schedule BETWEEN '2021-12-20' AND '2021-12-22' ";
        try {
            statement = conn.prepareCall(sql);


            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Schedule schedule = new Schedule(
                        resultSet.getInt("id"),
                        resultSet.getString("date_schedule")
                );
                Movie movie = new Movie(
                        resultSet.getInt("id"),
                        resultSet.getString("movie_title"),
                        resultSet.getString("img")
                );
                schedule.setMovie_id(movie);
                dataList.add(schedule);
            }
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ScheduleModify.class.getName()).log(Level.SEVERE, null, ex);
        }
        closeConnection();
        return dataList;
    }
}


