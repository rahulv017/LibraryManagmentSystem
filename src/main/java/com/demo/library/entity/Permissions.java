package com.demo.library.entity;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Permissions implements GrantedAuthority{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6177967775339843805L;

	@Id @GeneratedValue(strategy= GenerationType.SEQUENCE)
	private int pid;
	
	@Column(nullable = false)
	private AccessType access;
	
	@ManyToMany
	ArrayList<Role> roles;

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return this.access.toString();
	}
}
