package github.Mozi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import github.Mozi.Model.Extra;

/**
 * 
 * Extra teszt osztálya.
 * 
 * @author Bozsar Tamas
 *
 */
public class ExtraTest {

	private Extra extra;
	
	/**
	 * @throws java.lang.Exception - kivétel
	 */
	@Before
	public void setUp() throws Exception {
		this.extra = new Extra(1, "Papucs", 99);
	}


	/**
	 * Test method for {@link github.Mozi.Model.Extra#toString()}.
	 */
	@Test
	public void testToString() {
		
		assertEquals("1,Papucs,99 Ft.", this.extra.toString());
	}

	/**
	 * Test method for {@link github.Mozi.Model.Extra#getId()}.
	 */
	@Test
	public void testGetId() {
		
		assertEquals(1, this.extra.getId());
	
	}

	/**
	 * Test method for {@link github.Mozi.Model.Extra#setId(int)}.
	 */
	@Test
	public void testSetId() {
		
		this.extra.setId(3);
		
		assertEquals(3, this.extra.getId());
	}

	/**
	 * Test method for {@link github.Mozi.Model.Extra#getName()}.
	 */
	@Test
	public void testGetName() {
		
		assertEquals("Papucs", this.extra.getName());
	}

	/**
	 * Test method for {@link github.Mozi.Model.Extra#setName(java.lang.String)}.
	 */
	@Test
	public void testSetName() {
		this.extra.setName("Párna");
		
		assertEquals("Párna", this.extra.getName());
	}

	/**
	 * Test method for {@link github.Mozi.Model.Extra#getPrice()}.
	 */
	@Test
	public void testGetPrice() {
		
		assertEquals(99, this.extra.getPrice());
	}

	/**
	 * Test method for {@link github.Mozi.Model.Extra#setPrice(int)}.
	 */
	@Test
	public void testSetPrice() {
		
		this.extra.setPrice(100);
		
		assertEquals(100, this.extra.getPrice());
		
	}

	/**
	 * Test method for {@link github.Mozi.Model.Extra#equals(java.lang.Object)}.
	 */
	@Test
	public void testEqualsObject() {
		Extra e = new Extra(this.extra.getId(), this.extra.getName(), this.extra.getPrice());
		
		assertTrue(this.extra.equals(e));
	}

}
