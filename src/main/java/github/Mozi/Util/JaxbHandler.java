package github.Mozi.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import github.Mozi.Model.Cinema;
import github.Mozi.Model.Extra;
import github.Mozi.Model.Food;
import github.Mozi.Model.Purchase;

/**
 * Az xml fájlok feldolgozásáért, mentéséért felelős osztály.
 * 
 * @author Bozsar Tamas
 *
 */
public class JaxbHandler {

	/**
	 * Az osztály naplózásra használt objektum.
	 */
	private static final Logger logger = LoggerFactory.getLogger(JaxbHandler.class);

	/**
	 * A megrendeléseket tartalmazó fájl.
	 */
	static File PURCHASE_FILE = null;

	/**
	 * A mozi és előadásait tartalmazó fájl.
	 */
	static File CINEMA_FILE = null;

	
	static {
		PURCHASE_FILE = Paths.get(System.getProperty("user.home"), ".Cinema", "purchase.xml").toFile();

		CINEMA_FILE = Paths.get(System.getProperty("user.home"), ".Cinema", "cinema.xml").toFile();
	}

	/**
	 * Feldolgozza az Extrákat tároló xml állományt.
	 * 
	 * @param fileName
	 *            - a fájl neve
	 * 
	 * @return extra példányok listája {@link Food}
	 * @throws JAXBException
	 *             - ha nincs meg a fájl vagy nem tudja unmarshal-ni
	 *             {@link JAXBException}
	 */
	public List<Extra> readXMLExtra(String fileName) throws JAXBException {

		logger.trace("Extra olvasása");

		List<Extra> result = new ArrayList<Extra>();

		JAXBContext context = JAXBContext.newInstance(ExtraWrapperToXml.class);
		Unmarshaller unMarshaller = context.createUnmarshaller();

		InputStream is = JaxbHandler.class.getClassLoader().getResourceAsStream(fileName);

		ExtraWrapperToXml wrapper = (ExtraWrapperToXml) unMarshaller.unmarshal(is);

		result = wrapper.getList();

		return result;
	}

	/**
	 * Feldolgozza a Food, ételeket tároló xml állományt.
	 * 
	 * @param fileName
	 *            - a fájl neve
	 * 
	 * @return food példányok listája {@link Food}
	 * @throws JAXBException
	 *             - ha nincs meg a fájl vagy nem tudja marshal-ni
	 *             {@link JAXBException}
	 */
	public List<Food> readXMLFood(String fileName) throws JAXBException {
		List<Food> result = new ArrayList<Food>();

		JAXBContext context = JAXBContext.newInstance(FoodWrapperToXml.class);
		Unmarshaller unMarshaller = context.createUnmarshaller();

		InputStream is = JaxbHandler.class.getClassLoader().getResourceAsStream(fileName);

		FoodWrapperToXml wrapper = (FoodWrapperToXml) unMarshaller.unmarshal(is);

		result = wrapper.getList();

		return result;
	}

	/**
	 * Feldolgozza a Mozikat tároló xml állományt.
	 * 
	 * @param fileName
	 *            - a fájl neve
	 * 
	 * @return mozi példányok listája {@link Cinema}
	 * @throws JAXBException
	 *             - ha nincs meg a fájl vagy nem tudja marshal-ni
	 *             {@link JAXBException}
	 */
	public List<Cinema> readXMLCinema(String fileName) throws JAXBException {
		
		logger.info("beolvas cinema.xml");

		InputStream is = null;

		try {

			is = new FileInputStream(CINEMA_FILE);

		} catch (FileNotFoundException fne) {
			logger.info("sikertelen beolvasás: nincs meg a fájl: " + fne.getMessage());
			throw new JAXBException("nincs meg a fájl: " + fne.getMessage());
		}

		logger.info("sikeres beolvasás: cinema.xml");

		List<Cinema> result = new ArrayList<Cinema>();

		JAXBContext context = JAXBContext.newInstance(CinemaWrapperToXml.class);
		Unmarshaller unMarshaller = context.createUnmarshaller();
		CinemaWrapperToXml wrapper = (CinemaWrapperToXml) unMarshaller.unmarshal(is);

		result = wrapper.getList();

		logger.info("sikeres feldolgozás: cinema");

		return result;
	}

	/**
	 * Elmenti a kapott mozikat tartalmazó kolleckió tartalmát az xml
	 * állományba.
	 * 
	 * @param list
	 *            - mozik listája {@link Cinema}
	 * 
	 * @throws JAXBException
	 *             - ha nincs meg a fájl vagy nem tudja marshal-ni
	 *             {@link JAXBException}
	 */
	public void writeXMLCinema(List<Cinema> list) throws JAXBException {

		logger.debug("cinema.xml írás, adatok mentése");

		OutputStream os = null;

		try {

			os = new FileOutputStream(CINEMA_FILE);

		} catch (FileNotFoundException fne) {
			logger.debug("nincs meg a fájl: " + fne.getMessage());
			throw new JAXBException("nincs meg a fájl: " + fne.getMessage());
		}

		JAXBContext context = JAXBContext.newInstance(CinemaWrapperToXml.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		CinemaWrapperToXml wrapper = new CinemaWrapperToXml();
		wrapper.setList(list);

		marshaller.marshal(wrapper, os);

	}

	/**
	 * Elmenti a kapott megrendeléseket tartalmazó kolleckió tartalmát az xml
	 * állományba.
	 * 
	 * @param list
	 *            - megrendelések listája {@link Purchase}
	 * 
	 * @throws JAXBException
	 *             - ha nincs meg a fájl vagy nem tudja marshal-ni
	 *             {@link JAXBException}
	 */
	public void writeXMLPurchase(List<Purchase> list) throws JAXBException {

		logger.debug("purchase.xml írás, adatok mentése");

		OutputStream os = null;

		try {

			os = new FileOutputStream(PURCHASE_FILE);

		} catch (FileNotFoundException fne) {
			logger.debug("nincs meg a fájl: " + fne.getMessage());
			throw new JAXBException("nincs meg a fájl: " + fne.getMessage());
		}

		JAXBContext context = JAXBContext.newInstance(PurchaseWrapperToXml.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		PurchaseWrapperToXml wrapper = new PurchaseWrapperToXml();
		wrapper.setList(list);

		// File xmlF = File(fileName);

		marshaller.marshal(wrapper, os);

	}

	/**
	 * Feldolgozza a Purchase, megrendeléseket tároló xml állományt.
	 * 
	 * @param fileName
	 *            - a fájl neve
	 * 
	 * @return megrendelés példányok listája {@link Purchase}
	 * @throws JAXBException
	 *             - ha nincs meg a fájl vagy nem tudja marshal-ni
	 *             {@link JAXBException}
	 */
	public List<Purchase> readXMLPurchase(String fileName) throws JAXBException {

		logger.info("beolvas purchase.xml");

		InputStream is = null;

		try {

			is = new FileInputStream(PURCHASE_FILE);

		} catch (FileNotFoundException fne) {
			logger.info("sikertelen beolvasás: nincs meg a fájl: " + fne.getMessage());
			throw new JAXBException("nincs meg a fájl: " + fne.getMessage());
		}

		logger.info("sikeres beolvasás: purchase.xml");

		List<Purchase> result = new ArrayList<Purchase>();

		JAXBContext context = JAXBContext.newInstance(PurchaseWrapperToXml.class);
		Unmarshaller unMarshaller = context.createUnmarshaller();
		PurchaseWrapperToXml wrapper = (PurchaseWrapperToXml) unMarshaller.unmarshal(is);

		result = wrapper.getList();

		logger.info("sikeres feldolgozás: purchase");

		return result;
	}

	/**
	 * Átmásolja a kért fájlokat a kért helyre.
	 * 
	 * @param source - forrás állomány
	 * @param dest - cél állomány
	 * @throws IOException - io kivétel
	 */
	void copyFile(File source, File dest) throws IOException {

		logger.info("file copy to .Cinema");
		Files.copy(source.toPath(), dest.toPath());
	}

	/**
	 * Lellenőrzi, hogy léteznek-e a user.home.Cinema mappában a cinema.xml
	 * (mozi és előadásait tárolja, azért kell frissíteni, mert nyilván tartja,
	 * hogy hány darab hely foglalt az előadásra) valamint a purchase.xml
	 * (megrendeléseket tárolja).
	 * 
	 * Ha nem léteznek, akkor meghívja a
	 * {@link JaxbHandler#copyFile(File, File)} metódust, hogy átmásolja a
	 * szükséges fájlokat.
	 */
	public void checkFiles() {
		
		logger.info("check files");

		ClassLoader classLoader = getClass().getClassLoader();

		if (!PURCHASE_FILE.exists()) {

			logger.info("copy purchase");
			try {
				this.copyFile(new File(classLoader.getResource("purchase.xml").getFile()), PURCHASE_FILE);
			} catch (IOException e) {
				

				logger.warn("fajl masolas hiba! purchase: " +  e.getMessage());
			}
		}

		if (!CINEMA_FILE.exists()) {

			logger.info("copy cinema");
			try {
				this.copyFile(new File(classLoader.getResource("cinema.xml").getFile()), CINEMA_FILE);
			} catch (IOException e) {
			
				logger.warn("fajl masolas hiba! cinema: " + e.getMessage());
				e.printStackTrace();
			}
		}
	}

	/**
	 * Elkészíti a tároló mappát, a user.home.Cinema mappát.
	 * 
	 * @throws IOException
	 *             - input/Output hiba
	 */
	public void localRepo() throws IOException {
		
		logger.info("check localRepo folder");
		if (!PURCHASE_FILE.getParentFile().exists()) {

			logger.info("create .Cinema folder");
			
			if (!PURCHASE_FILE.getParentFile().mkdirs()) {
				throw new IOException("nem sikerült létrehozni a mappát.");

			}

			logger.info(".Cinema mappa létrehozása.");
		} else {
			logger.info(".Cinema mappa már létezik.");
		}

	}

}
