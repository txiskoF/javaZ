package net.zabalburu.clienteproductos.auth;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JWTToken {

	@JsonProperty("access_token")
	private String accessToken;
	
	@JsonProperty("expires_in")
	private Integer expiraEn;
	
	@JsonProperty("refresh_expires_in")
	private Integer refreshTokenExpiraEn;
	
	@JsonProperty("refresh_token")
	private String refreshToken;
	
	private String scope;

	public JWTToken() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public Integer getExpiraEn() {
		return expiraEn;
	}

	public void setExpiraEn(Integer expiraEn) {
		this.expiraEn = expiraEn;
	}

	public Integer getRefreshTokenExpiraEn() {
		return refreshTokenExpiraEn;
	}

	public void setRefreshTokenExpiraEn(Integer refreshTokenExpiraEn) {
		this.refreshTokenExpiraEn = refreshTokenExpiraEn;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}
	
	public Date getFechaExpiración() {
		return new Date(new Date().getTime()+this.expiraEn*1000);
	}
	
	public Date getFechaExpiraciónRefreshToken() {
		return new Date(new Date().getTime()+this.refreshTokenExpiraEn*1000);
	}

	@Override
	public String toString() {
		return "JWTToken [accessToken=" + accessToken + ", expiraEn=" + expiraEn + ", refreshTokenExpiraEn="
				+ refreshTokenExpiraEn + ", refreshToken=" + refreshToken + ", scope=" + scope + "]";
	}
	
}
