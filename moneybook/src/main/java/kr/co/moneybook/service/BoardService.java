package kr.co.moneybook.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import kr.co.moneybook.domain.Board;
import kr.co.moneybook.domain.Criteria;

public interface BoardService {

	//지출, 수입 가져오기
	public List<Board> board_status(HttpServletRequest request);
	
	//가계부이야기 등록하기
	public boolean board_register(HttpServletRequest request);
	
	//가계부이야기 목록 
	public Map<String, Object> board_select(Criteria criteria);
	
	//가계부이야기 상세보기
	public Board board_detail(HttpServletRequest request);
	
	//가계부이야기 status 가져오기
	public List<Board> board_status_select(HttpServletRequest request);
	
	//가계부이야기 삭제하기
	public void board_delete(HttpServletRequest request);
	
	//가계부이야기 수정 폼
	public Board board_updateform(HttpServletRequest request);
	
	//가계부이야기 수정
	public void board_update(HttpServletRequest request);
}
