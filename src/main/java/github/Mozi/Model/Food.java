package github.Mozi.Model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 * A moziban rendelhető ételt és italt reprezentáljó osztály.
 * 
 * @author Bozsar Tamas
 *
 */
@XmlType(propOrder = { "id", "name", "price", "size", "type" })
public class Food {

	

	/**
	 * Az étel azonosítója.
	 */
	private int id;
	/**
	 * Az étel neve.
	 */
	private String name;
	/**
	 * Az étel ára.
	 */
	private double price;
	/**
	 * Az étel mérete.
	 */
	private FoodSize size;
	/**
	 * Az étel típusa.
	 */
	private FoodType type;

	/**
	 * Food üres konstruktor.
	 */
	public Food() {
		super();
	}

	/**
	 * Food konstruktor.
	 * 
	 * @param id - Étel azonosítója
	 *            
	 * @param name - Étel neve
	 *            
	 * @param price - Étel ára
	 *            
	 * @param size - Étel mérete {@link FoodSize}
	 * 
	 * @param type - Étel típusa {@link FoodType}
	 */
	public Food(int id, String name, double price, FoodSize size, FoodType type) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.size = size;
		this.type = type;
	}

	/**
	 * Lekéri az étel szöveges reprezentációját.
	 * 
	 * @return szöveges reprezentáció
	 */
	@Override
	public String toString() {
		return id + ", " + name + ", " + price + ", " + size + ", " + type;
	}

	/**
	 * Lekéri az étel azonosítóját.
	 * 
	 * @return id - azonosítója
	 */
	@XmlAttribute(name = "id")
	public int getId() {
		return id;
	}

	/**
	 * Beállítja az étel azonosítóját.
	 * 
	 * @param id - azonosítója
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Lekéri az étel nevét.
	 * 
	 * @return name - étel neve
	 */
	public String getName() {
		return name;
	}

	/**
	 * Beállítja az étel nevét.
	 * 
	 * @param name - étel neve
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Lekéri az étel árát.
	 * 
	 * @return price - étel ára
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Beállítja az étel árát.
	 * 
	 * @param price - étel ára
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * Lekéri az étel méretét.
	 * 
	 * @return size - étel mérete {@link FoodSize}
	 */
	public FoodSize getSize() {
		return size;
	}

	/**
	 * Beállítja az étel méretét.
	 * 
	 * @param size - étel mérete {@link FoodSize}
	 */
	public void setSize(FoodSize size) {
		this.size = size;
	}

	/**
	 * Lekéri az étel állagát.
	 * 
	 * @return type - étel állaga {@link FoodType}
	 */
	public FoodType getType() {
		return type;
	}

	/**
	 * Beállítja az étel állagát.
	 * 
	 * @param type - étel állaga {@link FoodType}
	 */
	public void setType(FoodType type) {
		this.type = type;
	}

	/**
	 * Food objektumokhoz hashCode-ot rendel.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((size == null) ? 0 : size.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	/**
	 * A Food osztály objektumainak összehasonlítására szolgál.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Food other = (Food) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (size != other.size)
			return false;
		if (type != other.type)
			return false;
		return true;
	}

}
