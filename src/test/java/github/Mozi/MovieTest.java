/**
 * 
 */
package github.Mozi;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

import github.Mozi.Model.Movie;
import github.Mozi.Model.Movie.MovieType;

/**
 * Film  teszt osztály.
 * 
 * @author Bozsar Tamas
 *
 */
public class MovieTest {

	/**
	 * Film {@link Movie}.
	 */
	private Movie movie;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {

		ArrayList<String> actors = new ArrayList<String>();

		actors.add("Luke");
		actors.add("Boba Fett");

		this.movie = new Movie(1, "Star Wars", 9999999, true, true, "magyar", MovieType.Kaland, actors);
	}

	/**
	 * Test method for {@link github.Mozi.Model.Movie#toString()}.
	 */
	@Test
	public void testToString() {

		String s = "1, Star Wars, 9999999, true, true, magyar, Kaland, [Luke, Boba Fett]";

		
		assertEquals(s, this.movie.toString());
	}

	/**
	 * Test method for {@link github.Mozi.Model.Movie#getId()}.
	 */
	@Test
	public void testGetId() {
		assertEquals(1, this.movie.getId());
	}

	/**
	 * Test method for {@link github.Mozi.Model.Movie#setId(int)}.
	 */
	@Test
	public void testSetId() {

		this.movie.setId(4);
		assertEquals(4, this.movie.getId());

	}

	/**
	 * Test method for {@link github.Mozi.Model.Movie#getTitle()}.
	 */
	@Test
	public void testGetTitle() {

		assertEquals("Star Wars", this.movie.getTitle());

	}

	/**
	 * Test method for
	 * {@link github.Mozi.Model.Movie#setTitle(java.lang.String)}.
	 */
	@Test
	public void testSetTitle() {

		this.movie.setTitle("LOTR");

		assertEquals("LOTR", this.movie.getTitle());
	}

	/**
	 * Test method for {@link github.Mozi.Model.Movie#getLength()}.
	 */
	@Test
	public void testGetLength() {

		assertEquals(9999999, this.movie.getLength());

	}

	/**
	 * Test method for
	 * {@link github.Mozi.Model.Movie#setLength(int)}.
	 */
	@Test
	public void testSetLength() {

		this.movie.setLength(10);

		assertEquals(10, this.movie.getLength());

	}

	/**
	 * Test method for {@link github.Mozi.Model.Movie#is_3d()}.
	 */
	@Test
	public void testIs_3d() {

		assertTrue(this.movie.is_3d());
	}

	/**
	 * Test method for
	 * {@link github.Mozi.Model.Movie#set_3d(boolean)}.
	 */
	@Test
	public void testSet_3d() {

		this.movie.set_3d(false);

		assertFalse(this.movie.is_3d());
	}

	/**
	 * Test method for {@link github.Mozi.Model.Movie#isSync()}.
	 */
	@Test
	public void testIsSync() {

		assertTrue(this.movie.isSync());

	}

	/**
	 * Test method for
	 * {@link github.Mozi.Model.Movie#setSync(boolean)}.
	 */
	@Test
	public void testSetSync() {
		this.movie.setSync(false);

		assertFalse(this.movie.isSync());
	}

	/**
	 * Test method for {@link github.Mozi.Model.Movie#getLanguage()}
	 * .
	 */
	@Test
	public void testGetLanguage() {
		assertEquals("magyar", this.movie.getLanguage());
	}

	/**
	 * Test method for
	 * {@link github.Mozi.Model.Movie#setLanguage(java.lang.String)}
	 * .
	 */
	@Test
	public void testSetLanguage() {

		this.movie.setLanguage("english");

		assertEquals("english", this.movie.getLanguage());
	}

	/**
	 * Test method for {@link github.Mozi.Model.Movie#getType()}.
	 */
	@Test
	public void testGetType() {
		assertEquals(MovieType.Kaland, this.movie.getType());
	}

	/**
	 * Test method for
	 * {@link github.Mozi.Model.Movie#setType(github.Mozi.Model.Movie.MovieType)}
	 * .
	 */
	@Test
	public void testSetType() {

		this.movie.setType(MovieType.Akció);

		assertEquals(MovieType.Akció, this.movie.getType());
	}

	/**
	 * Test method for {@link github.Mozi.Model.Movie#getActors()}.
	 */
	@Test
	public void testGetActors() {
		ArrayList<String> actors = new ArrayList<String>();

		actors.add("Luke");
		actors.add("Boba Fett");

		assertEquals(actors, this.movie.getActors());
	}

	/**
	 * Test method for
	 * {@link github.Mozi.Model.Movie#setActors(java.util.ArrayList)}
	 * .
	 */
	@Test
	public void testSetActors() {

		ArrayList<String> actors = new ArrayList<String>();

		actors.add("Luke");
		this.movie.getActors().remove(1);

		assertEquals(actors, this.movie.getActors());

	}

}
