package com.reclamation.dtos;

public class UserDetails {

	private String userId;
	private String role;
	
	public UserDetails() {
    }

    public UserDetails(String userId, String role) {
        this.userId = userId;
        this.role = role;
    }

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
