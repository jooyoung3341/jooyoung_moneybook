package kr.co.moneybook.domain;

public class Board_status {

	private int bsno;
	private int bno;
	private String moneybook_type;
	private int price;
	private String cartegory;
	private String insert_date;
	
	
	public String getInsert_date() {
		return insert_date;
	}
	public void setInsert_date(String insert_date) {
		this.insert_date = insert_date;
	}
	public int getBsno() {
		return bsno;
	}
	public void setBsno(int bsno) {
		this.bsno = bsno;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getMoneybook_type() {
		return moneybook_type;
	}
	public void setMoneybook_type(String moneybook_type) {
		this.moneybook_type = moneybook_type;
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
	
	
}
