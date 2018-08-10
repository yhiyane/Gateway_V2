package com.yit.entities;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class GwUser{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String firstName;
	private String lastName;
	private String login;
	private String email;
	private Date lastLogin;
	private Boolean enabled;	
	
	
	@ManyToMany(cascade = { 
		    CascadeType.PERSIST, 
		    CascadeType.MERGE
		})
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), 
    inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
	//@JsonIgnore
	private Set<GwRole> roles = new HashSet<>();
	
	// constructers
	
	public GwUser(String firstName, String lastName, String login, String email, Date lastLogin, Boolean enabled) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.login = login;
		this.email = email;
		this.lastLogin = lastLogin;
		this.enabled = enabled;
	}
	
	
	
	
	public GwUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	


	// getters and setters
	public Set<GwRole> getRoles() {
		return roles;
	}




	public void setRoles(Set<GwRole> roles) {
		this.roles = roles;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	
	

}
