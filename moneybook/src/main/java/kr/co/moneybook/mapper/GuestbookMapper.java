package kr.co.moneybook.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.moneybook.domain.Guestbook;

@Mapper
public interface GuestbookMapper {

	//방명록 등록
	public void guestbook_insert(Guestbook guestbook);
	
	//방명록 목록
	public List<Guestbook> guestbook_select();
	
	//방명록 삭제
	public void guestbook_delete(int gno);
	
	//방명록 수정 폼
	public Guestbook guestbook_update_form(int gno);
	
	//방명록 수정
	public void guestbook_update(Guestbook guestbook);
}
