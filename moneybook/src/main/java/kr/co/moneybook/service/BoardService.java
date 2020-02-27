package kr.co.moneybook.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import kr.co.moneybook.domain.Board_status;

public interface BoardService {

	//지출, 수입 가져오기
	public List<Board_status> board_status(HttpServletRequest request);
	
	//가계부이야기 등록하기
	public boolean board_register(HttpServletRequest request);
}
