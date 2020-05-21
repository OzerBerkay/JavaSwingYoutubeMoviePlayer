/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial.model;


public class Movie {
    
    private String movieId, movieName, movieLink, movieCategory;

    /**
     * @return the movieId
     */
    public String getMovieId() {
        return movieId;
    }

    /**
     * @param movieId the movieId to set
     */
    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    /**
     * @return the movieName
     */
    public String getMovieName() {
        return movieName;
    }

    /**
     * @param movieName the movieName to set
     */
    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    /**
     * @return the movieLink
     */
    public String getMovieLink() {
        return movieLink;
    }

    /**
     * @param movieLink the movieLink to set
     */
    public void setMovieLink(String movieLink) {
        this.movieLink = movieLink;
    }

    /**
     * @return the movieCategory
     */
    public String getMovieCategory() {
        return movieCategory;
    }

    /**
     * @param movieCategory the movieCategory to set
     */
    public void setMovieCategory(String movieCategory) {
        this.movieCategory = movieCategory;
    }

    @Override
    public String toString() {
        return "Movie ID: " + movieId + "\nMovie Name: " + movieName + "\nMovie Link: " + movieLink + "\nMovie Category: " + movieCategory;
    }

}
