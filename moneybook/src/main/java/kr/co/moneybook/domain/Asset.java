package kr.co.moneybook.domain;

public class Asset {
	private int ano;
	private String moneybook_name;
	private String type;
	private int asset_price;
	  
	public int getAsset_price() { 
		return asset_price; 
	} 
	public void setAsset_price(int asset_price) {
		this.asset_price = asset_price; 
	} 
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public String getMoneybook_name() {
		return moneybook_name;
	}
	public void setMoneybook_name(String moneybook_name) {
		this.moneybook_name = moneybook_name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "Asset [ano=" + ano + ", moneybook_name=" + moneybook_name + ", type=" + type + ", asset_price="
				+ asset_price + "]";
	}
}
