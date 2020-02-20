package kr.co.moneybook.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import kr.co.moneybook.domain.Asset;

public interface AssetService {

	//자산 추가
	public void asset_insert(HttpServletRequest request);
	
	//자산 목록
	public List<Asset> asset_select(HttpServletRequest request);
	
	//자산 삭제
	public void asset_delete(HttpServletRequest request);
}
