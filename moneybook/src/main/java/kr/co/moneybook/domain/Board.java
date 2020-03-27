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
	private int reply;
	
	//board_status
	private int bsno;
	private String  moneybook_type;
	private int  price;
	private String cartegory;
	private String board_date;
	
	//recommend
	private String recommend_status;
	private String reno;
	
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
	public int getReply() {
		return reply;
	}
	public void setReply(int reply) {
		this.reply = reply;
	}
	
	//board_status
	public int getBsno() {
		return bsno;
	}
	public void setBsno(int bsno) {
		this.bsno = bsno;
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
	public String getBoard_date() {
		return board_date;
	}
	public void setBoard_date(String board_date) {
		this.board_date = board_date;
	}

	//recommend
	public String getRecommend_status() {
		return recommend_status;
	}
	public void setRecommend_status(String recommend_status) {
		this.recommend_status = recommend_status;
	}
	public String getReno() {
		return reno;
	}
	public void setReno(String reno) {
		this.reno = reno;
	}
	
	

}
