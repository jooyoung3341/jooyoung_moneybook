package kr.co.moneybook.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.co.moneybook.domain.Moneybook;
import kr.co.moneybook.domain.User;
import kr.co.moneybook.mapper.MoneybookMapper;

@Service
public class MoneybookServiceImpl implements MoneybookService {
	
	@Autowired
	private MoneybookMapper moneybookMapper;

	//가계부 이름 중복 확인
	@Override
	public String moneybook_name_check(HttpServletRequest request) {
		String moneybook_name = request.getParameter("moneybook_name");
		return moneybookMapper.moneybook_name_check(moneybook_name);
	}
	
	//가계부 등록
	@Override
	public boolean register(HttpServletRequest request) throws Exception {
		boolean result = false;
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		//암호화 되지 않은 암호
		String rawPass = request.getParameter("pw");
		String moneybook_name = request.getParameter("name");
		String moneybook_pw = passwordEncoder.encode(rawPass);

		
		Moneybook moneybook= new Moneybook();
		moneybook.setMoneybook_name(moneybook_name);
		moneybook.setMoneybook_pw(moneybook_pw);

		
		int r = moneybookMapper.moneybookRegister(moneybook);
		String authority_name = request.getParameter("authority_name");
		if(r > 0)
			//회원가입 성공 시 권한 함께 등록
			moneybook.setAuthority_name(authority_name);
			moneybook.setMoneybook_name(moneybook_name);
			moneybookMapper.authorityRegister(moneybook);
			result = true;
		return result;
	}


	//사용자 정보 가져오기
	@Override
	public UserDetails loadUserByUsername(String moneybook_name) throws UsernameNotFoundException {
	  Moneybook moneybook = moneybookMapper.readMoneybook(moneybook_name);
		  
	  if(moneybook == null) { 
		  throw new UsernameNotFoundException(moneybook_name);
	  }
		 //UsernameNotFoundException
		return new User(moneybook); 
	}

}
