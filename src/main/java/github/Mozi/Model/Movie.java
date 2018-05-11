package github.Mozi.Model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

/**
 * A filmet , amelyet a mozi vetít és az ügyfelek megnéznek.
 * 
 * @author Bozsar Tamas
 *
 */
@XmlType(propOrder = { "id", "title", "length", "_3d", "sync", "language", "type", "actors" })
public class Movie {

	/**
	 * Film műfajok.
	 * 
	 * @author ngg
	 *
	 */
	public enum MovieType {
		/**
		 * Akció film műfaj, izgalmas.
		 */
		Akció,
		/**
		 * Vígjáték műfaj, vicces.
		 */
		Vígjáték,
		/**
		 * Kaland film műfaj, ifjúsági.
		 */
		Kaland,
		/**
		 * Romantikus műfaj a szerelmeseknek.
		 */
		Romantikus;
	}

	/**
	 * A film azonosítója.
	 */
	private int id;
	/**
	 * A film címe.
	 */
	private String title;
	/**
	 * A film hossza.
	 */
	private int length;
	/**
	 * 3Ds-e a film.
	 */
	private boolean _3d;
	/**
	 * Szinkronizált-e a film.
	 */
	private boolean sync;
	/**
	 * A film nyelve.
	 */
	private String language;
	/**
	 * A film típusa, fajtája. {@link MovieType}
	 */
	private MovieType type;
	/**
	 * A filmben szereplő híresebb színészek.
	 */
	private ArrayList<String> actors;

	/**
	 * A film üres konstruktora.
	 */
	public Movie() {
		super();
	}

	/**
	 * A film osztály konstruktora.
	 * 
	 * @param id
	 *            - Film azonosítója
	 * 
	 * @param title
	 *            - Film címe
	 * 
	 * @param length
	 *            - Film hossza
	 * 
	 * @param _3d
	 *            - Film 3dimenziós-e
	 * 
	 * @param sync
	 *            - Film szinkronziált-e
	 * 
	 * @param language
	 *            - Film nyelve
	 * 
	 * @param type
	 *            - Fim műfaja {@link MovieType}
	 * 
	 * @param actors
	 *            - Filmben szereplő színészek
	 * 
	 */
	public Movie(int id, String title, int length, boolean _3d, boolean sync, String language, MovieType type,
			ArrayList<String> actors) {
		super();
		this.id = id;
		this.title = title;
		this.length = length;
		this._3d = _3d;
		this.sync = sync;
		this.language = language;
		this.type = type;
		this.actors = actors;
	}

	/**
	 * Lekéri a film szöveges reprezentációját.
	 * 
	 * @return szöveges reprezentáció
	 */
	@Override
	public String toString() {
		return id + ", " + title + ", " + length + ", " + _3d + ", " + sync + ", " + language + ", " + type + ", "
				+ actors;
	}

	/**
	 * Vissza tér a film hosszával szöveges változtaban, hh:mm:ss formátumban.
	 * 
	 * @return String időtartam
	 */
	public String formatLength() {

		int length = this.length;
		int hour = (int) Math.floor(length / 60);
		length = length - (hour * 60);
		int minute = (int) Math.floor(length / 60);
		int sec = length - (minute * 60);

		return hour + ":" + minute + ":" + sec;
	}

	// GETTERS - SETTERS ...
	/**
	 * Lekéri a film azonosítóját.
	 * 
	 * @return id - azonosító
	 */
	@XmlAttribute(name = "id")
	public int getId() {
		return id;
	}

	/**
	 * Beállítja a film azonosítóját.
	 * 
	 * @param id
	 *            - azonosító
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Lekéri a film címét.
	 * 
	 * @return title - cím
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Beállítja a film címét.
	 * 
	 * @param title
	 *            - cím
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Lekéri a film hosszát másodpercben.
	 * 
	 * @return length - időtartam
	 */
	public int getLength() {
		return length;
	}

	/**
	 * Beállítja a film hosszát másodpercben.
	 * 
	 * @param length
	 *            - időtartam
	 */
	public void setLength(int length) {
		this.length = length;
	}

	/**
	 * Lekéri, hogy a film 3D-s -e.
	 * 
	 * @return _3d - igaz/hamis
	 */
	public boolean is_3d() {
		return _3d;
	}

	/**
	 * Beállítja, hogy a film 3D-s -e.
	 * 
	 * @param _3d
	 *            - igaz/hamis
	 */
	public void set_3d(boolean _3d) {
		this._3d = _3d;
	}

	/**
	 * Lekéri ,hogy a film szinkronizált-e.
	 * 
	 * @return sync - igaz/hamis
	 */
	public boolean isSync() {
		return sync;
	}

	/**
	 * Beállítja, hogy a film szinkronizált-e.
	 * 
	 * @param sync
	 *            - igaz/hamis
	 */
	public void setSync(boolean sync) {
		this.sync = sync;
	}

	/**
	 * Lekéri a film nyelvét.
	 * 
	 * @return language nyelv
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * Beállítja a film nyelvét.
	 * 
	 * @param language
	 *            - nyelv
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * Lekéri a film típusát, műfaját.
	 * 
	 * @return type - műfaj {@link MovieType}
	 */
	public MovieType getType() {
		return type;
	}

	/**
	 * Beállítja a film típusát, műfaját.
	 * 
	 * @param type
	 *            - műfaj {@link MovieType}
	 */
	public void setType(MovieType type) {
		this.type = type;
	}

	/**
	 * Lekér ia filmben szereplő színészeket.
	 * 
	 * @return actors - színészek névsora
	 */
	@XmlElementWrapper(name = "actors")
	@XmlElement(name = "actor")
	public ArrayList<String> getActors() {
		return actors;
	}

	/**
	 * Beállítja a filmben szereplő színészeket.
	 * 
	 * @param actors
	 *            - színészek névsora
	 */
	public void setActors(ArrayList<String> actors) {
		this.actors = actors;
	}

}
