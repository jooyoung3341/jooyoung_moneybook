package kr.co.moneybook.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import kr.co.moneybook.domain.Board;

public interface BoardService {

	//지출, 수입 가져오기
	public List<Board> board_status(HttpServletRequest request);
	
	//가계부이야기 등록하기
	public boolean board_register(HttpServletRequest request);
	
	//가계부이야기 목록 
	public List<Board> board_select(HttpServletRequest request);
	
	//가계부이야기 상세보기
	public Board board_detail(HttpServletRequest request);
}
