package kr.co.moneybook.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections4.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.moneybook.domain.AssetPrice;
import kr.co.moneybook.mapper.AssetPriceMapper;
import kr.co.moneybook.service.AssetPriceService;

@Service
public class AssetPriceServiceImpl implements AssetPriceService {

	@Autowired
	private AssetPriceMapper assetpriceMapper;
	
	//자산내역 추가
	@Override
	public void assetprice_insert(HttpServletRequest request) {
		String ano = request.getParameter("ano");
		String price = request.getParameter("price");
		String insert_date = request.getParameter("insert_date");

		AssetPrice assetprice = new AssetPrice();
		assetprice.setAno(Integer.parseInt(ano));
		assetprice.setPrice(Integer.parseInt(price));
		assetprice.setInsert_date(insert_date);
		
		assetpriceMapper.assetprice_insert(assetprice);
	}
	
	//자산내역 목록
	@Override
	public List<AssetPrice> assetprice_select(HttpServletRequest request) {
		String ano = request.getParameter("ano");
		String sort_sub = request.getParameter("sort");
		String sort_flag = request.getParameter("sort_flag"); 
		//뒤에 _sort 단어 제거
		String sort = sort_sub.replace("_sort", "");
		
		Map<String, Object> hashAssetprice = new HashMap<String, Object>();
		hashAssetprice.put("ano", ano);
		hashAssetprice.put("sort", sort);
		hashAssetprice.put("sort_flag", sort_flag);
		
		return assetpriceMapper.assetprice_select(hashAssetprice);
	}

	//자산내역 삭제
	@Override
	public void assetprice_delete(HttpServletRequest request) {
		String [] checkArr = request.getParameterValues("checkArr");

		for(String pno : checkArr) {
			assetpriceMapper.assetprice_delete(Integer.parseInt(pno));
		}
	}

	//자산내역 수정 폼
	@Override
	public AssetPrice assetprice_updateform(HttpServletRequest request) {
		String pno = request.getParameter("pno");
		return assetpriceMapper.assetprice_updateform(Integer.parseInt(pno));
	}

	//자산내역 수정
	@Override
	public void assetprice_update(HttpServletRequest request) {
		String pno = request.getParameter("pno");
		String price = request.getParameter("price");
		String insert_date = request.getParameter("insert_date");
		
		AssetPrice assetprice = new AssetPrice();
		assetprice.setPno(Integer.parseInt(pno));
		assetprice.setInsert_date(insert_date);
		assetprice.setPrice(Integer.parseInt(price));
		
		assetpriceMapper.assetprice_update(assetprice);
	}

}
