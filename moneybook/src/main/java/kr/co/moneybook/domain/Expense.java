package kr.co.moneybook.domain;

public class Expense {
    private int eno;
    private String moneybook_name;
    private int price;
    private String type;
    private String cartegory;
    private String insert_date;
    private String moneybook_type;
    
	public String getMoneybook_type() {
		return moneybook_type;
	}
	public void setMoneybook_type(String moneybook_type) {
		this.moneybook_type = moneybook_type;
	}
	public int getEno() {
		return eno;
	}
	public void setEno(int eno) {
		this.eno = eno;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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

	//정렬
	/*
	 * public String getSort() { return sort; } public void setSort(String sort) {
	 * this.sort = sort; } public String getSort_flag() { return sort_flag; } public
	 * void setSort_flag(String sort_flag) { this.sort_flag = sort_flag; }
	 */
    
}
