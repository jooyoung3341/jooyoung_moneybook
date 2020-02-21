package kr.co.moneybook.domain;

import org.springframework.security.core.authority.AuthorityUtils;

public class User extends org.springframework.security.core.userdetails.User{


	private static final long serialVersionUID = 1L;

	
	//사용자 정보 
	public User(Moneybook moneybook) {
		super(moneybook.getMoneybook_name(),
				moneybook.getMoneybook_pw(),
				//권한
				AuthorityUtils.createAuthorityList(moneybook.getAuthority_name()));
	}

}
