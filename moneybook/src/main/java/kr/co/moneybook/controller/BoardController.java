package kr.co.moneybook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
}
