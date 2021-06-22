package com.demo.library.entity;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.*;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Role {

	@Id @Column(name="role_id") @GeneratedValue(strategy= GenerationType.SEQUENCE)
	private int roleId;
	
	private RoleNames role;
	
	@OneToMany(mappedBy="accountRole")
	ArrayList<Account> accounts;
	
	@ManyToMany @JoinTable(name = "role_permission", 
			  joinColumns = @JoinColumn(name = "role_id"), 
			  inverseJoinColumns = @JoinColumn(name = "permission_id"))
	ArrayList<Permissions> authority;
	
}
