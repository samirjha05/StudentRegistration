package com.app.config;

import java.util.Locale;
import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.app.model.Student;

@EnableTransactionManagement
@Configuration
@EnableWebMvc
@ComponentScan(basePackages= {"com.app"})
@PropertySource("classpath:db.properties")
public class AppConfig {

	@Autowired
	private Environment env;

	@Bean
	public BasicDataSource ds() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(env.getProperty("driver"));
		ds.setUrl(env.getProperty("url"));
		ds.setUsername(env.getProperty("user"));
		ds.setPassword(env.getProperty("pwd"));
		ds.setInitialSize(30);
		ds.setMaxIdle(20);
		ds.setMinIdle(10);
		ds.setMaxTotal(50);
		return ds;
	}

	public Properties props() {
		Properties prop = new Properties();
		prop.setProperty("hibernate.dialect",env.getProperty("dialect"));
		prop.setProperty("hibernate.show_sql", env.getProperty("show-sql"));
		prop.setProperty("hibernate.hbm2ddl.auto", env.getProperty("hbm2ddl"));
		return prop;
	}

	@Bean
	public LocalSessionFactoryBean sf() {
		LocalSessionFactoryBean sf = new LocalSessionFactoryBean();
		sf.setDataSource(ds());
		sf.setAnnotatedClasses(Student.class);
		sf.setHibernateProperties(props());
		return sf;
	}

	@Bean
	public HibernateTransactionManager htm() {
		return new HibernateTransactionManager(sf().getObject());
	}

	@Bean
	public InternalResourceViewResolver vr() {

		return new InternalResourceViewResolver("/WEB-INF/pages/",".jsp");
	}

	@Bean
	MessageSource messageSource() {
		ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
		ms.setBasename("classpath:message");
		ms.setDefaultEncoding("UTF-8");

		return ms;
	}

	@Bean
	public LocaleResolver lr() {
		CookieLocaleResolver lr = new CookieLocaleResolver();
		lr.setDefaultLocale(Locale.ENGLISH);
		lr.setCookieName("my-locale");
		return lr;
	}

	@Bean
	public HandlerInterceptor interceptor1() {
		LocaleChangeInterceptor lcr = new LocaleChangeInterceptor();
		lcr.setParamName("lang");
		return lcr;
	}


	public void addInterceptor(InterceptorRegistry registry) {
		registry.addInterceptor(interceptor1());
	}
	
	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}


}
