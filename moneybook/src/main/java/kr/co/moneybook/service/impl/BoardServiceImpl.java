package kr.co.moneybook.service.impl;

import java.text.SimpleDateFormat;
import java.util.Arrays;
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
	public boolean board_register(HttpServletRequest request) {
		boolean result = false;
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
		
		int r = boardMapper.board_register(board);
		
		
		String [] price1 = request.getParameterValues("price");
		//스트림을 이용한 String 배열 -> int 배열로 형변환
		int [] price = Arrays.stream(price1).mapToInt(Integer::parseInt).toArray();
		String [] moneybook_type = request.getParameterValues("moneybook_type");
		String [] cartegory = request.getParameterValues("cartegory");
		String [] insert_date_status = request.getParameterValues("insert_date");
		Board_status board_status = new Board_status();
		if(r > 0)
			for(String idx : price1) {
				board_status.setCartegory(cartegory);
				board_status.setInsert_date_status(insert_date_status);
				board_status.setMoneybook_type(moneybook_type);
				board_status.setPrice(price);
				boardMapper.board_status_insert(board_status);
			}
			result = true;
		return result;
		

	}
}
