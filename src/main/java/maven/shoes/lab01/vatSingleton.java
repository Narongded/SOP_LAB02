package maven.shoes.lab01;

public class vatSingleton {
	private static vatSingleton instance;
	private int vat;
	
	public vatSingleton() {
		
	}
	public static vatSingleton getInstance() {
		if (instance == null) {
			instance = new vatSingleton();
		}
		return instance;

	}
	public int getVat() {
		return vat;
	}
	public void setVat(int vat) {
		this.vat = vat*107/100;
	}

}
