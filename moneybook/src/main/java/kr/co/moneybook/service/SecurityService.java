package kr.co.moneybook.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SecurityService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String moneybook_name) throws UsernameNotFoundException {
			
		return null;
	}

}
