package github.Mozi.Model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 * Az Extra-kat reprezentáló osztály. A moziban lehet kérni különböző bónusz
 * eszközöket, amelyekért fizetni kell.
 * 
 * @author Bozsar Tamas
 *
 */
@XmlType(propOrder = { "id", "name", "price" })
public class Extra {

	/**
	 *
	 * Az Extra azonosítója.
	 */
	private int id;

	/**
	 * Az Extra elnevezése.
	 */
	private String name;

	/**
	 * Az Extra ára.
	 */
	private int price;

	/**
	 * Extra üres konstruktora.
	 */
	public Extra() {
		super();
	}

	/**
	 * Extra konstruktora.
	 * 
	 * @param id - Extra azonosítója
	 *            
	 * @param name - Extra neve
	 *            
	 * @param price - Extra ára
	 *            
	 */
	public Extra(int id, String name, int price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

	/**
	 * Lekéri az Extra szöveges reprezentációját.
	 */
	@Override
	public String toString() {
		return id + "," + name + "," + price + " Ft.";
	}

	/**
	 * Lekéri az Extra azonosítóját.
	 * 
	 * @return id - extra azonosítója
	 */
	@XmlAttribute(name = "id")
	public int getId() {
		return id;
	}

	/**
	 * Beállítja az Extra azonosítóját.
	 * 
	 * @param id - extra azonosítója
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Lekéri az Extra nevét.
	 * 
	 * @return name - extra neve
	 */
	public String getName() {
		return name;
	}

	/**
	 * Beállítja az Extra nevét.
	 * 
	 * @param name - extra neve
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Lekéri az Extra árát.
	 * 
	 * @return price - extra ára
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * Beállítja az Extra árát.
	 * 
	 * @param price - extra ára
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * Extra objektumokhoz hashCode-ot rendel.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + price;
		return result;
	}

	/**
	 * Az Extra osztály objektumainak összehasonlítására szolgál.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Extra other = (Extra) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price != other.price)
			return false;
		return true;
	}

}
