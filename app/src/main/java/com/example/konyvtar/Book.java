package com.example.konyvtar;

public class Book {
    String Tiltle;
    String creator;
    Integer laps;

    public Book(String tiltle, String creator, Integer laps) {
        Tiltle = tiltle;
        this.creator = creator;
        this.laps = laps;
    }

    public String getTiltle() {
        return Tiltle;
    }

    public void setTiltle(String tiltle) {
        Tiltle = tiltle;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Integer getLaps() {
        return laps;
    }

    public void setLaps(Integer laps) {
        this.laps = laps;
    }
}
