/**
 * 
 */
package github.Mozi;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import github.Mozi.Model.Cinema;
import github.Mozi.Model.Movie;
import github.Mozi.Model.Presentation;
import github.Mozi.Model.Room;

/**
 * Mozi teszt osztály.
 * 
 * @author Bozsar Tamas
 *
 */
public class CinemaTest {

	/**
	 * Mozi {@link Cinema}
	 */
	private Cinema cinema;

	
	/**
	 * Lebegőpontos számok összehasonlítás esetén az engedélyezett eltérés.
	 */
	private static final double HIBA_SZAZALEK = 0.00001;

	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {

		ArrayList<Presentation> pres = new ArrayList<Presentation>();
		pres.add(new Presentation(1, LocalDateTime.now(), new Movie(), new Room(), 99, false));
		
		this.cinema = new Cinema(1, "Apolló", "Db", pres, 1000);

	}

	/**
	 * Test method for {@link github.Mozi.Model.Cinema#getId()}.
	 */
	@Test
	public void testGetId() {

		assertEquals(1, this.cinema.getId());
	}

	/**
	 * Test method for {@link github.Mozi.Model.Cinema#setId(int)}.
	 */
	@Test
	public void testSetId() {
		this.cinema.setId(2);

		assertEquals(2, this.cinema.getId());

	}

	/**
	 * Test method for {@link github.Mozi.Model.Cinema#getName()}.
	 */
	@Test
	public void testGetName() {

		assertEquals("Apolló", this.cinema.getName());
	}

	/**
	 * Test method for
	 * {@link github.Mozi.Model.Cinema#setName(java.lang.String)}.
	 */
	@Test
	public void testSetName() {

		this.cinema.setName("xyz");

		assertEquals("xyz", this.cinema.getName());
	}

	/**
	 * Test method for {@link github.Mozi.Model.Cinema#getAddress()}
	 * .
	 */
	@Test
	public void testGetAddress() {
		assertEquals("Db", this.cinema.getAddress());
	}

	/**
	 * Test method for
	 * {@link github.Mozi.Model.Cinema#setAddress(java.lang.String)}
	 * .
	 */
	@Test
	public void testSetAddress() {
		
		this.cinema.setAddress("Bp");
		assertEquals("Bp", this.cinema.getAddress());
	}

	

	/**
	 * Test method for
	 * {@link github.Mozi.Model.Cinema#getTicketPrice()}.
	 */
	@Test
	public void testGetTicketPrice() {
		assertEquals(1000.0, this.cinema.getTicketPrice(), HIBA_SZAZALEK);
	}

	/**
	 * Test method for
	 * {@link github.Mozi.Model.Cinema#setTicketPrice(double)}.
	 */
	@Test
	public void testSetTicketPrice() {

		this.cinema.setTicketPrice(111);
		
		assertEquals(111.0, this.cinema.getTicketPrice(), HIBA_SZAZALEK);
		
	}

}
