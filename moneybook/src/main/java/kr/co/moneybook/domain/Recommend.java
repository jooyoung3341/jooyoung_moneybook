package kr.co.moneybook.domain;

public class Recommend {
	private int reno;
	private int bno;
	private String moneybook_name;
    private String status;
    private String recommendStatus;
    
    
    
	public String getRecommendStatus() {
		return recommendStatus;
	}
	public void setRecommendStatus(String recommendStatus) {
		this.recommendStatus = recommendStatus;
	}
	public int getReno() {
		return reno;
	}
	public void setReno(int reno) {
		this.reno = reno;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
    
    
}
