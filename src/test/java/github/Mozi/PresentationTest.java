/**
 * 
 */
package github.Mozi;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import github.Mozi.Model.Movie;
import github.Mozi.Model.Presentation;
import github.Mozi.Model.Room;
import github.Mozi.Model.Movie.MovieType;

/**
 * Előadások tesztje.
 * 
 * @author Bozsar Tamas
 *
 */
public class PresentationTest {

	/**
	 * Az előadás {@link Presentation}.
	 */
	private Presentation presentation;
	
	/**
	 * Előadás ideje.
	 */
	private LocalDateTime time;
	

	/**
	 * @throws java.lang.Exception - kivétel
	 */
	@Before
	public void setUp() throws Exception {

		this.time = LocalDateTime.now();
		ArrayList<String> actors = new ArrayList<String>();
		actors.add("Boba Fett");
		
		
		Movie m = new Movie(1, "x", 10, true, true, "hun", MovieType.Akció, actors);
		Room r = new Room(1, "x", 10);
		
		this.presentation = new Presentation(1, this.time, m, r, 0, true);

	}

	/**
	 * A tesztelt metódus kiszámítja, hogy mennyi elérhető szék van még az előadásra.
	 * 
	 * Test method for
	 * {@link Presentation#calculateNotReservedSeatNumber()}.
	 */
	@Test
	public void testCalculateNotReservedSeatNumber() {

		this.presentation.getRoom().setSeats(100);

		this.presentation.setReservedSeats(0);

		assertEquals(100, this.presentation.calculateNotReservedSeatNumber());

		
		this.presentation.getRoom().setSeats(100);

		this.presentation.setReservedSeats(1);
		
		assertEquals(99, this.presentation.calculateNotReservedSeatNumber());
		
		
		
		this.presentation.getRoom().setSeats(100);

		this.presentation.setReservedSeats(49);
		
		
		assertEquals(51, this.presentation.calculateNotReservedSeatNumber());
		
		
		this.presentation.getRoom().setSeats(100);

		this.presentation.setReservedSeats(99);
		
		assertEquals(1, this.presentation.calculateNotReservedSeatNumber());
		

		
		this.presentation.getRoom().setSeats(100);

		this.presentation.setReservedSeats(100);
		
		assertEquals(0, this.presentation.calculateNotReservedSeatNumber());
		
		
	}
	

	/**
	 * Test method for {@link github.Mozi.Model.Presentation#getId()}.
	 */
	@Test
	public void testGetId() {
		assertEquals(1, this.presentation.getId());
	}

	/**
	 * Test method for {@link github.Mozi.Model.Presentation#setId(int)}.
	 */
	@Test
	public void testSetId() {
		
		this.presentation.setId(2);
		
		assertEquals(2, this.presentation.getId());
	}

	/**
	 * Test method for {@link github.Mozi.Model.Presentation#getTime()}.
	 */
	@Test
	public void testGetTime() {
		
		assertEquals(this.time, this.presentation.getTime());
		
	}

	/**
	 * Test method for {@link github.Mozi.Model.Presentation#setTime(java.time.LocalDateTime)}.
	 */
	@Test
	public void testSetTime() {
		
		this.time = LocalDateTime.now();
		
		this.presentation.setTime(this.time);
		
		assertEquals(this.time, this.presentation.getTime());
	}

	/**
	 * Test method for {@link github.Mozi.Model.Presentation#getMovie()}.
	 */
	@Test
	public void testGetMovie() {
	
		Movie m = this.presentation.getMovie();
		
		assertEquals(m, this.presentation.getMovie());
		
		
	}

	/**
	 * Test method for {@link github.Mozi.Model.Presentation#setMovie(github.Mozi.Model.Movie)}.
	 */
	@Test
	public void testSetMovie() {
		

		Movie m = new Movie(2, "Y", 10, true, true, "hun", MovieType.Akció, null);
		
		this.presentation.setMovie(m);
		
		assertEquals( m , this.presentation.getMovie());
	}

	/**
	 * Test method for {@link github.Mozi.Model.Presentation#getRoom()}.
	 */
	@Test
	public void testGetRoom() {

		
		Room r = new Room(1, "x", 10);
		
		assertEquals(r , this.presentation.getRoom());
	}

	/**
	 * Test method for {@link github.Mozi.Model.Presentation#setRoom(github.Mozi.Model.Room)}.
	 */
	@Test
	public void testSetRoom() {

		Room r = new Room(2, "x", 13);
		
		this.presentation.setRoom(r);
		
		assertEquals(r, this.presentation.getRoom());
	}

	/**
	 * Test method for {@link github.Mozi.Model.Presentation#getReservedSeats()}.
	 */
	@Test
	public void testGetReservedSeats() {
		
		assertEquals(0, this.presentation.getReservedSeats());
		
	}

	/**
	 * Test method for {@link github.Mozi.Model.Presentation#setReservedSeats(int)}.
	 */
	@Test
	public void testSetReservedSeats() {
		
		this.presentation.setReservedSeats(99);
		
		assertEquals(99, this.presentation.getReservedSeats());
		
	}

	/**
	 * Test method for {@link github.Mozi.Model.Presentation#isFirstPlayOnDay()}.
	 */
	@Test
	public void testIsFirstPlayOnDay() {
		assertTrue(this.presentation.isFirstPlayOnDay());
	}

	/**
	 * Test method for {@link github.Mozi.Model.Presentation#setFirstPlayOnDay(boolean)}.
	 */
	@Test
	public void testSetFirstPlayOnDay() {
		
		this.presentation.setFirstPlayOnDay(false);
		
		assertFalse(this.presentation.isFirstPlayOnDay());
	}

}
