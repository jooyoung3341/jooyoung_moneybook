package kr.co.moneybook.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import kr.co.moneybook.domain.Guestbook;
import kr.co.moneybook.domain.User;
import kr.co.moneybook.mapper.GuestbookMapper;
import kr.co.moneybook.service.GuestbookService;

@Service
public class GuestbookServiceImpl implements GuestbookService {

	@Autowired
	private GuestbookMapper guestbookMapper;

	//방명록 등록
	@Override
	public void guestbook_insert(HttpServletRequest request) {
		//현재 날짜,시간과 로그인 한 세션이름
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar time = Calendar.getInstance();
		String insert_date = format.format(time.getTime());
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String moneybook_name = user.getUsername();
		String content = request.getParameter("content");
		
		
		Guestbook guestbook = new Guestbook();
		guestbook.setContent(content);
		guestbook.setInsert_date(insert_date);
		guestbook.setMoneybook_name(moneybook_name);
		
		guestbookMapper.guestbook_insert(guestbook);
	}

	//방명록 목록
	@Override
	public List<Guestbook> guestbook_select() {
		return guestbookMapper.guestbook_select();
	}

	//방명록 삭제
	@Override
	public void guestbook_delete(HttpServletRequest request) {
		String gno = request.getParameter("gno");
		guestbookMapper.guestbook_delete(Integer.parseInt(gno));
	}

	//방명록 수정 폼 
	@Override
	public Guestbook guestbook_update_form(HttpServletRequest request) {
		String gno = request.getParameter("gno");
		return guestbookMapper.guestbook_update_form(Integer.parseInt(gno));
	}

	//방명록 수정
	@Override
	public void guestbook_update(HttpServletRequest request) {
		String gno = request.getParameter("gno");
		String content = request.getParameter("content");
		
		Guestbook guestbook = new Guestbook();
		guestbook.setContent(content);
		guestbook.setGno(Integer.parseInt(gno));
		
		guestbookMapper.guestbook_update(guestbook);
	}
}
