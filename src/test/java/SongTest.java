package test.java;

import java.time.Duration;
import org.junit.*;
import static org.junit.Assert.assertEquals;
import main.java.Song;

public class SongTest {
	@Test
	public void getPrettyDurationTest() {
		Song mySong = new Song("Title","Artist",Duration.ofSeconds(205));
		String prettyResult = mySong.getDurationPretty();
		String expectedResult = String.format("%d:%02d:%02d", 0,3,25);
		assertEquals("getDurationPretty should convert a song's duration in seconds into the format mm:ss",prettyResult,expectedResult);
	}
		
}
