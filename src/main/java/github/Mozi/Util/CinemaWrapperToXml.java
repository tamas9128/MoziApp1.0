package github.Mozi.Util;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import github.Mozi.Model.Cinema;

/**
 * A mozi objektumok csomagolására szolgál, hogy a jaxb feltudja dolgozni.
 * 
 * @author Bozsar Tamas
 *
 */
@XmlRootElement(name = "cinemas")
public class CinemaWrapperToXml {

	/**
	 * Mozik listája {@link Cinema}.
	 */
	private List<Cinema> list;

	/**
	 * Lekéri a mozik listáját.
	 * 
	 * @return list - mozik listája {@link Cinema}
	 */
	@XmlElement(name = "cinema")
	public List<Cinema> getList() {
		return this.list;
	}

	/**
	 * Beállítja a mozik listáját. 
	 * @param list - mozik listája {@link Cinema}
	 */
	public void setList(List<Cinema> list) {
		this.list = list;
	}
}
