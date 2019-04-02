package test.java;

import static org.junit.Assert.assertEquals;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.*;

import main.java.Playlist;
import main.java.Song;


public class PlaylistTest {
	
	Playlist myPlaylist;
	List<Song> songs = new ArrayList<Song>(Arrays.asList(
			new Song("Billie Jean","Michael Jackson",Duration.ofSeconds(210)),
			new Song("I Would Do Anything for Love","Meatloaf",Duration.ofSeconds(756)),
			new Song("Closer","The Chainsmokers",Duration.ofSeconds(244))));
	
	public void addSongs() {
		myPlaylist.addSong(songs.get(0));
		myPlaylist.addSong(songs.get(1));
		myPlaylist.addSong(songs.get(2));
	}
	
	@Before
	public void testSetup() {
		myPlaylist = new Playlist();
	}

	@Test
	public void newPlaylistEmptyTest() {
		int expectedSize = 0;
		int actualSize = myPlaylist.getSonglist().size();
		assertEquals("A new songlist should be empty",expectedSize,actualSize);
	}
	
	@Test
	public void addSongToPlaylistTest() {
		myPlaylist.addSong(songs.get(0));
		int expectedSize = 1;
		int actualSize = myPlaylist.getSonglist().size(); 
		assertEquals("Adding a song to the playlist should increase its size by 1",expectedSize,actualSize);
	}
	
	@Test
	public void removeSongFromPlaylistTest() {
		addSongs();
		myPlaylist.removeSong(songs.get(1));
		assertEquals("Removing a song from a playlist should shorten the songlist by 1",2,myPlaylist.getSonglist().size());
		assertEquals("Removing a song from a playlist should remove only that song","Billie Jean",myPlaylist.getSonglist().get(0).getTitle());
		assertEquals("Removing a song from a playlist should remove only that song","Closer",myPlaylist.getSonglist().get(1).getTitle());

	}
	
	@Test
	public void moveSongTest() {
		addSongs();
		myPlaylist.moveSong(2,0);
		String song0Title = myPlaylist.getSonglist().get(0).getTitle();
		String song1Title = myPlaylist.getSonglist().get(1).getTitle();
		String song2Title = myPlaylist.getSonglist().get(2).getTitle();
		assertEquals("First song is correct","Closer",song0Title);
		assertEquals("Second song is correct","Billie Jean",song1Title);
		assertEquals("Third song is correct","I Would Do Anything for Love",song2Title);
		
	}
	
	@Test
	public void getPlaylistDurationTest() {
		addSongs();
		long expectedDurationSeconds = 1210;
		long actualDurationSeconds = myPlaylist.getPlaylistDuration().getSeconds();
		assertEquals("Total Duration of playist is equal to sum of song durations",expectedDurationSeconds,actualDurationSeconds);
	}
	
	@Test
	public void showPlaylistTest() {
		addSongs();
		String expectedPlaylist = songs.get(0).getTitle()+" - "+ songs.get(0).getArtist()+" "+songs.get(0).getDurationPretty()+"\n"+
								  songs.get(1).getTitle()+" - "+ songs.get(1).getArtist()+" "+songs.get(1).getDurationPretty()+"\n"+
								  songs.get(2).getTitle()+" - "+ songs.get(2).getArtist()+" "+songs.get(2).getDurationPretty()+"\n";
		System.out.println(myPlaylist.getPrettyPlaylist());
		assertEquals("The showPlaylist method should produce a pretty list",expectedPlaylist,myPlaylist.getPrettyPlaylist());
	}

}
