package github.Mozi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import github.Mozi.Model.Room;

/**
 * @author Bozsar Tamas
 *
 */
public class RoomTest {

	/**
	 * Terem {@link Room}.
	 */
	private Room room;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		
		this.room = new Room(1, "Nagy terem", 1000);
	}

	/**
	 * Test method for {@link github.Mozi.Model.Room#toString()}.
	 */
	@Test
	public void testToString() {
		
		assertEquals("1,Nagy terem,1000", this.room.toString());
	}

	/**
	 * Test method for {@link github.Mozi.Model.Room#equals(java.lang.Object)}.
	 */
	@Test
	public void testEqualsObject() {
		Room r = new Room(this.room.getId(), this.room.getName(), this.room.getSeats());
		
		assertTrue(this.room.equals(r));
	}

	/**
	 * Test method for {@link github.Mozi.Model.Room#getId()}.
	 */
	@Test
	public void testGetId() {
		assertEquals(1, this.room.getId());
	}

	/**
	 * Test method for {@link github.Mozi.Model.Room#setId(int)}.
	 */
	@Test
	public void testSetId() {
		this.room.setId(2);
		
		assertEquals(2, this.room.getId());
	}

	/**
	 * Test method for {@link github.Mozi.Model.Room#getName()}.
	 */
	@Test
	public void testGetName() {
		assertEquals("Nagy terem", this.room.getName());
	}

	/**
	 * Test method for {@link github.Mozi.Model.Room#setName(java.lang.String)}.
	 */
	@Test
	public void testSetName() {
		this.room.setName("Nem is olyan nagy");
		
		assertEquals("Nem is olyan nagy", this.room.getName());
	}

	/**
	 * Test method for {@link github.Mozi.Model.Room#getSeats()}.
	 */
	@Test
	public void testGetSeats() {
		assertEquals(1000, this.room.getSeats());
	}

	/**
	 * Test method for {@link github.Mozi.Model.Room#setSeats(int)}.
	 */
	@Test
	public void testSetSeats() {
		
		this.room.setSeats(999);
		assertEquals(999, this.room.getSeats());
	}

}
