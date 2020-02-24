package kr.co.moneybook.domain;

public class Board {
	private int bno;
	private String moneybook_name;
	private String title;
	private String content;
	private String insert_date;
	private String moneybook_date;
	private int readcnt;
	private int recommend;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public String getMoneybook_date() {
		return moneybook_date;
	}
	public void setMoneybook_date(String moneybook_date) {
		this.moneybook_date = moneybook_date;
	}
	public int getReadcnt() {
		return readcnt;
	}
	public void setReadcnt(int readcnt) {
		this.readcnt = readcnt;
	}
	public int getRecommend() {
		return recommend;
	}
	public void setRecommend(int recommend) {
		this.recommend = recommend;
	}
	

}
