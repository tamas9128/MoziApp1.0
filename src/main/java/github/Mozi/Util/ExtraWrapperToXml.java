package github.Mozi.Util;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import github.Mozi.Model.Extra;

/**
 * Az extra objektumok csomagolására szolgál, hogy a jaxb feltudja dolgozni.
 * 
 * @author Bozsar Tamas
 *
 */
@XmlRootElement(name="extras")
public class ExtraWrapperToXml {
	
	/**
	 * Extrák listája {@link Extra}.
	 */
	private List<Extra> extraList;
	/**
	 * Lekéri az extrák listáját.
	 * 
	 * @return extraList - extrák listája {@link Extra}
	 */
	@XmlElement(name="extra")
	public List<Extra> getList() {
		return this.extraList;
	}
	/**
	 * Beállítja az extrák listáját. 
	 * @param extraList - extrák listája {@link Extra}
	 */
	public void setList(List<Extra> extraList) {
		this.extraList = extraList;
	}
}
