package kr.co.moneybook.domain;

public class Calendar {
	private int price;
	private String cartegory;
	private String insert_date;
	private String moneybook_type;
	private String type;
	private int no;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
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
