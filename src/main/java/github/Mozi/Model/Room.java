package github.Mozi.Model;

/**
 * A mozi előadó terme.
 * 
 * @author Bozsar Tamas
 */
public class Room {

	/**
	 * Az előadó terem azonosítója.
	 */
	private int id;
	/**
	 * Az előadó terem neve.
	 */
	private String name;
	/**
	 * Az előadó terem szék/hely kapacitása.
	 */
	private int seats;

	/**
	 * Előadó terem üres konstruktora.
	 */
	public Room() {
		super();
	}

	/**
	 * Előadó terem konstruktora.
	 * 
	 * @param id - Terem azonosítója
	 *            
	 * @param name - Terem neve
	 *            
	 * @param seats - Terem ülőhely kapacitása
	 *            
	 */
	public Room(int id, String name, int seats) {
		super();
		this.id = id;
		this.name = name;
		this.seats = seats;
	}

	/**
	 * LEkéri az előadó terem szöveges reprezentációját.
	 * 
	 * @return szöveges reprezentáció
	 */
	@Override
	public String toString() {
		return id + "," + name + "," + seats;
	}

	/**
	 * A Room osztály példányaihoz egyedi hashcode-t rendel.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + seats;
		return result;
	}

	/**
	 * A Room osztály objektumainak összehasonlítására szolgál.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Room other = (Room) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (seats != other.seats)
			return false;
		return true;
	}

	// GETTERS - SETTERS
	/**
	 * Lekéri az előadó terem azonosítóját.
	 * 
	 * @return id - terem azonosítója
	 */
	public int getId() {
		return id;
	}

	/**
	 * Beállítja az előadó terem azonosítóját.
	 * 
	 * @param id - terem azonosítója
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Lekéri az előadó terem nevét.
	 * 
	 * @return name - terem neve
	 */
	public String getName() {
		return name;
	}

	/**
	 * Beállítja az előadó terem nevét.
	 * 
	 * @param name - terem neve
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Lekéri az előadó terem kapacitását.
	 * 
	 * @return seats - ülőhely kapacitás
	 */
	public int getSeats() {
		return seats;
	}

	/**
	 * Beállítja az előadó terem kapacitását.
	 * 
	 * @param seats - ülőhely kapacitás
	 */
	public void setSeats(int seats) {
		this.seats = seats;
	}

}
