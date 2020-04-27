package kr.co.moneybook.domain;

public class Calendar {
	private int price;
	private String cartegory;
	private String insert_date;
	private String moneybook_type;
	
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
	public String getMoneybook_type() {
		return moneybook_type;
	}
	public void setMoneybook_type(String moneybook_type) {
		this.moneybook_type = moneybook_type;
	}
	
	@Override
	public String toString() {
		return "Calendar [price=" + price + ", cartegory=" + cartegory + ", insert_date=" + insert_date
				+ ", moneybook_type=" + moneybook_type + "]";
	}
}
