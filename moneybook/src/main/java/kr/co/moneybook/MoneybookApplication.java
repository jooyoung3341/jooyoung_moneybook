package kr.co.moneybook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import kr.co.moneybook.config.DataSourceConfig;

/*
 * 스프링 부트를 실행시키기 위한 핵심코드이다. 프로젝트 생성 시 자동으로 만들어지는 클래스이다.
 * 스프링 부트는 내장톰켓을 지원하여 따로 서버를 돌릴 필요 없이 자바 어플리케이션 실행처럼 실행시키면 톰켓도 내부적으로 같이 실행되는 구조이다. 그러한 실행기능을 run()메소드가 해주게 된다.
 * 첫번째 인자로는 반드시 해당 클래스의 이름이 들어가야한다. 그리고 main()에서 수행이 되야 한다. 또한 핵심 어노테이션인 @SpringBootApplication을 정의해주어야 하고 해당 어노테이션은 설정과 환경을 담당하는 어토네이션 3개가 합쳐진것이다.
 * @Configuration : 클래스를 애플리케이션 컨텍스트의 Bean 정의 소스로 태그
 * @EnableAutoConfiguration : 스프링 부트에게 클래스 패스 설정, 다른 빈, 다양한 속성 설정을 기반으로 빈 추가를 시작하도록 지시함. 기술적으로 Spring Boot는 스케줄링과 관련하여 자동 구성 할것이 없지만 향후 버전이 될 수 있음
 * @ComponentScan : Spring에게 다른 컴포넌트, 구성 및 서비스를 찾도록 지시
*/
@SpringBootApplication
/* @EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class}) */
public class MoneybookApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoneybookApplication.class, args);
	}

}
