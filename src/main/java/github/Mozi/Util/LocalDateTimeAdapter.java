package github.Mozi.Util;

import java.time.LocalDateTime;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Feldolgozó, kisegítő a Jaxb kezelőnek, hogy a dátumokat megfelelően tudja
 * átalakítani szöveg és localdate között valamint szerializálni.
 *
 * @author Bozsar Tamas
 */
public class LocalDateTimeAdapter extends XmlAdapter<String, LocalDateTime> {


	@Override
	public String marshal(LocalDateTime v) throws Exception {
		// TODO Auto-generated method stub
		return v.toString();
	}

	@Override
	public LocalDateTime unmarshal(String v) throws Exception {
		// TODO Auto-generated method stub
		return LocalDateTime.parse(v);
	}
}