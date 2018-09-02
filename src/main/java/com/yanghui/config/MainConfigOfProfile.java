package com.yanghui.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@PropertySource("classpath:dbconfig.properties")
public class MainConfigOfProfile {

	@Value("${jdbc.username}")
	private String user;
	
	@Value("${jdbc.password}")
	private String password;
	
	@Value("${jdbc.driver}")
	private String driver;
	
	@Value("${jdbc.testurl}")
	private String jdbcTestUrl;
	
	@Value("${jdbc.devurl}")
	private String jdbcDevUrl;
	
	@Value("${jdbc.produrl}")
	private String jdbcProdUrl;
	
	/*@Bean
	public DataSource dataSource(@Value("${jdbc.password}")String pwd) throws Exception {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setUser(user);
		dataSource.setPassword(pwd);
		dataSource.setJdbcUrl(jdbcTestUrl);
		dataSource.setDriverClass(driver);
		return dataSource;
	}*/
	
	@Bean
	public DataSource dataSourceTest() throws Exception {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setUser(user);
		dataSource.setPassword(password);
		dataSource.setJdbcUrl(jdbcTestUrl);
		dataSource.setDriverClass(driver);
		return dataSource;
	}
	
	@Bean
	public DataSource dataSourceDev() throws Exception {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setUser(user);
		dataSource.setPassword(password);
		dataSource.setJdbcUrl(jdbcDevUrl);
		dataSource.setDriverClass(driver);
		return dataSource;
	}
	
	
	@Bean
	public DataSource dataSourceProd() throws Exception {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setUser(user);
		dataSource.setPassword(password);
		dataSource.setJdbcUrl(jdbcProdUrl);
		dataSource.setDriverClass(driver);
		return dataSource;
	}
}
