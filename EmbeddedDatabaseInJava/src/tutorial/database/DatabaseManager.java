/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import tutorial.database.interfaces.ICrud;
import tutorial.model.Movie;


public class DatabaseManager implements ICrud {

    private static final String JDBC_DRIVER = "org.h2.Driver";
    private static final String DB_URL = "jdbc:h2:~/movieDB";
    private static final String DB_USERNAME = "test";
    private static final String DB_PASSWORD = "test";
    private Connection connection;
    private Statement stmt;

    private static final String CREATE_TABLE = "CREATE TABLE MOVIES "
            + "(movieid bigint auto_increment NOT NULL PRIMARY KEY, "
            + " moviename VARCHAR(255), "
            + " movielink VARCHAR(255), "
            + " moviecategory VARCHAR(255))";

    public DatabaseManager() {
        openConnection();
    }

    public void openConnection() {
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            stmt = connection.createStatement();
            stmt.execute(CREATE_TABLE);
        } catch (Exception ex) {
        }
    }

    @Override
    public void addMovie(Movie moovie) {
        try {
            String sql = "INSERT INTO MOVIES (moviename, movielink, moviecategory) VALUES ('" + moovie.getMovieName() + "',"
                    + " '" + moovie.getMovieLink() + "', '" + moovie.getMovieCategory() + "')";
            stmt.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void removeMovie(String keyword) {
        try {
            String sql = "DELETE FROM MOVIES  where movieid =  '" + keyword + "'";
            stmt.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<Movie> getAllMovies() {
        ArrayList<Movie> movies = new ArrayList<>();

        try {
            String sql = "SELECT * FROM MOVIES";

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Movie movie = new Movie();
                movie.setMovieId(rs.getString("movieid"));
                movie.setMovieName(rs.getString("moviename"));
                movie.setMovieLink(rs.getString("movielink"));
                movie.setMovieCategory(rs.getString("moviecategory"));
                movies.add(movie);
            }
            return movies;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return movies;
    }

    @Override
    public void updateMovie(Movie movie) {
        try {
            String sql = "UPDATE MOVIES set moviename = '" + movie.getMovieName()+ "', movielink = '" + movie.getMovieLink()+ "',"
                    + " moviecategory = '" + movie.getMovieCategory()+ "' where movieid =  '" + movie.getMovieId()+ "'";
            stmt.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean search(String keyword) {
        try {
            String sql = "SELECT * FROM MOVIES WHERE movieid = '" + keyword + "'";
            ResultSet rs = stmt.executeQuery(sql);
            int size = 0;
            if (rs != null) {
                rs.beforeFirst();
                rs.last();
                size = rs.getRow();
            }

            return size > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
