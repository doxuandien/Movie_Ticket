/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author xuandien
 */
public class Movie {

    int id;
    String title, genre, cast, director, img;
    int duration;
    String description;
    String released;
    String createdAt, updatedAt;

    public Movie() {
    }

    public Movie(String title) {
        this.title = title;
    }
    
    public Movie(int id, String title, String img) {
        this.id = id;
        this.title = title;
        this.img = img;
    }

    public Movie(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public Movie(int id, String title, String genre, String cast, String director, String img, int duration, String description, String released, String createdAt, String updatedAt) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.cast = cast;
        this.director = director;
        this.img = img;
        this.duration = duration;
        this.description = description;
        this.released = released;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Movie(String title, String genre, String cast, String director, String img, int duration, String description, String released, String createdAt, String updatedAt) {
        this.title = title;
        this.genre = genre;
        this.cast = cast;
        this.director = director;
        this.img = img;
        this.duration = duration;
        this.description = description;
        this.released = released;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return title;
    }
    
}
