package net.zabalburu.clienteproductos.auth;

import java.util.Date;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;

public class UsuarioJWT {
	
	private DecodedJWT token;

	private String refreshToken;
	
	public UsuarioJWT(JWTToken tk) {
		token = JWT.decode(tk.getAccessToken());
		this.refreshToken = tk.getRefreshToken();		
	}
	
	public String getNombre() {
		return  token.getClaim("given_name").asString();
	}
	
	public String getApellidos() {
		return  token.getClaim("family_name").asString();
	}
	
	public String getNombreCompleto() {
		return  token.getClaim("name").asString();
	}
	
	public String getEmail() {
		return  token.getClaim("email").asString();
	}
	
	public String getScope() {
		return  token.getClaim("scope").asString();
	}
	
	public boolean tieneScope(String scope) {
		return getScope().toLowerCase().contains(scope.toLowerCase());
	}
	
	public Date getExpiracion() {
		return token.getExpiresAt();
	}
	
	public String getRefreshToken() {
		return refreshToken;
	}
	
	public String getAccessToken() {
		return token.getToken();
	}
	
}
