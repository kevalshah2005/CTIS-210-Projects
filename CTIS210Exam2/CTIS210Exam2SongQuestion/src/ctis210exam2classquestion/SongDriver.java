package ctis210exam2classquestion;

import java.util.ArrayList;

public class SongDriver {

    public static void main(String[] args) {
        // TODO code application logic here
        Song mySong = new Song("Tristam", "Till It's Over", 271, 10, true, 2013);
        System.out.println("Length in minutes: " + mySong.lengthInMinutes());
        System.out.println("Title: " + mySong.getTitle());
        System.out.println("Times Played: " + mySong.getTimesPlayed());
        System.out.println("Song Evaluation: " + mySong.evalString());
        System.out.println("Song Rating: " + mySong.songValue());
        
        ArrayList<Song> songs = new ArrayList<>();
        songs.add(mySong);
        Song otherSong = new Song("Imagine Dragons", "Thunder", 187, 8, true, 2017);
        songs.add(otherSong);
        
        songs.forEach(song -> {
            System.out.println(song);
        });
    }
    
}
