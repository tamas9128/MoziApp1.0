package github.Mozi.Model;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A megrendelést lebonyolító osztály.
 * 
 * @author Bozsar Tamas
 */
@XmlType(propOrder = { "id", "customer", "price", "adult", "child", "student", "retirement", "cinema", "presentation",
		"foods", "extras" })
public class Purchase {

	/**
	 * Az osztály naplózásra használt objektum.
	 */
	private static final Logger logger = LoggerFactory.getLogger(Purchase.class);

		
	/**
	 * Felnőtt jegy kedvezmény szorzó érték.
	 */
	private static final double ADULT_PERSON_DISCOUNT = 1.0;
	/**
	 * Gyermek jegy kedvezmény szorzó érték.
	 */
	private static final double CHILD_PERSON_DISCOUNT = 0.5;
	/**
	 * Diák jegy kedvezmény szorzó érték.
	 */
	private static final double STUDENT_PERSON_DISCOUNT = 0.5;
	/**
	 * Nyugdíjas jegy kedvezmény szorzó érték.
	 */
	private static final double RETIREMENT_PERSON_DISCOUNT = 0.75;
	/**
	 * Csoportos felnőtt jegy kedvezmény szorzó érték.
	 */
	private static final double GROUP_DISCOUNT = 0.8;
	/**
	 * Csoportos kedvezményhez szükséges minimum érték.
	 */
	private static final double GROUP_NUMBER = 8;
	/**
	 * A nap első előadásaira járó kedvezmény.
	 */
	private static final double FIRST_REPRESENTATION_ON_DAY_DISCOUNT = 0.5;

	/**
	 * A megrendelés azonosítója.
	 */
	private String id;
	/**
	 * Felnőtt vendégek száma.
	 */
	private int adult;
	/**
	 * Gyermek vendégek száma.
	 */
	private int child;
	/**
	 * Diák vendégek száma.
	 */
	private int student;
	/**
	 * Nyugdíjas vendégek száma.
	 */
	private int retirement;
	/**
	 * Mozi objektum, melyik moziról van szó. {@link Cinema}
	 */
	private Cinema cinema;
	/**
	 * Ügyfél azonosítója.
	 */
	private String customer;
	/**
	 * A megrendelés összköltsége.
	 */
	private int price;

	/**
	 * Az előadás. {@link Presentation}}
	 */
	private Presentation presentation;
	/**
	 * Igényelt ételek listája. {@link Food}
	 */
	private Map<Food, Integer> foods;
	/**
	 * Igényelt extrák listája. {@link Extra}
	 */
	private Map<Extra, Integer> extras;

	/**
	 * A megrendelést lebonyolító osztály kontruktora.
	 */
	public Purchase() {
		super();
	}

	/**
	 * A megrendelést lebonyolító osztály kontruktora.
	 * 
	 * @param id - rendelés, vásárlás azonosító
	 * @param adult - teljes árú felnőtt jegyek száma
	 * @param child - gyermek jegyek száma
	 * @param student - diák jegyek száma
	 * @param retirement - nyugdíjas jegyek száma
	 * @param cinema - a mozi amelyben lesz az előadás
	 * @param customer - a vásárló neve
	 * @param presentation - a kiválasztott előadás
	 * @param foods - a megrendelt ételek
	 * @param extras - a megrendelt extra szolgáltatások
	 */
	public Purchase(String id, int adult, int child, int student, int retirement, Cinema cinema, String customer,
			Presentation presentation, Map<Food, Integer> foods, Map<Extra, Integer> extras) {
		super();

		this.id = id;
		this.adult = adult;
		this.child = child;
		this.student = student;
		this.retirement = retirement;
		this.cinema = cinema;
		this.customer = customer;
		this.presentation = presentation;
		this.foods = foods;
		this.extras = extras;
	}

	/**
	 * A megrendelés objektum szöveges reprezentációjával tér vissza.
	 * 
	 * @return szöveges reprezentáció {@link #Purchase}
	 */
	@Override
	public String toString() {
		return "Purchase [id=" + id + ", adult=" + adult + ", child=" + child + ", student=" + student + ", retirement="
				+ retirement + ", cinema=" + cinema + ", customer=" + customer + ", presentation=" + presentation
				+ ", foods=" + foods + ", extras=" + extras + "]";
	}

	/**
	 * Lekéri az ügyfél azonosítóját.
	 * 
	 * @return customer - ügyfél azonosító
	 */
	public String getCustomer() {
		return customer;
	}

	/**
	 * Beállítja az ügyfél azonosítóját.
	 * 
	 * @param customer - ügyfél azonosító
	 *            
	 */
	public void setCustomer(String customer) {
		this.customer = customer;
	}

	/**
	 * Lekéri a megrendelés azonosítóját.
	 * 
	 * @return id - megrendelés azonosító
	 */
	@XmlAttribute(name = "id")
	public String getId() {
		return id;
	}

	/**
	 * Beállítja a megrendelés azonosítóját.
	 * 
	 * @param id - megrendelés azonosító
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Lekéri a felnőtt/teljes árú jegyek számát.
	 * 
	 * @return adult - felnőtt jegyek száma
	 */
	public int getAdult() {
		return adult;
	}

	/**
	 * Beállítja a felnőtt jegyek számát.
	 * 
	 * @param adult - felnőtt jegyek száma
	 */
	public void setAdult(int adult) {
		this.adult = adult;
	}

	/**
	 * Lekéri a gyermek jegyek számát.
	 * 
	 * @return child - gyermek jegyek száma
	 */
	public int getChild() {
		return child;
	}

	/**
	 * Beállítja a gyermek jegyek számát.
	 * 
	 * @param child - gyermek jegyek száma
	 */
	public void setChild(int child) {
		this.child = child;
	}

	/**
	 * Lekéri a diák jegyek számát.
	 * 
	 * @return student - diák jegyek száma
	 */
	public int getStudent() {
		return student;
	}

	/**
	 * Beállítja a diák jegyek számát.
	 * 
	 * @param student - diák jegyek száma
	 */
	public void setStudent(int student) {
		this.student = student;
	}

	/**
	 * Lekéri a nyugdíjas jegyek számát.
	 * 
	 * @return retirement - nyugdíjas jegyek száma
	 */
	public int getRetirement() {
		return retirement;
	}

	/**
	 * Beállítja a nyugdíjas jegyek számát.
	 * 
	 * @param retirement - nyugdíjas jegyek száma
	 */
	public void setRetirement(int retirement) {
		this.retirement = retirement;
	}

	/**
	 * Lekéri, hogy melyik mozihoz tartozihoz kéri az ügyfél a rendelését.
	 * 
	 * @return cinema - mozi adatai {@link Cinema} 
	 */
	public Cinema getCinema() {
		return cinema;
	}

	/**
	 * Beállítja, hogy melyik mozihoz lesz a rendelés.
	 * 
	 * @param cinema - mozi adatai {@link Cinema} 
	 */
	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}

	/**
	 * Lekéri, hogy melyik előadáshoz lesz a rendelés.
	 * 
	 * @return presentation - előadás adatai {@link Presentation} 
	 */
	public Presentation getPresentation() {
		return presentation;
	}

	/**
	 * Beállítja, hogy melyik előadáshoz lesz a rendelés.
	 * 
	 * @param presentation - előadás adatai {@link Presentation} 
	 */
	public void setPresentation(Presentation presentation) {
		this.presentation = presentation;
	}

	/**
	 * Lekéri, hogy milyen ételek és azokból mennyi lett rendelve.
	 * 
	 * @return foods - ételek listája mennyiséggel {@link Food} , mennyiség
	 */
	public Map<Food, Integer> getFoods() {
		return foods;
	}

	/**
	 * Beállítja a rendelt ételeket és a mennyiséget hozzájuk.
	 * 
	 * @param foods - ételek listája mennyiséggel {@link Food} , mennyiség 
	 */
	public void setFoods(Map<Food, Integer> foods) {
		this.foods = foods;
	}

	/**
	 * Lekéri, hogy milyen extra dolgokat és azokból mennyi lett rendelve.
	 * 
	 * @return extras - extra dolgok listája mennyiséggel  {@link Extra} , darabszám
	 */
	public Map<Extra, Integer> getExtras() {
		return extras;
	}

	/**
	 * Beállítja a rendelt extrákat és a mennyiséget hozzájuk.
	 * 
	 * @param  extras - extra dolgok listája mennyiséggel  {@link Extra} , darabszám
	 */
	public void setExtras(Map<Extra, Integer> extras) {
		this.extras = extras;
	}

	/**
	 * Lekéri a megrendelés költségét.
	 * 
	 * @return price - rendelés értéke
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * Beállítja a megrendelés értékét.
	 * 
	 * @param price - rendelés értéke
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * A megrendeléshez generál egy azonosítót a megrendelő felhasználónevével
	 * és az adott pillanattal.
	 */
	public void generateId() {
		this.id = LocalDateTime.now().toString() + "_" + this.customer;
		
	}

	
	
	
	// Üzleti logika ...

	/**
	 * @return a vendégek összesített száma
	 */
	public int numberOfPersons() {

		return this.adult + this.student + this.child + this.retirement;
	}

	/**
	 * Legalább a GROUP_NUMBER értékével megegyező darab teljes árú jegy esetén
	 * jár a teljes árú jegyekre 20% kedvezmény.
	 * 
	 * @return jár-e a kedvezmény vagy nem
	 */
	public boolean isGroupDiscount() {

		return (this.adult >= GROUP_NUMBER) ? true : false;
	}

	/**
	 * Kiszámítja a teljes árú jegyek árát.
	 * 
	 * @return jegyek ára.
	 */
	public double calculateAdultTicketsPrice() {

		return (this.isGroupDiscount()) ? (this.cinema.getTicketPrice() * this.adult * GROUP_DISCOUNT)
				: (this.cinema.getTicketPrice() * this.adult * ADULT_PERSON_DISCOUNT);

	}

	/**
	 * Kiszámítja, hogy a diák jegyek mennyibe fognak kerülni.
	 * 
	 * @return diákjegyek összesített ára
	 */
	public double calculateStudentTicketsPrice() {

		return this.student * this.cinema.getTicketPrice() * STUDENT_PERSON_DISCOUNT;

	}

	/**
	 * Kiszámítja, hogy a gyermek jegyek mennyibe fognak kerülni.
	 * 
	 * @return gyemek jegyek összesített ára
	 */
	public double calculateChildTicketsPrice() {
		return this.child * this.cinema.getTicketPrice() * CHILD_PERSON_DISCOUNT;
	}

	/**
	 * Kiszámítja, hogy a nyugdíjas jegyek mennyibe fognak kerülni.
	 * 
	 * @return double nyugdíjas jegyek összesített ára
	 */
	public double calculateRetirementTicketsPrice() {
		return this.retirement * this.cinema.getTicketPrice() * RETIREMENT_PERSON_DISCOUNT;
	}

	/**
	 * Kiszámítja az extrák költségeit.
	 *
	 * @return int összeg
	 */
	public int calculateExtrasPrice() {
		if (this.extras.size() == 0)
			return 0;

		int result = 0;

		for (Entry<Extra, Integer> entry : this.extras.entrySet()) {

			result += entry.getKey().getPrice() * entry.getValue(); // ár *
																	// darab

		}

		return Math.round(result);
	}

	/**
	 * Kiszámítja a rendelt ételek és italok összesített árát.
	 * 
	 * @return ételek értéke
	 */
	public int calculateFoodsPrice() {
		if (this.foods.size() == 0)
			return 0;

		double result = 0;

		for (Entry<Food, Integer> entry : this.foods.entrySet()) {

			result += entry.getKey().getPrice() * entry.getKey().getSize().getNumVal() * entry.getValue(); // ár
																											// *
																											// méret
																											// *
																											// mennyiség
																											// darab

		}

		return (int) Math.round(result);
	}

	/**
	 * Kiszámítja a nap első előadása esetén a jegyek árát, ekkor nem vehető
	 * igénybe más kedvezmény.
	 * 
	 * @return jegyek ára
	 */
	public int calculateFirstPresentationOnDay() {
		return (int) (this.numberOfPersons() * this.cinema.getTicketPrice() * FIRST_REPRESENTATION_ON_DAY_DISCOUNT);
	}

	/**
	 * Kiszámítja az összes igénybe vett szolgáltatás árát.
	 * 
	 * @return szolgáltatások értéke
	 */
	public int calculatePrice() {

		logger.info("calculate price");
		
		double result = 0.0;

		if (this.presentation.isFirstPlayOnDay()) {
			logger.info("elso eloadas");
			result += this.calculateFirstPresentationOnDay();

		} else {
			logger.info("nem elso eloadas");
			result += this.calculateAdultTicketsPrice();
			result += this.calculateChildTicketsPrice();
			result += this.calculateStudentTicketsPrice();
			result += this.calculateRetirementTicketsPrice();

		}

		result += this.calculateExtrasPrice();

		result += this.calculateFoodsPrice();

		return (int) Math.round(result);

	}

	/**
	 * Véglegesíti a megrendelést, beállítattja annak azonosítóját és
	 * összköltségét.
	 * 
	 * @throws CinemaException
	 *             ha nincs elég hely az előadó teremben
	 */
	public void doPurchase() throws CinemaException {
		if (this.getPresentation().calculateNotReservedSeatNumber() < this.numberOfPersons()) {
			logger.info("nincs eleg hely az eloadasra a rendelesnel");
			throw new CinemaException("Nincs elég hely az előadásra!");
		}

		logger.info("megrendeles veglegesites");
		
		this.generateId();

		this.price = this.calculatePrice();

	}

}
