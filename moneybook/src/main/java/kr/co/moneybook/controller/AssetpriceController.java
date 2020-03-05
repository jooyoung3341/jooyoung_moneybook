package kr.co.moneybook.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.moneybook.domain.Assetprice;
import kr.co.moneybook.service.AssetpriceService;

@Controller
public class AssetpriceController {

	@Autowired
	private AssetpriceService assetpriceService;
	
	//자산내역 추가
	@RequestMapping(value="moneybook/assetprice/insert", method=RequestMethod.POST)
	@ResponseBody
	public void asset_insert(HttpServletRequest request) {
		assetpriceService.assetprice_insert(request);
	}
	
	//자산내역 목록
	@RequestMapping(value="moneybook/assetprice/select", method=RequestMethod.GET)
	@ResponseBody
	public List<Assetprice> assetprice(HttpServletRequest request) {
		return assetpriceService.assetprice_select(request);
	}
	
	//자산내역 삭제
	@RequestMapping(value="moneybook/assetprice/delete", method=RequestMethod.GET)
	@ResponseBody
	public void assetprice_delete(HttpServletRequest request) {
		assetpriceService.assetprice_delete(request);
	}
	
	//자산내역 수정 폼
	@RequestMapping(value="moneybook/assetprice/updateform", method=RequestMethod.GET)
	@ResponseBody
	public Assetprice assetprice_updateform(HttpServletRequest request) {
		return assetpriceService.assetprice_updateform(request);
	}
	
	//자산내역 수정
	@RequestMapping(value="moneybook/assetprice/update", method=RequestMethod.POST)
	@ResponseBody
	public void assetprice_update(HttpServletRequest request) {
		assetpriceService.assetprice_update(request);
	}
}
