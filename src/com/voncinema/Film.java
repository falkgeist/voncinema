package com.voncinema;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Film {
    private int ID, laenge, kategorie;
    private String name, beschreibung, genre;

    Film(int ID, String name, String beschreibung, int laenge, int kategorie, String genre) {
        this.ID = ID;
        this.name = name;
        this.beschreibung = beschreibung;
        this.laenge = laenge;
        this.kategorie = kategorie;
        this.genre = genre;
    }

    public void saveToDB()
    {
        try {
            Connection conn = Kinoverwaltung.setupConnection();
            Statement stat = conn.createStatement();
            String sql = "INSERT INTO vc_film (name, beschreibung, laenge, kategorie, genre) VALUES(" + name + "," + beschreibung + "," + laenge + "," + kategorie + "," + genre + ");";
            stat.executeUpdate(sql);
            conn.close();
        }
        catch (ClassNotFoundException | SQLException e){e.printStackTrace();}
    }

    public boolean hasID(int ID) {
        return this.ID == ID;
    }

    public int getID() {
        return ID;
    }
    public int getKategorie() {
        return kategorie;
    }
    public int getLaenge() {
        return laenge;
    }

    @Override
    public String toString() {
        return name + " (" +laenge+" min)";
    }
}
