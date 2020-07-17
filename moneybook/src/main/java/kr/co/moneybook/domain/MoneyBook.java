package kr.co.moneybook.domain;

public class MoneyBook {

	private String moneybook_name;
	private String moneybook_pw;
	private String authority_name;
	private String insert_date;
	
	public String getInsert_date() {
		return insert_date;
	}
	public void setInsert_date(String insert_date) {
		this.insert_date = insert_date;
	}
	public String getAuthority_name() {
		return authority_name;
	}
	public void setAuthority_name(String authority_name) {
		this.authority_name = authority_name;
	}
	public String getMoneybook_name() {
		return moneybook_name;
	}
	public void setMoneybook_name(String moneybook_name) {
		this.moneybook_name = moneybook_name;
	}
	public String getMoneybook_pw() {
		return moneybook_pw;
	}
	public void setMoneybook_pw(String moneybook_pw) {
		this.moneybook_pw = moneybook_pw;
	}
	
	@Override
	public String toString() {
		return "Moneybook [moneybook_name=" + moneybook_name + ", moneybook_pw=" + moneybook_pw + ", authority_name="
				+ authority_name + ", insert_date=" + insert_date + "]";
	}
}
