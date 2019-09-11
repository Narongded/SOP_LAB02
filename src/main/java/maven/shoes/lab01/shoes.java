package maven.shoes.lab01;

public class shoes {
	private String band;
	private int price;
	public shoes(String name,int price1) {
		this.band = name;
		this.price = price1;
	}
	public String getBand() {
		return band+"\n";
	}
	public void setBand(String band) {
		this.band = band;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
