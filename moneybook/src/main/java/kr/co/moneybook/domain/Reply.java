package kr.co.moneybook.domain;

public class Reply {

	private int rno;
	private int bno;
	private String moneybook_name;
	private String content;
	private String insert_date;
	
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
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
	
	@Override
	public String toString() {
		return "Reply [rno=" + rno + ", bno=" + bno + ", moneybook_name=" + moneybook_name + ", content=" + content
				+ ", insert_date=" + insert_date + "]";
	}	
}
