package kr.co.moneybook.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.moneybook.domain.Assetprice;
import kr.co.moneybook.mapper.AssetpriceMapper;
import kr.co.moneybook.service.AssetpriceService;

@Service
public class AssetpriceServiceImpl implements AssetpriceService {

	@Autowired
	private AssetpriceMapper assetpriceMapper;
	
	//자산내역 추가
	@Override
	public void assetprice_insert(HttpServletRequest request) {
		String ano = request.getParameter("ano");
		String price = request.getParameter("price");
		String insert_date = request.getParameter("insert_date");

		Assetprice assetprice = new Assetprice();
		assetprice.setAno(Integer.parseInt(ano));
		assetprice.setPrice(Integer.parseInt(price));
		assetprice.setInsert_date(insert_date);
		
		assetpriceMapper.assetprice_insert(assetprice);
	}
	
	//자산내역 목록
	@Override
	public List<Assetprice> assetprice_select(HttpServletRequest request) {
		String ano = request.getParameter("ano");
		return assetpriceMapper.assetprice_select(Integer.parseInt(ano));
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
	public Assetprice assetprice_updateform(HttpServletRequest request) {
		String pno = request.getParameter("pno");
		return assetpriceMapper.assetprice_updateform(Integer.parseInt(pno));
	}

	//자산내역 수정
	@Override
	public void assetprice_update(HttpServletRequest request) {
		String pno = request.getParameter("pno");
		String price = request.getParameter("price");
		String insert_date = request.getParameter("insert_date");
		
		Assetprice assetprice = new Assetprice();
		assetprice.setPno(Integer.parseInt(pno));
		assetprice.setInsert_date(insert_date);
		assetprice.setPrice(Integer.parseInt(price));
		
		assetpriceMapper.assetprice_update(assetprice);
	}

}
