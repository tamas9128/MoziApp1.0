package github.Mozi;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import github.Mozi.Model.Cinema;
import github.Mozi.Model.Extra;
import github.Mozi.Model.Food;
import github.Mozi.Model.FoodSize;
import github.Mozi.Model.FoodType;
import github.Mozi.Model.Presentation;
import github.Mozi.Model.Purchase;

/**
 * A vásárlást, rendelést lebonyolító osztály tesztje.
 * 
 * @author Bozsar Tamas
 *
 */
public class PurchaseTest {

	/**
	 * Megrendelés {@link Purchase}.
	 */
	private Purchase purchase;

	/**
	 * Ételek listája mennyiséggel {@link Food}.
	 */
	private static Map<Food, Integer> foods;
	/**
	 * Extrák listája mennyiséggel {@link Extra}.
	 */
	private static Map<Extra, Integer> extras;

	/**
	 * Lebegőpontos számok összehasonlítás esetén az engedélyezett eltérés.
	 */
	private static final double HIBA_SZAZALEK = 0.00001;

	/**
	 * @throws java.lang.Exception
	 *             - kivétel
	 */
	@Before
	public void setUp() throws Exception {

		Cinema cinema = new Cinema();
		cinema.setTicketPrice(1000);

		Presentation present = new Presentation();
		present.setFirstPlayOnDay(false);

		foods = new HashMap<Food, Integer>();
		foods.put(new Food(1, "Taco", 100, FoodSize.MEDIUM, FoodType.SOLID), 3);
		foods.put(new Food(1, "Taco", 100, FoodSize.EXTRA_BIG, FoodType.SOLID), 3);
		foods.put(new Food(1, "Taco", 100, FoodSize.SMALL, FoodType.SOLID), 3);
		foods.put(new Food(2, "Popcorn", 50, FoodSize.MEDIUM, FoodType.SOLID), 5);

		foods.put(new Food(3, "Cola", 100, FoodSize.MEDIUM, FoodType.LIQUID), 3);
		foods.put(new Food(3, "Cola", 100, FoodSize.EXTRA_BIG, FoodType.LIQUID), 5);

		extras = new HashMap<Extra, Integer>();

		extras.put(new Extra(1, "3d szemüveg", 100), 3);
		extras.put(new Extra(2, "Papucs", 50), 2);

		this.purchase = new Purchase("1", 0, 0, 0, 0, cinema, "Gipsz_Jakab", present, foods, extras);
	}

	/**
	 * Test method for {@link Purchase#numberOfPersons()}.
	 */
	@Test
	public void testNumberOfPersons() {

		assertEquals(0, this.purchase.numberOfPersons());

		this.purchase.setAdult(2);

		assertEquals(2, this.purchase.numberOfPersons());

		this.purchase.setStudent(3);
		assertEquals(5, this.purchase.numberOfPersons());

		this.purchase.setChild(5);
		assertEquals(10, this.purchase.numberOfPersons());

		this.purchase.setRetirement(3);
		assertEquals(13, this.purchase.numberOfPersons());
	}

	/**
	 * Test method for {@link Purchase#isGroupDiscount()}.
	 */
	@Test
	public void testIsGroupDiscount() {

		assertEquals(false, this.purchase.isGroupDiscount());

		this.purchase.setAdult(7);
		assertEquals(false, this.purchase.isGroupDiscount());

		this.purchase.setAdult(8);
		assertEquals(true, this.purchase.isGroupDiscount());

		this.purchase.setAdult(9);
		assertEquals(true, this.purchase.isGroupDiscount());

	}

	/**
	 * Test method for {@link Purchase#calculateAdultTicketsPrice()}.
	 */
	@Test
	public void testCalculateAdultTicketsPrice() {

		assertEquals(0.0, this.purchase.calculateAdultTicketsPrice(), HIBA_SZAZALEK);

		this.purchase.setAdult(5);

		assertEquals(5000.0, this.purchase.calculateAdultTicketsPrice(), HIBA_SZAZALEK);

		this.purchase.setAdult(8);

		assertEquals(6400.0, this.purchase.calculateAdultTicketsPrice(), HIBA_SZAZALEK);

	}

	/**
	 * Test method for {@link Purchase#calculateStudentTicketsPrice()}.
	 */
	@Test
	public void testCalculateStudentTicketsPrice() {

		assertEquals(0.0, this.purchase.calculateStudentTicketsPrice(), HIBA_SZAZALEK);

		this.purchase.setStudent(5);

		assertEquals(2500.0, this.purchase.calculateStudentTicketsPrice(), HIBA_SZAZALEK);

		this.purchase.setStudent(8);

		assertEquals(4000.0, this.purchase.calculateStudentTicketsPrice(), HIBA_SZAZALEK);

	}

	/**
	 * Test method for {@link Purchase#calculateChildTicketsPrice()}.
	 */
	@Test
	public void testCalculateChildTicketsPrice() {

		assertEquals(0.0, this.purchase.calculateChildTicketsPrice(), HIBA_SZAZALEK);

		this.purchase.setChild(5);

		assertEquals(2500.0, this.purchase.calculateChildTicketsPrice(), HIBA_SZAZALEK);

		this.purchase.setChild(8);

		assertEquals(4000.0, this.purchase.calculateChildTicketsPrice(), HIBA_SZAZALEK);

	}

	/**
	 * Test method for {@link Purchase#calculateRetirementTicketsPrice()}.
	 */
	@Test
	public void testCalculateRetirementTicketsPrice() {

		assertEquals(0.0, this.purchase.calculateRetirementTicketsPrice(), HIBA_SZAZALEK);

		this.purchase.setRetirement(5);

		assertEquals(3750.0, this.purchase.calculateRetirementTicketsPrice(), HIBA_SZAZALEK);

		this.purchase.setRetirement(8);

		assertEquals(6000.0, this.purchase.calculateRetirementTicketsPrice(), HIBA_SZAZALEK);

	}

	/**
	 * Test method for {@link Purchase#calculateExtrasPrice()}.
	 */
	@Test
	public void testCalculateExtrasPrice() {

		assertEquals(400, this.purchase.calculateExtrasPrice());

		extras.put(new Extra(3, "X", 200), 3);

		assertEquals(1000, this.purchase.calculateExtrasPrice());

		extras.clear();

		assertEquals(0, this.purchase.calculateExtrasPrice());

	}

	/**
	 * Test method for {@link Purchase#calculateFoodsPrice()}.
	 */
	@Test
	public void testCalculateFoodsPrice() {

		assertEquals(2600, this.purchase.calculateFoodsPrice());

		foods.put(new Food(4, "X", 300, FoodSize.MEDIUM, FoodType.SOLID), 2);

		assertEquals(3200, this.purchase.calculateFoodsPrice());

		foods.put(new Food(4, "X", 300, FoodSize.BIG, FoodType.SOLID), 2);

		assertEquals(4100, this.purchase.calculateFoodsPrice());

		foods.clear();

		assertEquals(0, this.purchase.calculateFoodsPrice());

	}

	/**
	 * Test method for {@link Purchase#calculateFirstPresentationOnDay()}.
	 */
	@Test
	public void testCalculateFirstPresentationOnDay() {

		assertEquals(0, this.purchase.calculateFirstPresentationOnDay(), HIBA_SZAZALEK);

		this.purchase.setAdult(2);

		// 2000 helyett, mert az első előadásra 50% kedvezmény jár.
		assertEquals(1000, this.purchase.calculateFirstPresentationOnDay(), HIBA_SZAZALEK);

		this.purchase.setChild(5);
		assertEquals(3500, this.purchase.calculateFirstPresentationOnDay(), HIBA_SZAZALEK);

		this.purchase.setStudent(2);
		assertEquals(4500, this.purchase.calculateFirstPresentationOnDay(), HIBA_SZAZALEK);

		this.purchase.setRetirement(3);
		assertEquals(6000, this.purchase.calculateFirstPresentationOnDay(), HIBA_SZAZALEK);

	}

	/**
	 * Test method for {@link Purchase#calculatePrice()}.
	 */
	@Test
	public void testCalculatePrice() {
		// 0 ember 0ft és 2400ft étel és 600ft extra értékben
		assertEquals(3000, this.purchase.calculatePrice());

		this.purchase.setAdult(1);
		assertEquals(4000, this.purchase.calculatePrice());

		this.purchase.getPresentation().setFirstPlayOnDay(true);

		assertEquals(3500, this.purchase.calculatePrice());

		this.purchase.getPresentation().setFirstPlayOnDay(false);

		this.purchase.setStudent(5);

		assertEquals(6500, this.purchase.calculatePrice());

		this.purchase.setChild(3);

		assertEquals(8000, this.purchase.calculatePrice());

		this.purchase.setRetirement(2);

		assertEquals(9500, this.purchase.calculatePrice());

		this.purchase.getPresentation().setFirstPlayOnDay(true);

		assertEquals(8500, this.purchase.calculatePrice());

	}

	/**
	 * Test method for
	 * {@link github.Mozi.Model.Purchase#getCustomer()}.
	 */
	@Test
	public void testGetCustomer() {
		assertEquals("Gipsz_Jakab", this.purchase.getCustomer());
	}

	/**
	 * Test method for
	 * {@link github.Mozi.Model.Purchase#setCustomer(java.lang.String)}
	 * .
	 */
	@Test
	public void testSetCustomer() {

		this.purchase.setCustomer("Teszt Elek");

		assertEquals("Teszt Elek", this.purchase.getCustomer());
	}

	/**
	 * Test method for {@link github.Mozi.Model.Purchase#getId()}.
	 */
	@Test
	public void testGetId() {
		assertEquals("1", this.purchase.getId());
	}

	/**
	 * Test method for
	 * {@link github.Mozi.Model.Purchase#setId(java.lang.String)}.
	 */
	@Test
	public void testSetId() {

		this.purchase.setId("79");

		assertEquals("79", this.purchase.getId());
	}

	/**
	 * Test method for {@link github.Mozi.Model.Purchase#getAdult()}
	 * .
	 */
	@Test
	public void testGetAdult() {
		assertEquals(0, this.purchase.getAdult());
	}

	/**
	 * Test method for
	 * {@link github.Mozi.Model.Purchase#setAdult(int)}.
	 */
	@Test
	public void testSetAdult() {

		this.purchase.setAdult(3);

		assertEquals(3, this.purchase.getAdult());
	}

	/**
	 * Test method for {@link github.Mozi.Model.Purchase#getChild()}
	 * .
	 */
	@Test
	public void testGetChild() {

		assertEquals(0, this.purchase.getChild());
	}

	/**
	 * Test method for
	 * {@link github.Mozi.Model.Purchase#setChild(int)}.
	 */
	@Test
	public void testSetChild() {
		this.purchase.setChild(4);

		assertEquals(4, this.purchase.getChild());
	}

	/**
	 * Test method for
	 * {@link github.Mozi.Model.Purchase#getStudent()}.
	 */
	@Test
	public void testGetStudent() {

		assertEquals(0, this.purchase.getStudent());
	}

	/**
	 * Test method for
	 * {@link github.Mozi.Model.Purchase#setStudent(int)}.
	 */
	@Test
	public void testSetStudent() {

		this.purchase.setStudent(2);
		assertEquals(2, this.purchase.getStudent());
	}

	/**
	 * Test method for
	 * {@link github.Mozi.Model.Purchase#getRetirement()}.
	 */
	@Test
	public void testGetRetirement() {
		assertEquals(0, this.purchase.getRetirement());
	}

	/**
	 * Test method for
	 * {@link github.Mozi.Model.Purchase#setRetirement(int)}.
	 */
	@Test
	public void testSetRetirement() {

		this.purchase.setRetirement(1);
		assertEquals(1, this.purchase.getRetirement());
	}


	/**
	 * Test method for {@link github.Mozi.Model.Purchase#getFoods()}
	 * .
	 */
	@Test
	public void testGetFoods() {
		assertEquals(foods, this.purchase.getFoods());
	}

	/**
	 * Test method for
	 * {@link github.Mozi.Model.Purchase#setFoods(java.util.Map)}.
	 */
	@Test
	public void testSetFoods() {
		Map<Food, Integer> f = new HashMap<Food, Integer>(foods);
		f.put(new Food(1, "Tacoo", 1, FoodSize.MEDIUM, FoodType.SOLID), 2);
		
		this.purchase.setFoods(f);
		
		assertEquals(f, this.purchase.getFoods());
	}

	/**
	 * Test method for
	 * {@link github.Mozi.Model.Purchase#getExtras()}.
	 */
	@Test
	public void testGetExtras() {
		
		assertEquals(extras, this.purchase.getExtras());
		
		
	}

	/**
	 * Test method for
	 * {@link github.Mozi.Model.Purchase#setExtras(java.util.Map)}.
	 */
	@Test
	public void testSetExtras() {
		Map<Extra, Integer> f = new HashMap<Extra, Integer>(extras);
		f.put(new Extra(1, "Párna", 1), 2);
		
		this.purchase.setExtras(f);
		
		assertEquals(f, this.purchase.getExtras());
		
	}



}
