/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modify;

import Models.Movie;
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
public class MovieModify extends Base {

    public static List<Movie> findAll() {
        List<Movie> dataList = new ArrayList<>();
        openConnection();

        String sql = "select * from movie";
        try {
            statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Movie mov = new Movie(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getString("genre"),
                        resultSet.getString("cast"),
                        resultSet.getString("director"),
                        resultSet.getString("img"),
                        resultSet.getInt("duration"),
                        resultSet.getString("description"),
                        resultSet.getString("released"),
                        resultSet.getString("created_at"),
                        resultSet.getString("updated_at")
                );
                dataList.add(mov);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MovieModify.class.getName()).log(Level.SEVERE, null, ex);
        }

        closeConnection();
        return dataList;
    }

    public static void insert(Movie movie) {
        openConnection();

        String sql = "insert into movie(title, genre, cast, director, img, duration, description, released, created_at, updated_at)"
                + "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            Date date = new Date();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String strDate = dateFormat.format(date);

            statement = conn.prepareStatement(sql);
            statement.setString(1, movie.getTitle());
            statement.setString(2, movie.getGenre());
            statement.setString(3, movie.getCast());
            statement.setString(4, movie.getDirector());
            statement.setString(5, movie.getImg());
            statement.setInt(6, movie.getDuration());
            statement.setString(7, movie.getDescription());
            statement.setString(8, movie.getReleased());
            statement.setString(9, strDate);
            statement.setString(10, strDate);

            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(MovieModify.class.getName()).log(Level.SEVERE, null, ex);
        }

        closeConnection();
    }

    public static void delete(int id) {
        openConnection();

        String sql = "delete from movie where id = ?";
        try {
            statement = conn.prepareCall(sql);

            statement.setInt(1, id);

            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(MovieModify.class.getName()).log(Level.SEVERE, null, ex);
        }

        closeConnection();
    }

    public static void update(Movie movie) {
        openConnection();

        try {
            String sql = "update movie set title = ? , genre = ?, cast = ?, director = ?, img =? ,duration = ?, description = ? ,updated_at = ? , released = ? where id = ?";
            statement = conn.prepareStatement(sql);

            Date date = new Date();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String strDate = dateFormat.format(date);

            statement.setString(1, movie.getTitle());
            statement.setString(2, movie.getGenre());
            statement.setString(3, movie.getCast());
            statement.setString(4, movie.getDirector());
            statement.setString(5, movie.getImg());
            statement.setInt(6, movie.getDuration());
            statement.setString(7, movie.getDescription());
            statement.setString(8, strDate);
            statement.setString(9, movie.getReleased());
            statement.setInt(10, movie.getId());

            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(MovieModify.class.getName()).log(Level.SEVERE, null, ex);
        }
        closeConnection();
    }

    public static List<Movie> findByTitle(String title) {
        List<Movie> movieList = new ArrayList<>();
        openConnection();

        try {

            String sql = "select * from movie where title like ?";
            statement = conn.prepareCall(sql);
            statement.setString(1, "%" + title + "%");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Movie movie = new Movie(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getString("genre"),
                        resultSet.getString("cast"),
                        resultSet.getString("director"),
                        resultSet.getString("img"),
                        resultSet.getInt("duration"),
                        resultSet.getString("description"),
                        resultSet.getString("released"),
                        resultSet.getString("created_at"),
                        resultSet.getString("updated_at")
                );
                movieList.add(movie);
            }
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(MovieModify.class.getName()).log(Level.SEVERE, null, ex);
        }
        closeConnection();
        return movieList;

    }

    public static void save(Movie movie) {
        if (movie.getId() > 0) {
            update(movie);
        } else {
            insert(movie);
        }
    }
}
