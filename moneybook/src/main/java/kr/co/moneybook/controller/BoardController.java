package kr.co.moneybook.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.moneybook.domain.Board_status;
import kr.co.moneybook.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	//게시판 이동
	@RequestMapping(value="moneybook/board", method=RequestMethod.GET)
	public String board() {
		return "board/board";
	}
	
	//게시판 등록 이동
	@RequestMapping(value="moneybook/board_register", method=RequestMethod.GET)
	public String register() {
		return "board/board_register";
	}
	
	//지출, 수입 가져오기
	@RequestMapping(value="moneybook/board/status", method=RequestMethod.GET)
	@ResponseBody
	public List<Board_status> board_status(HttpServletRequest request){
		return boardService.board_status(request);
	}
	
	//가계부이야기 등록하기
	@RequestMapping(value="/board/board_register", method=RequestMethod.POST)
	public String board_register(HttpServletRequest request, RedirectAttributes attr) {
		boardService.board_register(request);
		attr.addFlashAttribute("board_registermsg","게시판 등록 완료!");
		return "redirect:board";
	}
}
