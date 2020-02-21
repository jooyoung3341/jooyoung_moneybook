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

}
