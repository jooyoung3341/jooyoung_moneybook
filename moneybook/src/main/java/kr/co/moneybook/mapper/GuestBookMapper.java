package kr.co.moneybook.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.moneybook.domain.GuestBook;

@Mapper
public interface GuestBookMapper {

	//방명록 등록
	public void guestbook_insert(GuestBook guestbook);
	
	//방명록 목록
	public List<GuestBook> guestbook_select();
	
	//방명록 삭제
	public void guestbook_delete(int gno);
	
	//방명록 수정 폼
	public GuestBook guestbook_update_form(int gno);
	
	//방명록 수정
	public void guestbook_update(GuestBook guestbook);
}
