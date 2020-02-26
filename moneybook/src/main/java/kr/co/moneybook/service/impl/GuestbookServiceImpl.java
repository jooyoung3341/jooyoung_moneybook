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
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar time = Calendar.getInstance();
		
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String moneybook_name = user.getUsername();
		String content = request.getParameter("content");
		String insert_date = format.format(time.getTime());
		
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
}
