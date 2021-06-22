package com.demo.library.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Account {

	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int accountId;
	
	@NonNull 
	private String username;
	
	@NonNull
	private String password;
	
	@ManyToOne @JoinColumn(name = "role_id")
	private Role accountRole;
}
