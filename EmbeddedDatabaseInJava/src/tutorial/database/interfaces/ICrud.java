/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial.database.interfaces;

import java.util.ArrayList;
import tutorial.model.Movie;


public interface ICrud {
    
    public void addMovie(Movie boook);
    
    public void removeMovie(String keyword);
    
    public ArrayList<Movie> getAllMovies();
    
    public void updateMovie(Movie movie);
    
    public boolean search(String keyword);
    
}
