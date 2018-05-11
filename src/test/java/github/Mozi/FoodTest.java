/**
 * 
 */
package github.Mozi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import github.Mozi.Model.Food;
import github.Mozi.Model.FoodSize;
import github.Mozi.Model.FoodType;

/**
 * Ételt teszt osztály.
 * 
 * @author Bozsar Tamas
 *
 */
public class FoodTest {

	/**
	 * Étel, Food {@link Food}.
	 */
	private Food food;
	
	/**
	 * Lebegőpontos számok összehasonlítás esetén az engedélyezett eltérés.
	 */
	private static final double HIBA_SZAZALEK = 0.00001;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {

		this.food = new Food(1, "Tacoo", 99, FoodSize.MEDIUM, FoodType.SOLID);
	}

	/**
	 * Test method for {@link github.Mozi.Model.Food#toString()}.
	 */
	@Test
	public void testToString() {

	
		assertEquals("1, Tacoo, 99.0, MEDIUM, SOLID", this.food.toString());
	}

	/**
	 * Test method for {@link github.Mozi.Model.Food#getId()}.
	 */
	@Test
	public void testGetId() {
		assertEquals(1, this.food.getId());
	}

	/**
	 * Test method for {@link github.Mozi.Model.Food#setId(int)}.
	 */
	@Test
	public void testSetId() {

		this.food.setId(3);

		assertEquals(3, this.food.getId());
	}

	/**
	 * Test method for {@link github.Mozi.Model.Food#getName()}.
	 */
	@Test
	public void testGetName() {

		assertEquals("Tacoo", this.food.getName());
	}

	/**
	 * Test method for
	 * {@link github.Mozi.Model.Food#setName(java.lang.String)}.
	 */
	@Test
	public void testSetName() {
		this.food.setName("Nacho");

		assertEquals("Nacho", this.food.getName());

	}

	/**
	 * Test method for {@link github.Mozi.Model.Food#getPrice()}.
	 */
	@Test
	public void testGetPrice() {
		
		assertEquals(99, this.food.getPrice(), HIBA_SZAZALEK);
	}

	/**
	 * Test method for
	 * {@link github.Mozi.Model.Food#setPrice(double)}.
	 */
	@Test
	public void testSetPrice() {
		
		this.food.setPrice(100.34);

		assertEquals(100.34, this.food.getPrice(), HIBA_SZAZALEK);
	}

	/**
	 * Test method for {@link github.Mozi.Model.Food#getSize()}.
	 */
	@Test
	public void testGetSize() {

		assertEquals(FoodSize.MEDIUM, this.food.getSize());
	}

	/**
	 * Test method for
	 * {@link github.Mozi.Model.Food#setSize(github.Mozi.Model.FoodSize)}
	 * .
	 */
	@Test
	public void testSetSize() {

		this.food.setSize(FoodSize.BIG);
		
		assertEquals(FoodSize.BIG, this.food.getSize());
	}

	/**
	 * Test method for {@link github.Mozi.Model.Food#getType()}.
	 */
	@Test
	public void testGetType() {
		assertEquals(FoodType.SOLID, this.food.getType());
	}

	/**
	 * Test method for
	 * {@link github.Mozi.Model.Food#setType(github.Mozi.Model.FoodType)}
	 * .
	 */
	@Test
	public void testSetType() {
		this.food.setType(FoodType.LIQUID);
		
		assertEquals(FoodType.LIQUID, this.food.getType());
	}

	/**
	 * Test method for
	 * {@link github.Mozi.Model.Food#equals(java.lang.Object)}.
	 */
	@Test
	public void testEqualsObject() {
		Food f = new Food(this.food.getId(), this.food.getName(), this.food.getPrice(), this.food.getSize(), this.food.getType());
		
		assertTrue(this.food.equals(f));
	}

}
