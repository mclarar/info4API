package com.info4.getVagas.dtos;

public class TokenDTO {
	private String type;
	private String token;
	
	public TokenDTO(String type, String token) {
		this.type = type;
		this.token = token;
	}

	public TokenDTO builder() {
		return new TokenDTO(type, token);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
