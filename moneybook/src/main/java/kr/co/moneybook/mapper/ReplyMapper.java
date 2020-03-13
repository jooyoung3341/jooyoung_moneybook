package kr.co.moneybook.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.moneybook.domain.Reply;

@Mapper
public interface ReplyMapper {

	//댓글 삽입
	public void reply_insert(Reply reply);
	
	//댓글 목록	       
	public List<Reply> reply_select(int bno);
	
	//댓글 삭제
	public void reply_delete(int rno);
	
	//댓글 수정 폼
	public Reply reply_update_form(int rno);
	
	//댓글 수정
	public void reply_update(Reply reply);
}
