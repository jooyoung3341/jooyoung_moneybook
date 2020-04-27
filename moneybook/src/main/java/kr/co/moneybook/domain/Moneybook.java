package kr.co.moneybook.domain;

public class Moneybook {

	private String moneybook_name;
	private String moneybook_pw;
	private String authority_name;
	
	
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
				+ authority_name + "]";
	}
}
