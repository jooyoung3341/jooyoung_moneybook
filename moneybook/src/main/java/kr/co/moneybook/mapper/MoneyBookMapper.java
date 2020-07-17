package kr.co.moneybook.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.moneybook.domain.MoneyBook;

@Mapper
public interface MoneyBookMapper {

	//가계부 이름 중복 확인
	public String moneybook_name_check(String moneybook_name);
	
	//가계부 등록
	public int moneybookRegister(MoneyBook moneybook);
	
	//권한 등록
	public void authorityRegister(MoneyBook moneybook);
	
	//가계부 정보 가져오기
	public MoneyBook readMoneybook(String moneybook_name);

	/*
	 * admin
	*/
	
	//가입된 가계부 가져오기
	public List<MoneyBook> moneybook_select();
	
	//가계부 삭제
	public void moneybookDelete(String moneybook_name);
}
