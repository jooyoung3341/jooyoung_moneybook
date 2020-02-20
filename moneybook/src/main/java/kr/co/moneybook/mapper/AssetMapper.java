package kr.co.moneybook.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.moneybook.domain.Asset;

@Mapper
public interface AssetMapper {

	//자산 추가
	public void asset_insert(Asset asset);
	
	//자산 목록
	public List<Asset> asset_select(String moneybook_name);
	
	//자산 삭제
	public void asset_delete(int ano);
}
