package github.Mozi;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.xml.bind.JAXBException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import github.Mozi.Model.Cinema;
import github.Mozi.Model.CinemaException;
import github.Mozi.Model.Extra;
import github.Mozi.Model.Food;
import github.Mozi.Model.FoodSize;
import github.Mozi.Model.Presentation;
import github.Mozi.Model.Purchase;
import github.Mozi.Util.JaxbHandler;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

/**
 * Az applikáció belépési és vezérlő pontja.
 * 
 * @author Bozsar Tamas
 *
 */
public class MainApp extends JFrame {

	/**
	 * Az osztály naplózásra használt objektum.
	 */
	private static final Logger logger = LoggerFactory.getLogger(MainApp.class);

	/**
	 * Az osztály véletlenszerűen generált azonosítója.
	 */
	private static final long serialVersionUID = 5831618809204263619L;

	/**
	 * Frame.
	 */
	private static MainApp frame;
	/**
	 * A panel amire el lesznek helyezve az elemek.
	 */
	private JPanel contentPane;

	/**
	 * Az igényelt felnőtt jegyek mennyiségének bekérése szolgáló input mező.
	 */
	private static JTextField textF_adult;
	/**
	 * Az igényelt gyermek jegyek mennyiségének bekérése szolgáló input mező.
	 */
	private static JTextField textF_Child;
	/**
	 * Az igényelt diák jegyek mennyiségének bekérése szolgáló input mező.
	 */
	private static JTextField textF_Student;
	/**
	 * Az igényelt nyugdíjas jegyek mennyiségének bekérése szolgáló input mező.
	 */
	private static JTextField textF_Retirement;
	/**
	 * Az ügyfél nevének bekérése szolgáló input mező.
	 */
	private static JTextField textF_Customer;
	/**
	 * Az igényelt ételek mennyiségének bekérése szolgáló input mező.
	 */
	private static JTextField textField_FoodQuantity;
	/**
	 * Az igényelt extrák mennyiségének bekérése szolgáló input mező.
	 */
	private static JTextField textField_ExtraQuantity;
	/**
	 * Az igényelt ételekhez viuzális visszajelzésére az ügyfél felé.
	 */
	private static JTextArea textAreaFoods;
	/**
	 * Az igényelt ételek kiválasztásához szükséges választó mező.
	 */
	private static JComboBox<String> comboBox_Extra;
	/**
	 * Az igényelt extrák kiválasztásához szükséges választó mező.
	 */
	private static JTextArea textAreaExtras;
	/**
	 * Az igényelt ételek árának kijelzsérére szolgáló elem.
	 */
	private static JLabel lblFoodPrice;
	/**
	 * Az igényelt extrák árának kijelzsérére szolgáló elem.
	 */
	private static JLabel lblExtraPrice;
	/**
	 * Az igényelt szolgáltatás és termékek összesített árának kijelzsérére
	 * szolgáló elem.
	 */
	private static JLabel lblPrice;
	/**
	 * A megrendelés azonosítójának kijelzsérére szolgáló elem.
	 */
	private static JLabel lblPurchaseid;
	/**
	 * Az kívánt előadás kiválasztását segítő elem.
	 */
	private static JComboBox<String> comboBox_PresId;
	/**
	 * Az előadások kijelzésére szolgáló elem.
	 */
	private static JTextArea textAreaPres;
	/**
	 * Az adatok perzisztenciájáért felelős adattag {@link JaxbHandler}.
	 */
	private static JaxbHandler jaxb;
	/**
	 * A mozikat tároló lista {@link Cinema}.
	 */
	private static List<Cinema> cinemas;
	/**
	 * A megrendeléseket tároló lista {@link Purchase}.
	 */
	private static List<Purchase> purchases;
	/**
	 * Az ételeket tároló lista {@link Food}.
	 */
	private static List<Food> foods;
	/**
	 * Az extrákat tároló lista {@link Extra}.
	 */
	private static List<Extra> extras;
	/**
	 * Az eőadásokat tároló lista {@link Presentation}.
	 */
	private static List<Presentation> presentations;

	/**
	 * A megrendeléshez hozzáadott ételek listája mennyiséggel {@link Food} ,
	 * mennyiség.
	 */
	private static Map<Food, Integer> foodMap = new HashMap<Food, Integer>();

	/**
	 * A megrendeléshez hozzáadott extrák listája mennyiséggel {@link Food} ,
	 * mennyiség.
	 */
	private static Map<Extra, Integer> extraMap = new HashMap<Extra, Integer>();

	/**
	 * A vásárlás maga, amelyet az ügyfél állít össze a kínálmaknak megfelelően
	 * {@link Purchase}}.
	 */
	private static Purchase purchase = new Purchase();

	/**
	 * Launch the application.
	 * 
	 * @param args
	 *            - argumentumok listája
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					initialize();

					frame = new MainApp();

					frame.setVisible(true);

					logger.info("mainApp felület megjelenítés");

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainApp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelShows = new JPanel();
		panelShows.setBounds(10, 11, 664, 273);
		contentPane.add(panelShows);
		panelShows.setLayout(null);

		textAreaPres = new JTextArea();
		textAreaPres.setBounds(10, 22, 644, 239);
		textAreaPres.setTabSize(5);
		textAreaPres.setFont(new Font("Serif", Font.ITALIC, 13));
		textAreaPres.setLineWrap(true);
		textAreaPres.setWrapStyleWord(true);
		textAreaPres.setEditable(false);
		panelShows.add(textAreaPres);

		refreshPresTable();

		JLabel lblFilmId = new JLabel("Film id");
		lblFilmId.setBounds(10, 0, 46, 14);
		panelShows.add(lblFilmId);

		JLabel lblCm = new JLabel("Cím");
		lblCm.setBounds(87, 0, 46, 14);
		panelShows.add(lblCm);

		JLabel lblNyelv = new JLabel("Nyelv");
		lblNyelv.setBounds(157, 0, 46, 14);
		panelShows.add(lblNyelv);

		JLabel lbld = new JLabel("3D?");
		lbld.setBounds(225, 0, 46, 14);
		panelShows.add(lbld);

		JLabel lblJegyr = new JLabel("Jegyár");
		lblJegyr.setBounds(608, 0, 46, 14);
		panelShows.add(lblJegyr);

		JLabel lblIdpont = new JLabel("Időpont");
		lblIdpont.setBounds(292, 0, 46, 14);
		panelShows.add(lblIdpont);

		JLabel lblSzabadHelyek = new JLabel("Szabad helyek");
		lblSzabadHelyek.setBounds(504, 0, 94, 14);
		panelShows.add(lblSzabadHelyek);

		JLabel lblEladTerem = new JLabel("Előadó terem");
		lblEladTerem.setBounds(421, 0, 73, 14);
		panelShows.add(lblEladTerem);

		JPanel panelOrder = new JPanel();
		panelOrder.setBounds(10, 295, 664, 256);
		contentPane.add(panelOrder);
		panelOrder.setLayout(null);

		JLabel lblEladsKdja = new JLabel("Előadás kódja");
		lblEladsKdja.setBounds(10, 11, 87, 14);
		panelOrder.add(lblEladsKdja);

		JLabel lblFelntt = new JLabel("Felnőtt");
		lblFelntt.setBounds(10, 113, 46, 14);
		panelOrder.add(lblFelntt);

		JLabel lblGyermek = new JLabel("Gyermek");
		lblGyermek.setBounds(10, 159, 66, 14);
		panelOrder.add(lblGyermek);

		JLabel lblDik = new JLabel("Diák");
		lblDik.setBounds(10, 195, 46, 14);
		panelOrder.add(lblDik);

		JLabel lblNyugdjas = new JLabel("Nyugdíjas");
		lblNyugdjas.setBounds(10, 226, 66, 14);
		panelOrder.add(lblNyugdjas);

		JLabel lblJegyekMennyisge = new JLabel("Jegyek mennyisége");
		lblJegyekMennyisge.setBounds(10, 88, 125, 14);
		panelOrder.add(lblJegyekMennyisge);

		// -------------------------------
		textF_adult = new JTextField();
		textF_adult.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				refreshPrice();
			}
		});

		textF_adult.setBounds(93, 110, 52, 20);
		panelOrder.add(textF_adult);
		textF_adult.setColumns(10);
		textF_adult.setText("0");

		// -------------------------------
		textF_Child = new JTextField();
		textF_Child.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				refreshPrice();
			}
		});
		textF_Child.setBounds(93, 156, 52, 20);
		panelOrder.add(textF_Child);
		textF_Child.setColumns(10);
		textF_Child.setText("0");

		// -------------------------------
		textF_Student = new JTextField();
		textF_Student.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				refreshPrice();
			}
		});
		textF_Student.setBounds(93, 192, 52, 20);
		panelOrder.add(textF_Student);
		textF_Student.setColumns(10);
		textF_Student.setText("0");

		// -------------------------------
		textF_Retirement = new JTextField();
		textF_Retirement.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				refreshPrice();
			}
		});
		textF_Retirement.setBounds(93, 223, 52, 20);
		panelOrder.add(textF_Retirement);
		textF_Retirement.setColumns(10);
		textF_Retirement.setText("0");

		// -------------------------------

		JLabel lblVsrlNeve = new JLabel("Vásárló neve");
		lblVsrlNeve.setBounds(159, 176, 87, 14);
		panelOrder.add(lblVsrlNeve);

		textF_Customer = new JTextField();
		textF_Customer.setBounds(258, 173, 247, 20);
		panelOrder.add(textF_Customer);
		textF_Customer.setColumns(10);

		JLabel lbltel = new JLabel("Étel");
		lbltel.setBounds(189, 11, 46, 14);
		panelOrder.add(lbltel);

		String[] foodsComboList = new String[foods.size()];

		for (int i = 0; i < MainApp.foods.size(); i++) {
			System.out.println(MainApp.foods.get(i));
			foodsComboList[i] = Integer.toString(MainApp.foods.get(i).getId()) + "," + MainApp.foods.get(i).getName();
		}

		final JComboBox<String> comboBox_FoodName = new JComboBox<String>(foodsComboList);
		comboBox_FoodName.setBounds(215, 8, 80, 20);
		panelOrder.add(comboBox_FoodName);

		String[] foodsSizeComboList = { "SMALL", "MEDIUM", "BIG", "EXTRA_BIG" };

		final JComboBox<String> comboBox_FoodSize = new JComboBox<String>(foodsSizeComboList);
		comboBox_FoodSize.setSelectedIndex(1);
		comboBox_FoodSize.setBounds(304, 8, 80, 20);

		panelOrder.add(comboBox_FoodSize);

		JButton btnAddFood = new JButton("Hozzáad");
		btnAddFood.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int db = Integer.valueOf(textField_FoodQuantity.getText());

				if (db > 0) {
					String size = comboBox_FoodSize.getSelectedItem().toString();
					FoodSize fs = null;
					if (size.equals("SMALL")) {
						fs = FoodSize.SMALL;
					}
					if (size.equals("MEDIUM")) {
						fs = FoodSize.MEDIUM;
					}
					if (size.equals("BIG")) {
						fs = FoodSize.BIG;
					}
					if (size.equals("EXTRA_BIG")) {
						fs = FoodSize.EXTRA_BIG;
					}

					System.out.println(fs + " ___ ");
					String[] f = comboBox_FoodName.getSelectedItem().toString().split(",");
					int id = Integer.valueOf(f[0]);

					Food ff = null;

					for (int i = 0; i < MainApp.foods.size(); i++) {
						if (MainApp.foods.get(i).getId() == id) {
							Food f2 = MainApp.foods.get(i);
							ff = new Food(f2.getId(), f2.getName(), f2.getPrice(), f2.getSize(), f2.getType());
						}
					}

					ff.setSize(fs);

					MainApp.addFood(ff, db);

					/*
					 * System.out.println(comboBox_FoodName.getSelectedItem() +
					 * " " + comboBox_FoodSize.getSelectedItem() + " " +
					 * textField_FoodQuantity.getText());
					 */

					textAreaFoods.setText("");
					String t = "";
					for (Map.Entry<Food, Integer> entry : MainApp.foodMap.entrySet()) {
						String v = entry.getKey() + ", " + entry.getValue() + " db";
						System.out.println(v);
						t += v + "\n";
					}

					textAreaFoods.append(t);

					MainApp.purchase.setFoods(MainApp.foodMap);
					String amount = Integer.toString(MainApp.purchase.calculateFoodsPrice());
					lblFoodPrice.setText(amount + " Ft.");
					MainApp.refreshPrice();

				} else {
					logger.info("nem lett hozzáadva a nulla darab étel");
				}

			}
		});

		btnAddFood.setBounds(304, 34, 80, 23);
		panelOrder.add(btnAddFood);

		textField_FoodQuantity = new JTextField();
		textField_FoodQuantity.setBounds(267, 39, 28, 18);
		panelOrder.add(textField_FoodQuantity);
		textField_FoodQuantity.setColumns(10);
		textField_FoodQuantity.setText("1");

		JLabel lblExtra = new JLabel("Extra");
		lblExtra.setBounds(429, 11, 46, 14);
		panelOrder.add(lblExtra);

		String[] extraComboList = new String[extras.size()];

		for (int i = 0; i < MainApp.extras.size(); i++) {
			System.out.println(MainApp.extras.get(i));
			extraComboList[i] = MainApp.extras.get(i).toString();
		}

		comboBox_Extra = new JComboBox<String>(extraComboList);
		comboBox_Extra.setBounds(485, 8, 169, 20);
		panelOrder.add(comboBox_Extra);

		textField_ExtraQuantity = new JTextField();
		textField_ExtraQuantity.setBounds(528, 35, 33, 20);
		panelOrder.add(textField_ExtraQuantity);
		textField_ExtraQuantity.setColumns(10);
		textField_ExtraQuantity.setText("1");

		JButton btnAddExtra = new JButton("Hozzáad");
		btnAddExtra.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int db = Integer.valueOf(textField_ExtraQuantity.getText());

				if (db > 0) {

					String[] f = comboBox_Extra.getSelectedItem().toString().split(",");
					int id = Integer.valueOf(f[0]);

					Extra ff = null;

					for (int i = 0; i < MainApp.extras.size(); i++) {
						if (MainApp.extras.get(i).getId() == id) {
							Extra f2 = MainApp.extras.get(i);
							ff = new Extra(f2.getId(), f2.getName(), f2.getPrice());
						}
					}

					MainApp.addExtra(ff, db);

					textAreaExtras.setText("");
					String t = "";
					for (Map.Entry<Extra, Integer> entry : MainApp.extraMap.entrySet()) {
						String v = entry.getKey() + ", " + entry.getValue() + " db";
						System.out.println(v);
						t += v + "\n";
					}

					textAreaExtras.append(t);
					System.out.println("------------");

					MainApp.purchase.setExtras(extraMap);
					String amount = Integer.toString(MainApp.purchase.calculateExtrasPrice());
					lblExtraPrice.setText(amount + " Ft.");
					MainApp.refreshPrice();
				} else {
					logger.info("nem lett hozzáadva a nulla darab extra");
				}
			}
		});

		btnAddExtra.setBounds(565, 34, 89, 23);
		panelOrder.add(btnAddExtra);

		JLabel lblMegrendelsAzonostja = new JLabel("Megrendelés azonosítója:");
		lblMegrendelsAzonostja.setBounds(159, 195, 134, 14);
		panelOrder.add(lblMegrendelsAzonostja);

		lblPrice = new JLabel("0 Ft.");
		lblPrice.setBounds(304, 226, 80, 14);
		panelOrder.add(lblPrice);

		lblPurchaseid = new JLabel("-");
		lblPurchaseid.setBounds(301, 195, 204, 14);
		panelOrder.add(lblPurchaseid);

		JLabel lblMegrendelsrtke = new JLabel("Megrendelés értéke");
		lblMegrendelsrtke.setBounds(155, 226, 150, 14);
		panelOrder.add(lblMegrendelsrtke);

		String[] presComboList = new String[presentations.size()];

		for (int i = 0; i < MainApp.presentations.size(); i++) {
			System.out.println(MainApp.presentations.get(i));
			presComboList[i] = Integer.toString(MainApp.presentations.get(i).getId());
		}
		comboBox_PresId = new JComboBox<String>(presComboList);
		comboBox_PresId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshPrice();
			}
		});

		comboBox_PresId.setBounds(93, 8, 52, 20);
		comboBox_PresId.setSelectedIndex(0);
		panelOrder.add(comboBox_PresId);

		JButton btnExit = new JButton("Kilépés");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				logger.info("program bezárás");
				System.exit(0);
			}
		});
		btnExit.setBounds(565, 222, 89, 23);
		panelOrder.add(btnExit);

		JButton btnPurchase = new JButton("Megrendelés");
		btnPurchase.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				logger.info("megrendelés klikk");

				setPurchase();

				if (MainApp.purchase.getCustomer() == null || MainApp.purchase.getCustomer().equals("")) {
					JOptionPane.showMessageDialog(frame, "Adjon meg ügyfél nevet!");
				} else if (MainApp.purchase.getAdult() == 0 && MainApp.purchase.getChild() == 0
						&& MainApp.purchase.getStudent() == 0 && MainApp.purchase.getRetirement() == 0) {
					JOptionPane.showMessageDialog(frame, "Legalább egy jegyet megkell rendelned!");
				} else {
					
					logger.info("adatok rendben");
					
					MainApp.purchase.setCustomer(textF_Customer.getText());
					MainApp.purchase.generateId();

					lblPurchaseid.setText(MainApp.purchase.getId());

					refreshPrice();

					try {

						logger.info("adatok frissítése");
						
						MainApp.purchase.doPurchase();

						logger.info("megrendelésekhez hozzáadás");
						
						MainApp.purchases.add(MainApp.purchase);

						
						
						logger.info("purchase kiíratása");
						jaxb.writeXMLPurchase(MainApp.purchases);

						logger.info("helyek kalkulálása a cinema-ban");
						int places = MainApp.purchase.numberOfPersons();

						Presentation p = null;

						for (int i = 0; i < MainApp.presentations.size(); i++) {
							if (MainApp.presentations.get(i).getId() == MainApp.purchase.getPresentation().getId()) {
								p = MainApp.presentations.get(i);

								break;
							}
						}

						MainApp.presentations.remove(p);

						p.setReservedSeats(p.getReservedSeats() + places);

						MainApp.presentations.add(p);

						Cinema cc = MainApp.cinemas.get(0);
						MainApp.cinemas = new ArrayList<Cinema>();
						cc.setPresentations(MainApp.presentations);
						MainApp.cinemas.add(cc);

						logger.info("cinema kiíratása");
						jaxb.writeXMLCinema(MainApp.cinemas);

						refreshPresTable();

						String message = "Sikeres rendelés!\nRendelés azonosítód: " + MainApp.purchase.getId()
								+ "\nVégösszeg: " + MainApp.purchase.getPrice() + " Ft.";
						JOptionPane.showMessageDialog(frame, message);

						
						setInputsEmpty();

						logger.info("megrendelés végleges: " + MainApp.purchase);

					} catch (JAXBException e1) {
						
						logger.warn("sikertelen megrendelés mentés: jaxb hiba:" + e1.getMessage());
						JOptionPane.showMessageDialog(frame, "Sikertelen rendelés mentés! Adatbázis hiba!");
					} catch (CinemaException e1) {
						
						logger.warn("sikertelen megrendelés mentés: megrendelés objektum hiba:" + e1.getMessage());
						JOptionPane.showMessageDialog(frame,
								"Sikertelen rendelés! Nincs elég hely az előadó teremben!");
					}

				}

			}
		});
		btnPurchase.setBounds(462, 222, 89, 23);
		panelOrder.add(btnPurchase);

		JLabel lblMennyisg = new JLabel("Mennyiség");
		lblMennyisg.setBounds(189, 38, 76, 14);
		panelOrder.add(lblMennyisg);

		JLabel label = new JLabel("Mennyiség");
		label.setBounds(429, 38, 76, 14);
		panelOrder.add(label);

		textAreaFoods = new JTextArea();
		textAreaFoods.setBounds(189, 63, 194, 70);
		panelOrder.add(textAreaFoods);

		textAreaExtras = new JTextArea();
		textAreaExtras.setBounds(429, 63, 194, 70);
		panelOrder.add(textAreaExtras);

		JButton btnExtrasDelete = new JButton("Extra Törlés");
		btnExtrasDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				MainApp.extraMap = new HashMap<Extra, Integer>();
				MainApp.purchase.setExtras(MainApp.extraMap);
				textAreaExtras.setText("");
				lblExtraPrice.setText("0 Ft.");
				MainApp.refreshPrice();
				logger.info("extrák törlése");
			}
		});

		btnExtrasDelete.setBounds(504, 138, 119, 23);
		panelOrder.add(btnExtrasDelete);

		JButton btnFoodsDelete = new JButton("Ételek törlése");
		btnFoodsDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				MainApp.foodMap = new HashMap<Food, Integer>();
				MainApp.purchase.setFoods(MainApp.foodMap);
				textAreaFoods.setText("");
				lblFoodPrice.setText("0 Ft.");
				MainApp.refreshPrice();

				logger.info("ételek törlése");
			}
		});

		btnFoodsDelete.setBounds(258, 139, 126, 23);
		panelOrder.add(btnFoodsDelete);

		lblFoodPrice = new JLabel("0 Ft.");
		lblFoodPrice.setBounds(189, 144, 57, 14);
		panelOrder.add(lblFoodPrice);

		lblExtraPrice = new JLabel("0 Ft.");
		lblExtraPrice.setBounds(429, 142, 57, 14);
		panelOrder.add(lblExtraPrice);
	}

	/**
	 * Inicializó metódus, beállítja az adatokat. Az extrák, ételek, előadások és megrendelés adatokat.
	 */
	static void initialize() {

		jaxb = new JaxbHandler();

		logger.info("inicializálás, jaxbHandler");

		try {
			
			jaxb.localRepo();
			jaxb.checkFiles();
			
			foods = jaxb.readXMLFood("foods.xml");
			extras = jaxb.readXMLExtra("extra.xml");
			cinemas = jaxb.readXMLCinema("cinema.xml");
			purchases = jaxb.readXMLPurchase("purchase.xml");
			//purchases  = new ArrayList<Purchase>();

			presentations = cinemas.get(0).getPresentations();

			for (int i = 0; i < extras.size(); i++) {
				logger.info(extras.get(i).toString());
			}
			for (int i = 0; i < foods.size(); i++) {
				logger.info(foods.get(i).toString());
			}
			for (int i = 0; i < cinemas.size(); i++) {
				logger.info(cinemas.get(i).toString());
			}
			
			for (int i = 0; i < purchases.size(); i++) {
				logger.info(purchases.get(i).toString());
			}

			logger.info("sikeres adatbetöltés");

		} catch (JAXBException e) {
			JOptionPane.showMessageDialog(frame, "Adatbázis Hiba!");
			logger.warn("sikertelen adatbetöltés:" + e.getMessage());
		} catch (IOException e) {
			
			logger.warn("Hiba!: "+ e.getMessage());
		}

	}

	/**
	 * Hozzá ad az extrák listájához db darab adott extrát.
	 * 
	 * @param e
	 *            - étel {@link Extra}
	 * @param db
	 *            - mennyiség
	 */
	static void addExtra(Extra e, int db) {
		logger.info("extra hozzáadás:" + e.toString() + "," + db);

		if (MainApp.extraMap.containsKey(e))
			MainApp.extraMap.put(e, MainApp.extraMap.get(e) + db);
		else
			MainApp.extraMap.put(e, db);
	}

	/**
	 * Hozzá ad az ételek listájához db darab adott ételt.
	 * 
	 * @param e
	 *            - étel {@link Food}
	 * @param db
	 *            - mennyiség
	 */
	static void addFood(Food e, int db) {
		logger.info("étel hozzáadás:" + e.toString() + "," + db);

		if (MainApp.foodMap.containsKey(e))
			MainApp.foodMap.put(e, MainApp.foodMap.get(e) + db);
		else
			MainApp.foodMap.put(e, db);
	}

	/**
	 * Frissíti a megrendelés árát a felhazsnálói felületen.
	 */
	static void refreshPrice() {

		setPurchase();

		String amount = Integer.toString(MainApp.purchase.calculatePrice());
		MainApp.lblPrice.setText(amount + " Ft.");
	}

	/**
	 * Beállítja a megrendelés objektumot az inputok adatai alapján
	 * {@link MainApp#purchase}}.
	 */
	static void setPurchase() {
		try {
			int adult = Integer.valueOf(textF_adult.getText());
			int child = Integer.valueOf(textF_Child.getText());
			int student = Integer.valueOf(textF_Student.getText());
			int retirement = Integer.valueOf(textF_Retirement.getText());

			MainApp.purchase.setAdult(adult);
			MainApp.purchase.setChild(child);
			MainApp.purchase.setStudent(student);
			MainApp.purchase.setRetirement(retirement);

			MainApp.purchase.setCustomer(textF_Customer.getText());

			int preId = Integer.valueOf(comboBox_PresId.getSelectedItem().toString());
			Presentation p = new Presentation();

			for (int i = 0; i < MainApp.presentations.size(); i++) {

				Presentation p2 = MainApp.presentations.get(i);
				if (p2.getId() == preId) {
					p.setId(preId);
					p.setMovie(p2.getMovie());
					p.setReservedSeats(p2.getReservedSeats());
					p.setRoom(p2.getRoom());
					p.setTime(p2.getTime());
					p.setFirstPlayOnDay(p2.isFirstPlayOnDay());

					break;
				}
			}

			MainApp.purchase.setPresentation(p);
			MainApp.purchase.setCinema(MainApp.cinemas.get(0));
			MainApp.purchase.setFoods(MainApp.foodMap);
			MainApp.purchase.setExtras(MainApp.extraMap);

			logger.info("megrendelés beállítás" + MainApp.purchase);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(frame, "Számok szükségesek a személyek megadásánál!");
		}

	}

	/**
	 * Az előadásokat megjelenítő mező tartalmát frissíti a mozi előadásainak
	 * listája alapján.
	 */
	static void refreshPresTable() {
		String pressContent = "";

		Collections.sort(presentations);
		
		
		for (int i = 0; i < presentations.size(); i++) {
			Presentation p = presentations.get(i);
			pressContent += p.getId() + "\t" + p.getMovie().getTitle() + "\t" + p.getMovie().getLanguage() + "\t\t"
					+ Boolean.toString(p.getMovie().is_3d()) + "\t" + p.getTime().toString() + "\t"
					+ Integer.toString(p.getRoom().getId()) + "\t" + +p.calculateNotReservedSeatNumber() + "\t\t"
					+ cinemas.get(0).getTicketPrice() + " Ft.\n";
		}

		textAreaPres.setText("");
		textAreaPres.append(pressContent);

		logger.info("előadások tábla frissítés");
	}

	/**
	 * Beviteli mezők alaphelyzetbe állítását végzi.
	 */
	static void setInputsEmpty() {
		textF_adult.setText("0");
		textF_Child.setText("0");
		textF_Student.setText("0");
		textF_Retirement.setText("0");
		textAreaFoods.setText("");
		textAreaExtras.setText("");

		MainApp.extraMap = new HashMap<Extra, Integer>();
		MainApp.foodMap = new HashMap<Food, Integer>();
		MainApp.purchase = new Purchase();

		textF_Customer.setText("");
		lblPurchaseid.setText("-");

		lblExtraPrice.setText("0");
		lblFoodPrice.setText("0");
		lblPrice.setText("0 Ft.");

		textField_FoodQuantity.setText("1");
		textField_ExtraQuantity.setText("1");

		logger.info("inputok alaphelyzetbe állítása");
	}
}
