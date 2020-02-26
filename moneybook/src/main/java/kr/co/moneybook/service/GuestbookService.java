package kr.co.moneybook.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import kr.co.moneybook.domain.Guestbook;

public interface GuestbookService {

	//방명록 등록
	public void guestbook_insert(HttpServletRequest request);
	
	public List<Guestbook> guestbook_select();
}
