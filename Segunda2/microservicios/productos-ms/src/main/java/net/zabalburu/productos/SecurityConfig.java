package net.zabalburu.productos;

import org.springframework.beans.factory.annotation.Configurable;
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
				//que solo pueda el administrador
				.antMatchers(HttpMethod.GET,"/productos/token").hasAnyAuthority("SCOPE_ADMIN")
				//que pueda cualquiera
				.antMatchers(HttpMethod.GET,"/productos/**").permitAll()
				.antMatchers(HttpMethod.GET,"/categorias/**").permitAll()
				//que solo pueda el administrador
				.antMatchers(HttpMethod.DELETE,"/productos/**").hasAnyAuthority("SCOPE_ADMIN")
				//cualquier otra cosa y que este autenticado
				.anyRequest().authenticated())
		.oauth2ResourceServer(oauth -> oauth.jwt());
	}

}
