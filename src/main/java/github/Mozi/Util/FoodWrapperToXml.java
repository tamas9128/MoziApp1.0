package github.Mozi.Util;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import github.Mozi.Model.Food;

/**
 * Az étel objektumok csomagolására szolgál, hogy a jaxb feltudja dolgozni.
 * 
 * @author Bozsar Tamas
 *
 */

@XmlRootElement(name="foods")
public class FoodWrapperToXml {
	/**
	 * Ételek listája {@link Food}.
	 */
	private List<Food> list;
	/**
	 * Lekéri az ételek listáját.
	 * 
	 * @return list - mozik listája {@link Food}
	 */
	@XmlElement(name="food")
	public List<Food> getList() {
		return this.list;
	}
	/**
	 * Beállítja az ételek listáját. 
	 * @param foodList - mozik listája {@link Food}
	 */
	public void setList(List<Food> foodList) {
		this.list = foodList;
	}
}
