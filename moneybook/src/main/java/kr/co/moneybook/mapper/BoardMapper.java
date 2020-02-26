package kr.co.moneybook.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.co.moneybook.domain.Board;
import kr.co.moneybook.domain.Board_status;

@Mapper
public interface BoardMapper {

	//지출, 수입 가져오기
	public List<Board_status> board_status(Map<String, Object> hashBoard_status);
	
	//가계부이야기 등록하기
	public void board_register(Board board);
	
}
