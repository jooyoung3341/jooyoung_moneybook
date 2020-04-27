package kr.co.moneybook.domain;

public class Earnings {

    private int ino;
    private String moneybook_name;
    private int price;
    private String cartegory;
    private String insert_date;
    private String moneybook_type;

	/*
	 * private int price_sum;
	 * 
	 * 
	 * public int getPrice_sum() { return price_sum; } public void setPrice_sum(int
	 * price_sum) { this.price_sum = price_sum; }
	 */
	public String getMoneybook_type() {
		return moneybook_type;
	}
	public void setMoneybook_type(String moneybook_type) {
		this.moneybook_type = moneybook_type;
	}
	public int getIno() {
		return ino;
	}
	public void setIno(int ino) {
		this.ino = ino;
	}
	public String getMoneybook_name() {
		return moneybook_name;
	}
	public void setMoneybook_name(String moneybook_name) {
		this.moneybook_name = moneybook_name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getCartegory() {
		return cartegory;
	}
	public void setCartegory(String cartegory) {
		this.cartegory = cartegory;
	}
	public String getInsert_date() {
		return insert_date;
	}
	public void setInsert_date(String insert_date) {
		this.insert_date = insert_date;
	}
	
	@Override
	public String toString() {
		return "Earnings [ino=" + ino + ", moneybook_name=" + moneybook_name + ", price=" + price + ", cartegory="
				+ cartegory + ", insert_date=" + insert_date + ", moneybook_type=" + moneybook_type + "]";
	}
}
