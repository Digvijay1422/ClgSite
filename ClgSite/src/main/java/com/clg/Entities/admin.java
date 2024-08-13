package com.clg.Entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class Admin implements UserDetails{
    
    @Id
    private String Id;
    private String username;
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roleList = new ArrayList<String>();
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       Collection<SimpleGrantedAuthority> roles =  roleList.stream()
				.map(role->new SimpleGrantedAuthority(role)).collect(Collectors.toList());
		return roles;
    }
    @Override
    public String getPassword() {
       return this.password;
    }
    @Override
    public String getUsername() {
        return this.username;
    }
    public String getId() {
        return Id;
    }
    public void setId(String id) {
        Id = id;
    }
   
    public List<String> getRoleList() {
        return roleList;
    }
    public void setRoleList(List<String> roleList) {
        this.roleList = roleList;
    }
    @Override
	public boolean isAccountNonExpired() {
		return true;
	}


	@Override
	public boolean isAccountNonLocked() {
		return true;
	}


	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}


	@Override
	public boolean isEnabled() {
		return true;
	}
}
