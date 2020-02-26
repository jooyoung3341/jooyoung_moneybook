package kr.co.moneybook.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import kr.co.moneybook.domain.Board;
import kr.co.moneybook.domain.Board_status;
import kr.co.moneybook.domain.User;
import kr.co.moneybook.mapper.BoardMapper;
import kr.co.moneybook.service.BoardService;


@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper boardMapper;

	//지출, 수입 가져오기
	@Override
	public List<Board_status> board_status(HttpServletRequest request) {
		User user =  (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String moneybook_name = user.getUsername();
		String insert_date = request.getParameter("insert_date");
		
		Map<String, Object> hashBoard_status = new HashMap<String, Object>();
		hashBoard_status.put("insert_date", insert_date);
		hashBoard_status.put("moneybook_name", moneybook_name);
		
		return boardMapper.board_status(hashBoard_status);
	}

	//가계부이야기 등록하기
	@Override
	public void board_register(HttpServletRequest request) {
		//현재날짜,시간 가져오기
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar time = Calendar.getInstance();
		String insert_date = format.format(time.getTime());
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String moneybook_name = user.getUsername();
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		Board board = new Board();
		board.setInsert_date(insert_date);
		board.setMoneybook_name(moneybook_name);
		board.setTitle(title);
		board.setContent(content);
		
		boardMapper.board_register(board);		
	}
}
