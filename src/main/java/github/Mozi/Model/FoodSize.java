package github.Mozi.Model;


/**
 * Az ételek méretét és a Normal árhoz képest a szorzót adja meg. 
 * 
 * @author Bozsar Tamas
 *
 */
public enum FoodSize {
	/**
	 * Kicsi méret, félárba kerül a normál mérethez képest.
	 */
	SMALL(0.5), 
	/**
	 * Normál méret.
	 */
	MEDIUM(1.0), 
	/**
	 * Nagy méret, a normál méret árának másfélszeresébe kerül.
	 */
	BIG(1.5), 
	/**
	 * Extra Nagy méret, a normál ár kétszeresébe kerül.
	 */
	EXTRA_BIG(2.0);
	
	/**
	 * Az étel mérete.
	 */
	private double numVal;

	/**
	 * Az étel méret konstruktora.
	 * 
	 * @param numVal - az étel mérete-szorzója az árhoz
	 *            
	 */
	FoodSize(double numVal) {
		this.numVal = numVal;
	}

	/**
	 * Lekéri az étel méretét és az árkalkulációhoz a szorzó értéket.
	 * 
	 * @return numVal - étel mérete és ár méret-szorzója
	 */
	public double getNumVal() {
		return numVal;
	}
}