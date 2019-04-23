package com.baie.oauth2.config;

import com.baie.oauth2.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Order(10)
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private MyUserDetailsService userDetailsFitService;
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http.formLogin()
//				.and().authorizeRequests().antMatchers("/health", "/oauth/**").anonymous()
//				.and().authorizeRequests().anyRequest().authenticated();
//		http
//				.authorizeRequests()
//				.antMatchers("/login", "/health/**", "/oauth/**")
//				.permitAll()
//				.anyRequest()
//				.authenticated()
//				.and()
//				.csrf()
//				.disable();

		http
				.authorizeRequests()
				.antMatchers("/hello","/login").permitAll()
				.anyRequest().authenticated()
				.and()
				.formLogin()
				//指定登录页的路径
				.loginPage("/hello")
				//指定自定义form表单请求的路径
				.loginProcessingUrl("/login")
				.failureUrl("/login?error")
				.defaultSuccessUrl("/hello")
				//必须允许所有用户访问我们的登录页（例如未验证的用户，否则验证流程就会进入死循环）
				//这个formLogin().permitAll()方法允许所有用户基于表单登录访问/login这个page。
				.permitAll();
		//默认都会产生一个hiden标签 里面有安全相关的验证 防止请求伪造 这边我们暂时不需要 可禁用掉
		http .csrf().disable();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(userDetailsFitService).passwordEncoder(new BCryptPasswordEncoder());
//		auth.parentAuthenticationManager(authenticationManagerBean());

        auth.inMemoryAuthentication().passwordEncoder(new MyPasswordEncoder())
                .withUser("admin")
                .password("123456")
                .roles("ADMIN");
	}


	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}

}
