/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial.database.interfaces;

import tutorial.model.Movie;


public interface ICommunicator {

    public void saveMovie(Movie movie);
    
    public void editMovie(Movie movie);
}
