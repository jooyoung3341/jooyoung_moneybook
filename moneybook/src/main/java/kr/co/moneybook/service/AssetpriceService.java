package kr.co.moneybook.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import kr.co.moneybook.domain.Assetprice;

public interface AssetpriceService {
	
	//자산내역 추가
	public void assetprice_insert(HttpServletRequest request);
	
	//자산내역 목록
	public List<Assetprice> assetprice_select(HttpServletRequest request);

	//자산내역 삭제
	public void assetprice_delete(HttpServletRequest request);
	
	//자산내역 수정 폼
	public Assetprice assetprice_updateform(HttpServletRequest request);
	
	//자산내역 수정
	public void assetprice_update(HttpServletRequest request);
}
