package kr.co.moneybook.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import kr.co.moneybook.domain.Reply;
import kr.co.moneybook.domain.User;
import kr.co.moneybook.mapper.BoardMapper;
import kr.co.moneybook.mapper.ReplyMapper;
import kr.co.moneybook.service.ReplyService;

@Service
public class ReplyServiceImpl implements ReplyService {
	
	@Autowired
	private ReplyMapper replyMapper;
	@Autowired 
	private BoardMapper boardMapper;

	//댓글 삽입
	@Override
	public void reply_insert(HttpServletRequest request) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar time = Calendar.getInstance();
		String insert_date = format.format(time.getTime());
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String moneybook_name = user.getUsername();
		String content = request.getParameter("content");
		String bno = request.getParameter("bno");
		
		Reply reply = new Reply();
		reply.setContent(content);
		reply.setMoneybook_name(moneybook_name);
		reply.setInsert_date(insert_date);
		reply.setBno(Integer.parseInt(bno));
		
		replyMapper.reply_insert(reply);
		//댓글 등록 시 board테이블 reply에 +1 추가
		boardMapper.board_reply(Integer.parseInt(bno));
	}

	//댓글 목록
	@Override
	public List<Reply> reply_select(HttpServletRequest request) {
		String bno = request.getParameter("bno");
		return replyMapper.reply_select(Integer.parseInt(bno));
	}

	//댓글 삭제
	@Override
	public void reply_delete(HttpServletRequest request) {
		String rno = request.getParameter("rno");
		String bno = request.getParameter("bno");
		replyMapper.reply_delete(Integer.parseInt(rno));
		//댓글 삭제 시 board테이블 reply에 -1
		boardMapper.board_reply_delete(Integer.parseInt(bno));
	}

	//댓글 수정 폼
	@Override
	public Reply reply_update_form(HttpServletRequest request) {
		String rno = request.getParameter("rno");
		return replyMapper.reply_update_form(Integer.parseInt(rno));
	}

	//댓글 수정
	@Override
	public void reply_update(HttpServletRequest request) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar time = Calendar.getInstance();
		String insert_date = format.format(time.getTime());
		String rno = request.getParameter("rno");
		String content = request.getParameter("content");
		
		Reply reply = new Reply();
		reply.setRno(Integer.parseInt(rno));
		reply.setContent(content);
		reply.setInsert_date(insert_date);
		
		replyMapper.reply_update(reply);
	}
	
	

}
