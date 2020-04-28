package kr.co.moneybook.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import kr.co.moneybook.domain.Moneybook;

public interface MoneybookService extends UserDetailsService{

	//가계부 이름 중복 확인
	public String moneybook_name_check(HttpServletRequest request);
	
	//가계부 등록
	public boolean register(HttpServletRequest request) throws Exception;
	
	/*
	 * admin
	 */	
	
	//가입된 가계부 가져오기
	public List<Moneybook> moneybook_select();

	//가계부 삭제
	public void moneybookDelete(HttpServletRequest request);
	
}
