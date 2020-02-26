package kr.co.moneybook.domain;

public class Guestbook {
	private int gno;
	private String moneybook_name;
	private String content;
	private String insert_date;
	
	public int getGno() {
		return gno;
	}
	public void setGno(int gno) {
		this.gno = gno;
	}
	public String getMoneybook_name() {
		return moneybook_name;
	}
	public void setMoneybook_name(String moneybook_name) {
		this.moneybook_name = moneybook_name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getInsert_date() {
		return insert_date;
	}
	public void setInsert_date(String insert_date) {
		this.insert_date = insert_date;
	}

	
}
