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
import kr.co.moneybook.domain.Criteria;
import kr.co.moneybook.domain.PageMaker;
import kr.co.moneybook.domain.SearchCriteria;
import kr.co.moneybook.domain.User;
import kr.co.moneybook.mapper.BoardMapper;
import kr.co.moneybook.service.BoardService;


@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper boardMapper;

	//지출, 수입 가져오기
	@Override
	public List<Board> board_status(HttpServletRequest request) {
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
		
		//배열값 받기
		String [] price_str = request.getParameterValues("price");
		//스트림을 이용한 String 배열 -> int 배열로 형변환
		int [] price_arr = Arrays.stream(price_str).mapToInt(Integer::parseInt).toArray();
		String [] moneybook_type_arr = request.getParameterValues("moneybook_type");
		String [] cartegory_arr = request.getParameterValues("cartegory");
		String [] insert_date_status_arr = request.getParameterValues("board_date");
		
		/* Board board_status = new Board(); */
		//for index 값
		int index = 0;
		//board insert 성공 시 board_status에 지출/수입 내역 삽입
		if(r > 0)
				for(String idx : price_str) {
					//배열값 하나하나씩 받아 mapper로 값 넘기기
					String moneybook_type = moneybook_type_arr[index];
					String cartegory = cartegory_arr[index];
					int price= price_arr[index];
					String board_date = insert_date_status_arr[index];
					
					board.setCartegory(cartegory);
					board.setBoard_date(board_date);
					board.setMoneybook_type(moneybook_type);
					board.setPrice(price);
					boardMapper.board_status_insert(board);
					index += 1;
				}
			result = true;
		return result;
	}

	//가계부이야기 목록
	@Override
	public Map<String, Object> board_select(SearchCriteria criteria) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<Board> board_list = boardMapper.board_selete(criteria);
		//map에 게시글 리스트 추가
		map.put("board_list", board_list);
		
		PageMaker pageMaker = new PageMaker();
		//Criteria(출력 중인 번호, 출력할 데이터 개수, 출력될 데이터의 시작 번호 ) pageMaker에 set
		pageMaker.setCriteria(criteria);
		//전체 게시글 set
		pageMaker.setTotalCount(boardMapper.board_totalcount(criteria));
		//map에 추가
		map.put("pageMaker", pageMaker);
		return map;
	}

	//가계부이야기 상세보기
	@Override
	public Board board_detail(HttpServletRequest request) {
		User user =  (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String moneybook_name = user.getUsername();
		String bno = request.getParameter("bno");
		
		//게시글 조회수 +1
		boardMapper.board_readcnt(Integer.parseInt(bno));
		Map<String, Object> hashBoard = new HashMap<String, Object>();
		hashBoard.put("bno", Integer.parseInt(bno));
		hashBoard.put("moneybook_name", moneybook_name);
		return boardMapper.board_detail(hashBoard);
	}
	
	//가계부이야기 status 가져오기
	public List<Board> board_status_select(HttpServletRequest request){
		String bno = request.getParameter("bno");
		return boardMapper.board_status_select(Integer.parseInt(bno));
	}

	//가계부이야기 삭제
	@Override
	public void board_delete(HttpServletRequest request) {
		String bno = request.getParameter("bno");
		boardMapper.board_delete(Integer.parseInt(bno));		
	}

	//가계부이야기 수정
	@Override
	public void board_update(HttpServletRequest request) {
		String bno = request.getParameter("bno");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar time = Calendar.getInstance();
		String insert_date = format.format(time.getTime());
		
		Board board = new Board();
		board.setBno(Integer.parseInt(bno));
		board.setTitle(title);
		board.setContent(content);
		board.setInsert_date(insert_date);
		
		boardMapper.board_update(board);
	}

	//가계부이야기 수정 폼
	@Override
	public Board board_updateform(HttpServletRequest request) {
		String bno = request.getParameter("bno");
		return boardMapper.board_updateform(Integer.parseInt(bno));
	}
	
}
