package main.java;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class Playlist {
	private String name;
	private List<Song> songlist;
	
	public Playlist() {
		songlist = new ArrayList<Song>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Song> getSonglist() {
		return songlist;
	}

	public void addSong(Song song) {
		this.songlist.add(song);
	}
	
	public void removeSong(Song song) {
		this.songlist.remove(song);
	}
	
	public void moveSong(int currentIndex, int newIndex) {
		Song songToMove = this.songlist.get(currentIndex);
		this.songlist.remove(songToMove);
		this.songlist.add(newIndex,songToMove);
	}
	
	public Duration getPlaylistDuration() {
		return this.songlist.stream()
						    .map(song->song.getDuration())
						    .reduce(Duration.ofSeconds(0),(dur1,dur2)->dur1.plus(dur2));
	}
	

	public String getPrettyPlaylist() {
		// TODO Auto-generated method stub
		return this.songlist.stream()
							.map(song->song.getTitle()+" - "+song.getArtist()+" "+song.getDurationPretty()+"\n")
							.reduce("",(song1,song2)->song1+ song2);
	}
	
	
}
