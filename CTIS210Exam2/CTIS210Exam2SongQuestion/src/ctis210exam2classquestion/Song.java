package ctis210exam2classquestion;

import java.util.Random;

public class Song {
    
    private String artist;
    private String title;
    private int lengthInSeconds;
    //The rating should have a value from 0-10
    private double rating;
    private boolean liked;
    private int year;
    private int timesPlayed;

    public Song() {
    }

    public Song(String artist, String title, int lengthInSeconds, double rating, boolean liked, int year) {
        this.artist = artist;
        this.title = title;
        this.lengthInSeconds = lengthInSeconds;
        this.rating = rating;
        this.liked = liked;
        this.year = year;
        
        Random rnd = new Random();
        this.timesPlayed = rnd.nextInt(36);
    }
    
    public String evalString() {
        if (rating < 3.5 || timesPlayed < 5) {
            return "Not great";
        } else if (rating < 8f || timesPlayed < 20) {
            return "OK";
        } else {
            return "Good";
        }
    }
    
    /**
     * Adds the rating to the product of the rating and the natural log of the
     * number of times it was played
     * @return Song rating
     */
    public double songValue() {
        return (rating + rating * Math.log(timesPlayed));
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLengthInSeconds() {
        return lengthInSeconds;
    }

    public void setLengthInSeconds(int lengthInSeconds) {
        this.lengthInSeconds = lengthInSeconds;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public boolean isLiked() {
        return liked;
    }

    public void setLiked(boolean liked) {
        this.liked = liked;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    
    public double lengthInMinutes() {
        double length = lengthInSeconds / 60.;
        return length;
    }

    public int getTimesPlayed() {
        return timesPlayed;
    }

    public void setTimesPlayed(int timesPlayed) {
        this.timesPlayed = timesPlayed;
    }

    @Override
    public String toString() {
        return "Song{" + "artist=" + artist + ", title=" + title + ", lengthInSeconds=" + lengthInSeconds + ", rating=" + rating + ", liked=" + liked + ", year=" + year + ", timesPlayed=" + timesPlayed + '}';
    }
    
    
    
}
