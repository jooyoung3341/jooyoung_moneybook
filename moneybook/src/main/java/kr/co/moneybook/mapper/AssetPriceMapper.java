package kr.co.moneybook.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.co.moneybook.domain.AssetPrice;

@Mapper
public interface AssetPriceMapper {
	
	//자산내역 추가
	public void assetprice_insert(AssetPrice assetprice);
	
	//자산내역 목록
	public List<AssetPrice> assetprice_select(Map<String, Object> hashAssetprice);
	
	//자산내역 삭제
	public void assetprice_delete(int pno);
	
	//자산내역 수정 폼
	public AssetPrice assetprice_updateform(int pno);
	
	//자산내역 수정
	public void assetprice_update(AssetPrice assetprice);

}
