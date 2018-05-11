package github.Mozi.Model;

import java.time.LocalDateTime;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import github.Mozi.Util.LocalDateTimeAdapter;

/**
 * Előadások, amelyeket a mozi hírdet meg.
 * 
 * @author Bozsar Tamas
 * 
 */
@XmlType(propOrder = { "id", "time", "movie", "room", "reservedSeats", "firstPlayOnDay" })
public class Presentation implements Comparable<Presentation> {

	/**
	 * Az előadás azonosója.
	 */

	private int id;

	/**
	 * Az előadás kezdete.
	 */
	private LocalDateTime time;

	/**
	 * A film {@link Movie}.
	 */
	private Movie movie;

	/**
	 * Az előadás helye {@link Room}.
	 */
	private Room room;

	/**
	 * Foglalt ülőhelyek száma.
	 */
	private int reservedSeats;

	/**
	 * Első előadás a filmből az adott napon.
	 */
	private boolean firstPlayOnDay;

	/**
	 * Előadás üres kontruktora.
	 */
	public Presentation() {
		super();
	}

	/**
	 * Előadás konstruktor.
	 * 
	 * @param id
	 *            - Előadás azonosítója
	 * 
	 * @param time
	 *            - Előadás kezdeti ideje
	 * 
	 * @param movie
	 *            - Előadáson vetített film
	 * 
	 * @param room
	 *            - Előadás heyszíne
	 * 
	 * @param reservedSeats
	 *            - Foglalt helyek száma
	 * 
	 * @param firstPlayOnDay
	 *            - Első vetítés-e
	 * 
	 */
	public Presentation(int id, LocalDateTime time, Movie movie, Room room, int reservedSeats, boolean firstPlayOnDay) {
		super();
		this.id = id;
		this.time = time;
		this.movie = movie;
		this.room = room;
		this.reservedSeats = reservedSeats;
		this.firstPlayOnDay = firstPlayOnDay;
	}

	/**
	 * Lekéri az előadás szöveges reprezentációját.
	 * 
	 * @return szöveges reprezentáció
	 */
	@Override
	public String toString() {
		return id + ", " + time + ", " + movie + ", " + room + ", " + reservedSeats + ", " + firstPlayOnDay;
	}

	/**
	 * Lekéri az előadás azonosítóját.
	 * 
	 * @return id - azonosító
	 */
	@XmlAttribute(name = "id")
	public int getId() {
		return id;
	}

	/**
	 * Beállítja az előadás azonosítóját.
	 * 
	 * @param id
	 *            - azonosító
	 * 
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Lekéri az előadás időpontját.
	 * 
	 * @return time - időpont
	 */
	@XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
	public LocalDateTime getTime() {
		return time;
	}

	/**
	 * Beállítja az előadás időpontját.
	 * 
	 * @param time
	 *            - időpont
	 */
	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	/**
	 * Lekéri az előadáson vetített filmet.
	 * 
	 * @return movie - film {@link Movie}
	 */
	public Movie getMovie() {
		return movie;
	}

	/**
	 * Beállítja az előadáson vetített filmet.
	 * 
	 * @param movie
	 *            - film {@link Movie}
	 */
	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	/**
	 * Lekéri az előadás helyét.
	 * 
	 * @return rootm - terem {@link Room}
	 */
	public Room getRoom() {
		return room;
	}

	/**
	 * Beállítja az előadás helyét.
	 * 
	 * @param room
	 *            - terem {@link Room}
	 */
	public void setRoom(Room room) {
		this.room = room;
	}

	/**
	 * Lekéri, hogy szék, hely van lefoglalva az előadásra.
	 * 
	 * @return reservedSeats - foglalt helyek száma
	 */
	public int getReservedSeats() {
		return reservedSeats;
	}

	/**
	 * Beállítja a foglalt helyek számát az előadáshoz.
	 * 
	 * @param reservedSeats
	 *            - foglalt helyek száma
	 */
	public void setReservedSeats(int reservedSeats) {
		this.reservedSeats = reservedSeats;
	}

	/**
	 * Lekéri, hogy a filmből az első előadás-e az adott napon.
	 * 
	 * @return firstPlayOnDay - első előadás-e
	 */
	public boolean isFirstPlayOnDay() {
		return firstPlayOnDay;
	}

	/**
	 * Beállítja, hogy az előadás első -e az adott napon a vetített filmből.
	 * 
	 * @param firstPlayOnDay
	 *            - első előadás-e
	 * 
	 */
	public void setFirstPlayOnDay(boolean firstPlayOnDay) {
		this.firstPlayOnDay = firstPlayOnDay;
	}

	/**
	 * Kiszámítja, hogy mennyi üres, elérhető szék van még az előadásra.
	 * 
	 * @return üres helyek száma
	 */
	public int calculateNotReservedSeatNumber() {
		return this.getRoom().getSeats() - this.reservedSeats;
	}

	/**
	 * Az előadások azonosító alapján történő rendezéséhez használatos.
	 * 
	 * @param o - előadás {@link Presentation}
	 * 
	 * @return rendezettség
	 */
	public int compareTo(Presentation o) {
		if (this.getId() > o.getId())
			return 1;
		else if (this.getId() < o.getId())
			return -1;
		else
			return 0;
	}

}
