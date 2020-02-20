package kr.co.moneybook.mapper.moneybook;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.moneybook.domain.moneybook.Assetprice;

@Mapper
public interface AssetpriceMapper {
	
	//자산내역 추가
	public void assetprice_insert(Assetprice assetprice);
	
	//자산내역 목록
	public List<Assetprice> assetprice_select(int ano);
	
	//자산내역 삭제
	public void assetprice_delete(int pno);
	
	//자산내역 수정 폼
	public Assetprice assetprice_updateform(int pno);
	
	//자산내역 수정
	public void assetprice_update(Assetprice assetprice);

}
