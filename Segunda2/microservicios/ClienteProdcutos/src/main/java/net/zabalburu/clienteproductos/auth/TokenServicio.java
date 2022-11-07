package net.zabalburu.clienteproductos.auth;



import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class TokenServicio {
	@Autowired
	private RestTemplate template;
	
	public JWTToken getToken(String usuario, String password) {
		HttpHeaders cabeceras = getCabeceras();
		
		MultiValueMap<String, String> body = new LinkedMultiValueMap<String, String>();
		body.add("grant_type", "password");
		body.add("username", usuario);
		body.add("password", password);
		
		HttpEntity<MultiValueMap<String, String>> entity = 
			new HttpEntity<MultiValueMap<String,String>>(
				body, cabeceras);
		JWTToken token;
		try {
			token = template.exchange(
				"http://localhost:8080/auth/realms/Productos/protocol/openid-connect/token", 
				HttpMethod.POST, 
				entity, 
				JWTToken.class).getBody();
		} catch (HttpClientErrorException ex) {
			ex.printStackTrace();
			token = null;
		}
		return token;
	}

	private HttpHeaders getCabeceras() {
		HttpHeaders cabeceras = new HttpHeaders();
		String clientepass = "productos-client" + ":" + "5b1ebda4-8348-49ad-8a99-a78a4ed963d7";
		String auth ="Basic " + Base64.getEncoder().encodeToString(clientepass.getBytes());
		cabeceras.set("Authorization",auth);
		cabeceras.set("Content-Type","application/x-www-form-urlencoded");
		return cabeceras;
	}
	
	public JWTToken getRefreshToken(UsuarioJWT usuario) {
		HttpHeaders cabeceras = getCabeceras();
		
		MultiValueMap<String, String> body = new LinkedMultiValueMap<String, String>();
		body.add("grant_type", "refresh_token");
		body.add("refresh_token", usuario.getRefreshToken());
		
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String,String>>(
				body, cabeceras);
		JWTToken token;
		try {
			token = template.exchange(
				"http://localhost:8080/auth/realms/Productos/protocol/openid-connect/token", 
				HttpMethod.POST, 
				entity, 
				JWTToken.class).getBody();
		} catch (HttpClientErrorException ex) {
			ex.printStackTrace();
			token = null;
		}
		return token;
	}
	
}
