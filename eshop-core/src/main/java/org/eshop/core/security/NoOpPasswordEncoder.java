package org.eshop.core.security;

public class NoOpPasswordEncoder implements PasswordEncoder {

	@Override
	public String encode(String password) {
		return password;
	}

}
