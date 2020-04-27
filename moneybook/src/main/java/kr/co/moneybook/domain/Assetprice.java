package kr.co.moneybook.domain;

public class Assetprice {
	private int pno;
	private int price;
	private String insert_date;
	private int ano;

	/*
	 * private int price_sum;
	 * 
	 * public int getPrice_sum() { return price_sum; } public void setPrice_sum(int
	 * price_sum) { this.price_sum = price_sum; }
	 */
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getInsert_date() {
		return insert_date;
	}
	public void setInsert_date(String insert_date) {
		this.insert_date = insert_date;
	}
	
	@Override
	public String toString() {
		return "Assetprice [pno=" + pno + ", price=" + price + ", insert_date=" + insert_date + ", ano=" + ano + "]";
	}
}
