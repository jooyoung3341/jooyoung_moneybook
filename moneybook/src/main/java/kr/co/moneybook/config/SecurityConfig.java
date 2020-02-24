package kr.co.moneybook.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import kr.co.moneybook.domain.Moneybook;
import kr.co.moneybook.service.MoneybookService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private MoneybookService moneybookService;
	/*
	 * security에서 제공하는 비밀번호 암호화 객체
	 * Service에서 암호화할 수 있도록 Bean으로 등록
	*/
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	//DB로부터 아이디, 비번이 맞는지 해당 유저가 어떤 권한을 가지는지를 체크한다.
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//실제 인증을 진행할 Provider
		auth.userDetailsService(moneybookService).passwordEncoder(passwordEncoder());
	}
	
	@Override
	public void configure(WebSecurity web) {
		//이미지, 자바스크립트, css 디렉토리 보안 설정 (항상 통과)
		web.ignoring().antMatchers("/static/bootswatch","/templates/fragments/**","templates/layout/**");
	}
	
	//URL별 권한 설정, 로그인, 세션 등등 HTTP 보안 관련 설정
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.csrf().disable();
		//Http 관련 보안 설정 **가장 중요
		http.	authorizeRequests()
		//페이지 권한 설정
			.antMatchers("/admin/**").hasRole("ADMIN") // ADMIN 로그인된 사용자 접근 가능
			.antMatchers("/moneybook/**","/moneybook/**/**").hasRole("USER")//USER 로그인된 사용자 접근 가능
			.antMatchers("/").permitAll() // 모든사용자 접근 가능
		//	.anyRequest().permitAll()			
		.and()
			.formLogin()
			.loginPage("/") //로그인 페이지 url
			.loginProcessingUrl("/login") // 로그인 처리 url
			.failureUrl("/?error") //실패시 url
			.defaultSuccessUrl("/moneybook/moneybook") //성공 시 이동할 url
			.usernameParameter("moneybook_name")//아이디 파라미터 값 이름
			.passwordParameter("moneybook_pw")//패스워드 파라미터 값 이름
			.permitAll() // 모든사용자 접근 가능 권한
		.and()
			.logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout")) // 로그아웃 url
			.logoutSuccessUrl("/") //로그아웃 성공 시 이동할 url
			.invalidateHttpSession(true); // 세션 초기화
	}
	

	
}
