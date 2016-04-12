package se.oscarb.movieapidemo;

import com.google.gson.annotations.SerializedName;

public class Movie {
    // Instansvariabler
    // I JSON står det "Title" men instansvariablen ska vara title

    @SerializedName("Title")  // Från JSON
    private String title;     // till Java

    @SerializedName("Year")
    private int year;

    @SerializedName("Rated")
    private char rated;

    @SerializedName("Released")
    private String released;

    @SerializedName("Poster")
    private String poster;

    // Instansmetoder
    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public char getRated() {
        return rated;
    }

    public String getReleased() {
        return released;
    }

    public String getPoster() {
        return poster;
    }
}
