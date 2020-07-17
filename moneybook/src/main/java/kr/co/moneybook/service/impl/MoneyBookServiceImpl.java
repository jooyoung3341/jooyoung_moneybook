package kr.co.moneybook.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.co.moneybook.domain.MoneyBook;
import kr.co.moneybook.domain.User;
import kr.co.moneybook.mapper.MoneyBookMapper;
import kr.co.moneybook.service.MoneyBookService;

@Service
public class MoneyBookServiceImpl implements MoneyBookService {
	
	@Autowired
	private MoneyBookMapper moneybookMapper;

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
		//현재날짜,시간 가져오기
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar time = Calendar.getInstance();
		String insert_date = format.format(time.getTime());
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		//암호화 되지 않은 암호
		String rawPass = request.getParameter("pw");
		String moneybook_name = request.getParameter("name");
		//암호화 된 암호
		String moneybook_pw = passwordEncoder.encode(rawPass);

		
		MoneyBook moneybook= new MoneyBook();
		moneybook.setMoneybook_name(moneybook_name);
		moneybook.setMoneybook_pw(moneybook_pw);
		moneybook.setInsert_date(insert_date);
		
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
	  MoneyBook moneybook = moneybookMapper.readMoneybook(moneybook_name);
		  
	  if(moneybook == null) { 
		  throw new UsernameNotFoundException(moneybook_name);
	  }
		 //UsernameNotFoundException
		return new User(moneybook); 
	}

	/*
	 * admin
	*/
	
	//가입된 사용자 가져오기
	@Override
	public List<MoneyBook> moneybook_select() {
		return moneybookMapper.moneybook_select();
	}

	//가계부 삭제
	@Override
	public void moneybookDelete(HttpServletRequest request) {
		String [] checkArr = request.getParameterValues("checkArr");
		for (String moneybook_name : checkArr) {
			moneybookMapper.moneybookDelete(moneybook_name);
		}
		
	}

}
