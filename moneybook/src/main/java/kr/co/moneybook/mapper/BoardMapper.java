package kr.co.moneybook.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.co.moneybook.domain.Board;

@Mapper
public interface BoardMapper {

	//지출, 수입 가져오기
	public List<Board> board_status(Map<String, Object> hashBoard_status);
	
	//가계부이야기 등록하기
	public int board_register(Board board);
	
	//가계부이야기 status 삽입
	public void board_status_insert(Board board_status);
	
	//가계부이야기 목록
	public List<Board> board_selete();
	
	//가계부이야기 폼 가져오기
	public Board board_form(int bno);
	
	//가계부이야기 status 가져오기
	public List<Board> board_status_select(int bno);
	
	//가계부이야기 삭제
	public void board_delete(int bno);
	
	//가계부이야기 수정
	public void board_update(Board board);
}
