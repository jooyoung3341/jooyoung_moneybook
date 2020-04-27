package kr.co.moneybook.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
//<annotation-driven>
@EnableTransactionManagement
@MapperScan(basePackages="kr.co.moneybook.mapper")
public class MybatisConfig {
	
	
	/*
	 * DataSource를 parameter로 받아, sqlSessionFactory를 생성하는 Bean
	 * 여기서 만들어진 기본정보, 설정값 등을 이용해서 SqlSessionTemplate를 만들게 됨
	*/
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
		final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		sessionFactory.setDataSource(dataSource);
		sessionFactory.setTypeAliasesPackage("kr.co.moneybook.domain");
		//실제 Query문이 존재하는 xml파일들의 위치를 지정해 준다.
		sessionFactory.setMapperLocations(resolver.getResources("classpath:mybatis/mapper/*.xml"));
		return sessionFactory.getObject();
	}
	
	//실제 DB접속에 이용되는 SqlSessionTemplate를 생성하여 반환하는 Bean, 실제 코드상에서 이용된다고 보면 됨.
	@Bean
	public SqlSessionTemplate sessionTemplate(SqlSessionFactory sessionFactory) throws Exception{
		final SqlSessionTemplate sessionTemplate = new SqlSessionTemplate(sessionFactory);
		return sessionTemplate;
	}

}

