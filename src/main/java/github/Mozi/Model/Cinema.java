package github.Mozi.Model;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

/**
 * A helyszín, mozinak az osztálya, fellelős az előadások tárolásáért, jegyár,
 * stb.
 * 
 * @author Bozsar Tamas
 *
 */
@XmlType(propOrder = { "id", "name", "address", "presentations", "ticketPrice" })
public class Cinema {

	/**
	 * A mozi azonosítója.
	 */
	private int id;
	/**
	 * A mozi neve.
	 */
	private String name;
	/**
	 * A mozi címe.
	 */
	private String address;
	/**
	 * A moziban lévő programok, előadások. {@link Presentation}
	 */
	private List<Presentation> presentations;
	/**
	 * A mozijegy alap ára egy előadáshoz.
	 */
	private double ticketPrice;

	/**
	 * Az Cinema osztály üres konstruktora.
	 */
	public Cinema() {
		super();
	}

	/**
	 * A Cinema osztály konstruktora.
	 * 
	 * @param id - Mozi azonosítója
	 *            
	 * @param name - Mozi neve
	 * 
	 * @param address - Mozi címe
	 *            
	 * @param presentations - Mozi előadásai
	 * 			
	 * @param ticketPrice - Mozi jegy ára
	 *            
	 */
	public Cinema(int id, String name, String address, List<Presentation> presentations, double ticketPrice) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.presentations = presentations;
		this.ticketPrice = ticketPrice;
	}

	/**
	 * Lekéri az osztály szöveges reprezentációját.
	 * 
	 * @return szöveges reprezentáció
	 */
	@Override
	public String toString() {
		return "Cinema [id=" + id + ", name=" + name + ", address=" + address + ", presentations=" + presentations
				+ ", ticketPrice=" + ticketPrice + "]";
	}

	/**
	 * Lekéri a mozi azonosítóját.
	 * 
	 * @return id - mozi azonosítója
	 */
	@XmlAttribute(name = "id")
	public int getId() {
		return id;
	}

	/**
	 * Beállítja a mozi azonosítóját.
	 * 
	 * @param id - mozi azonosító
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Lekéri a mozi nevét.
	 * 
	 * @return name - mozi neve
	 */
	public String getName() {
		return name;
	}

	/**
	 * Beállítja a mozi nevét.
	 * 
	 * @param name - mozi neve
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Lekéri a mozi címét.
	 * 
	 * @return address - mozi címe
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Beállítja a mozi címét.
	 * 
	 * @param address - mozi címe
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Lekéri a mozihoz tartozó előadásokat.
	 * 
	 * @return presentations - előadások listája {@link Presentation}
	 */
	@XmlElementWrapper(name = "presentations")
	@XmlElement(name = "presentation")
	public List<Presentation> getPresentations() {
		return presentations;
	}

	/**
	 * Beállítja a mozihoz tartozó előadásokat.
	 * 
	 * @param presentations - előadások listája {@link Presentation}
	 */
	public void setPresentations(List<Presentation> presentations) {
		this.presentations = presentations;
	}

	/**
	 * Lekéri a mozijegy árát.
	 * 
	 * @return ticketPrice - mozi jegyár
	 */
	public double getTicketPrice() {
		return ticketPrice;
	}

	/**
	 * Beállítja a mozijegy árát.
	 * 
	 * @param ticketPrice - mozi jegyár
	 */
	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

}
