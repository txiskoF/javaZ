package net.zabalburu.ofertas;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests(
			auth -> auth
				.antMatchers(HttpMethod.GET,"/ofertas/**").permitAll()
				.antMatchers("/ofertas/**").hasAnyAuthority("SCOPE_USER")
				.anyRequest().authenticated())
		.oauth2ResourceServer(oauth -> oauth.jwt());
	}

}
