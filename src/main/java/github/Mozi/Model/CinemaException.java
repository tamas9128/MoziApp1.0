package github.Mozi.Model;

/**
 * A Cinema alkalmazás személyre szabott kivétel osztálya.
 * 
 * @author Bozsar Tamas
 *
 */
public class CinemaException extends Exception {

	/**
	 * Az osztály véletlenszerűen generált azonosítója.
	 */
	private static final long serialVersionUID = -7181608901159552899L;

	/**
	 * A kivétel üzenete.
	 */
	private String message;

	/**
	 * Kivétel osztály kontruktora.
	 * 
	 * @param message - hiba üzenet
	 */
	public CinemaException(String message) {
		super();
		this.message = message;
	}

	/**
	 * Lekéri a kivétel szöveges üzenetét.
	 */
	@Override
	public String toString() {
		return "Kivétel: " + message;
	}

}
