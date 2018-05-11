package github.Mozi.Util;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import github.Mozi.Model.Purchase;

/**
 * A megrendelés objektumok csomagolására szolgál, hogy a jaxb feltudja dolgozni.
 * 
 * @author Bozsar Tamas
 *
 */

@XmlRootElement(name = "purchases")
public class PurchaseWrapperToXml {
	/**
	 * Megrendelések listája {@link Purchase}.
	 */
	private List<Purchase> list;

	/**
	 * Lekéri a megrendelések listáját.
	 * 
	 * @return list - megrendelések listája {@link Purchase}
	 */
	@XmlElement(name = "purchase")
	public List<Purchase> getList() {
		return this.list;
	}

	/**
	 * Beállítja a megrendelések listáját.
	 * 
	 * @param list - megrendelések listája {@link Purchase}
	 */
	public void setList(List<Purchase> list) {
		this.list = list;
	}
}
