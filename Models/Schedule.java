/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Admin
 */
public class Schedule {

    int id;
    Movie movie_id;
    Time time_id;
    Room room_id;
    String date_schedule;

    public Schedule(int id, String date_schedule) {
        this.id = id;
        this.date_schedule = date_schedule;
    }

    public Schedule(int id) {
        this.id = id;
    }

    public Schedule(String date_schedule) {
        this.date_schedule = date_schedule;
    }

    public Schedule() {
    }

    public Schedule(int id, Movie movie_id, Time time_id, Room room_id, String date_schedule) {
        this.id = id;
        this.movie_id = movie_id;
        this.time_id = time_id;
        this.room_id = room_id;
        this.date_schedule = date_schedule;
    }

    public Schedule(Movie movie_id, Time time_id, Room room_id) {
        this.movie_id = movie_id;
        this.time_id = time_id;
        this.room_id = room_id;
    }

    public String getDate_schedule() {
        return date_schedule;
    }

    public void setDate_schedule(String date_schedule) {
        this.date_schedule = date_schedule;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Movie getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(Movie movie_id) {
        this.movie_id = movie_id;
    }

    public Time getTime_id() {
        return time_id;
    }

    public void setTime_id(Time time_id) {
        this.time_id = time_id;
    }

    public Room getRoom_id() {
        return room_id;
    }

    public void setRoom_id(Room room_id) {
        this.room_id = room_id;
    }

}
