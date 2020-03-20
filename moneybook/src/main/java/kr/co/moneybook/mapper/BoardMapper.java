package kr.co.moneybook.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.co.moneybook.domain.Board;
import kr.co.moneybook.domain.Criteria;
import kr.co.moneybook.domain.SearchCriteria;

@Mapper
public interface BoardMapper {

	//지출, 수입 가져오기
	public List<Board> board_status(Map<String, Object> hashBoard_status);
	
	//가계부이야기 등록하기
	public int board_register(Board board);
	
	//가계부이야기 status 삽입
	public void board_status_insert(Board board_status);
	
	//가계부이야기 목록
	public List<Board> board_selete(SearchCriteria criteria);
	
	//가계부이야기 전체 가져오기
	public int board_totalcount(SearchCriteria criteria);
	
	//가계부이야기 폼 가져오기
	public Board board_detail(int bno);
	
	//가계부이야기 조회수
	public void board_readcnt(int bno);
	
	//가계부이야기 status 가져오기
	public List<Board> board_status_select(int bno);
	
	public Board board_test();
	
	//가계부이야기 삭제
	public void board_delete(int bno);
	
	//가계부이야기 수정 폼
	public Board board_updateform(int bno);
	
	//가계부이야기 수정
	public void board_update(Board board);
}
