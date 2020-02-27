package kr.co.moneybook.domain;

import java.util.List;

public class Board_status {

	private int bsno;
	private int bno;
	private String [] moneybook_type;
	private int [] price;
	private String [] cartegory;
	private String [] insert_date_status;
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
	public String[] getMoneybook_type() {
		return moneybook_type;
	}
	public void setMoneybook_type(String[] moneybook_type) {
		this.moneybook_type = moneybook_type;
	}
	public int[] getPrice() {
		return price;
	}
	public void setPrice(int[] price) {
		this.price = price;
	}
	public String[] getCartegory() {
		return cartegory;
	}
	public void setCartegory(String[] cartegory) {
		this.cartegory = cartegory;
	}
	public String[] getInsert_date_status() {
		return insert_date_status;
	}
	public void setInsert_date_status(String[] insert_date_status) {
		this.insert_date_status = insert_date_status;
	}
	
	
}
