package kr.co.moneybook.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.co.moneybook.domain.Earnings;

@Mapper
public interface EarningsMapper {

	//수입내역 삽입 
	public void earnings_insert(Earnings earnings);
	
	//수입내역 목록@Param("insert_date") 
	public List<Earnings> earnings_select(Map<String, Object> hashEarnings);
		
	//수입내역 삭제@Param("ino")
	public void earnings_delete(int ino);
	
	//수입내역 수정 폼
	public Earnings earnings_updateform(int ino);
	
	//수입내역 수정
	public void earnings_update(Earnings earnings);
}
