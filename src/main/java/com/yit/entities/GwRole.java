package com.yit.entities;


import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class GwRole{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	public Set<GwUser> getUsers() {
		return users;
	}
	public void setUsers(Set<GwUser> users) {
		this.users = users;
	}
	public Collection<GwRight> getRights() {
		return rights;
	}
	public void setRights(Collection<GwRight> rights) {
		this.rights = rights;
	}
	private String name;
	private String description;
	
	@ManyToMany(mappedBy = "roles")
	@JsonIgnore
	private Set<GwUser> users= new HashSet<>();
	  
	@OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "role")
	//@JsonIgnore
	private Collection<GwRight> rights;
	//contructers
	
	public GwRole() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GwRole(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}
	
	// Getters and setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	

	
	
	
	
}
