/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Admin
 */
public class Ticket {
    int id;
    int user_id;
    int schedule_id;
    String seat_code;
    float total;
    String created_at;

    public Ticket(int id, String created_at) {
        this.id = id;
        this.created_at = created_at;
    }

    public Ticket(int id, int user_id, int schedule_id, String seat_code, float total, String created_at) {
        this.id = id;
        this.user_id = user_id;
        this.schedule_id = schedule_id;
        this.seat_code = seat_code;
        this.total = total;
        this.created_at = created_at;
    }

    public Ticket(int id, String seat_code, float total, String created_at) {
        this.id = id;
        this.seat_code = seat_code;
        this.total = total;
        this.created_at = created_at;
    }
    
    public Ticket() {
    }

    public Ticket(int user_id, int schedule_id, String seat_code, float total, String created_at) {
        this.user_id = user_id;
        this.schedule_id = schedule_id;
        this.seat_code = seat_code;
        this.total = total;
        this.created_at = created_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getSchedule_id() {
        return schedule_id;
    }

    public void setSchedule_id(int schedule_id) {
        this.schedule_id = schedule_id;
    }

    public String getSeat_code() {
        return seat_code;
    }

    public void setSeat_code(String seat_code) {
        this.seat_code = seat_code;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    

    
}
