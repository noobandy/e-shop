package in.anandm.eshop.accountservice.model;

import java.util.Collections;
import java.util.List;

public class User {

	private Long id;
	private String email;
	private String displayName;
	private String password;
	
	private List<Address> address = Collections.emptyList();

	public User() {
		super();
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", displayName=" + displayName + ", password=" + password
				+ ", address=" + address + "]";
	}

	
	
	
}
