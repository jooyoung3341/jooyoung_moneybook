package kr.co.moneybook.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import kr.co.moneybook.domain.Asset;
import kr.co.moneybook.domain.Moneybook;
import kr.co.moneybook.domain.User;
import kr.co.moneybook.mapper.AssetMapper;

@Service
public class AssetServiceImpl implements AssetService {

	@Autowired
	private AssetMapper assetMapper;
	
	//자산 추가
	@Override
	public void asset_insert(HttpServletRequest request) {
		User user =  (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String moneybook_name = user.getUsername();
		String type = request.getParameter("type");
		
		Asset asset = new Asset();
		asset.setMoneybook_name(moneybook_name);
		asset.setType(type);
		 
		assetMapper.asset_insert(asset);
	}

	//자산 목록
	@Override
	public List<Asset> asset_select(HttpServletRequest request) {
		User user =  (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String moneybook_name = user.getUsername();
		return assetMapper.asset_select(moneybook_name);
	}

	//자산 삭제
	@Override
	public void asset_delete(HttpServletRequest request) {
		String ano = request.getParameter("ano");
		assetMapper.asset_delete(Integer.parseInt(ano));
	}

}
