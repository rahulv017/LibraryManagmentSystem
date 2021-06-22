package com.demo.library.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.demo.library.dao.RoleRepository;

@Component
public class AccountDetails implements UserDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4493820987058217136L;
      
	Account account;
	@Autowired
	RoleRepository roleRepo;
	public AccountDetails(Account account)
	{
		this.account = account;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Role roles = this.account.getAccountRole();
		ArrayList<Permissions> permissions = this.roleRepo.findById(roles.getRoleId()).get().getAuthority();
		Collection<String> rolePermission = permissions.stream().map(permission -> permission.getAuthority()).collect(Collectors.toList());
		Collection<GrantedAuthority> grantedAuthority = new ArrayList<GrantedAuthority>();
		for(String s: rolePermission)
		{
			grantedAuthority.add(new SimpleGrantedAuthority(s));
		}
		return permissions;
		
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return account.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return account.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
