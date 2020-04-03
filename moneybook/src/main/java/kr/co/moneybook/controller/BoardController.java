package kr.co.moneybook.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.moneybook.domain.Board;
import kr.co.moneybook.domain.Criteria;
import kr.co.moneybook.domain.SearchCriteria;
import kr.co.moneybook.domain.User;
import kr.co.moneybook.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	//게시판 이동
	@RequestMapping(value="moneybook/board", method=RequestMethod.GET)
	public String board(Model model, SearchCriteria criteria) {
		Map<String, Object> map = boardService.board_select(criteria);
		//map에는 board_list, pageMaker 가 들어 있음
		model.addAttribute("map", map);
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
	public List<Board> board_status(HttpServletRequest request){
		return boardService.board_status(request);
	}
	
	//가계부이야기 등록하기
	@RequestMapping(value="board/board_register", method=RequestMethod.POST)
	public String board_register(HttpServletRequest request, RedirectAttributes attr) {
		boardService.board_register(request);
		attr.addFlashAttribute("board_registermsg","게시판 등록 완료!");
		return "redirect:/moneybook/board";
	}
	
	//가계부이야기 상세보기
	@RequestMapping(value="moneybook/board_detail", method= RequestMethod.GET)
	public String board_detail(SearchCriteria criteria, HttpServletRequest request, Model model) {
		Board board = boardService.board_detail(request);
		List<Board> board_status = boardService.board_status_select(request);
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("keyword", criteria.getKeyword());
		model.addAttribute("page", criteria.getPage());		
		model.addAttribute("perPageNum",criteria.getPerPageNum());
		model.addAttribute("moneybook_name", user.getUsername());
		model.addAttribute("board", board);
		model.addAttribute("board_status", board_status);
		return "board/board_detail";
	}
	
	//가계부이야기 삭제
	@RequestMapping(value="moneybook/board_delete", method=RequestMethod.GET)
	public String board_delete(HttpServletRequest request, RedirectAttributes attr) {
		boardService.board_delete(request);
		attr.addFlashAttribute("board_deletemsg","삭제 완료!");
		return "redirect:/moneybook/board";
	}
	
	//가계부이야기 수정 폼
	@RequestMapping(value="moneybook/board_update", method=RequestMethod.GET)
	public String board_update(HttpServletRequest request, Model model, SearchCriteria criteria) {
		Board board = boardService.board_updateform(request);
		model.addAttribute("page", criteria.getPage());
		model.addAttribute("keyword", criteria.getKeyword());
		model.addAttribute("board", board);
		return "board/board_update";
	}
	
	//가계부이야기 수정
	@RequestMapping(value="board/board_update", method=RequestMethod.POST)
	public String board_update(HttpServletRequest request, RedirectAttributes attr) {
		boardService.board_update(request);
		attr.addFlashAttribute("board_updatemsg", "수정 완료!");
		return "redirect:/moneybook/board";
	}
}



