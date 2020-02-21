package kr.co.moneybook.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.moneybook.domain.Asset;
import kr.co.moneybook.service.AssetService;

@Controller
public class AssetController {

	@Autowired
	private AssetService assetService;
	
	//자산 이동
	@RequestMapping(value="moneybook/asset", method=RequestMethod.GET)
	public String asset(HttpServletRequest request, Model model) {
		List<Asset> assetlist = assetService.asset_select(request);
		model.addAttribute("assetlist", assetlist);
		return "moneybook/asset";
	}
	
	//자산 목록
	@RequestMapping(value="moneybook/asset/select", method=RequestMethod.GET)
	@ResponseBody
	public List<Asset> asset_select(HttpServletRequest request){
		return assetService.asset_select(request);
	}
	
	//자산 추가
	@RequestMapping(value="moneybook/asset/insert", method=RequestMethod.POST)
	@ResponseBody
	public void asset_insert(HttpServletRequest request) {
		assetService.asset_insert(request);
	}
	
	//자산 삭제
	@RequestMapping(value="moneybook/asset/delete")
	@ResponseBody
	public void asset_delete(HttpServletRequest request){
		assetService.asset_delete(request);
	}
	
}
