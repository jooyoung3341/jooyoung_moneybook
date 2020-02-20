package kr.co.moneybook.mapper.user;

import org.apache.ibatis.annotations.Mapper;

import kr.co.moneybook.domain.user.Moneybook;

@Mapper
public interface MoneybookMapper {

	//가계부 이름 중복 확인
	public String moneybook_name_check(String moneybook_name);
	
	//가계부 등록
	public int moneybookRegister(Moneybook moneybook);
	
	//권한 등록
	public void authorityRegister(Moneybook moneybook);
	
	//가계부 정보 가져오기
	public Moneybook readMoneybook(String moneybook_name);

}
