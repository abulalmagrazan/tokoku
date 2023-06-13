package com.example.TokoKu;

import com.example.TokoKu.dto.LoginAccessDto;
import com.example.TokoKu.entity.Account;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AppUserDetail implements UserDetails {

    private String username;
    public String password;
    public String role;
    public String loginPage;
    public List<GrantedAuthority> authorities=new ArrayList<>();

    public AppUserDetail(LoginAccessDto acc){
        this.username=acc.getUsername();
        this.password=acc.getPassword();
        this.role=acc.getAccountRole();
        this.loginPage=acc.getLoginPageRole();
        this.authorities.add(new SimpleGrantedAuthority(acc.getAccountRole()));
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    public String getRole() {return this.role;}

    public String getLoginPage(){return  this.loginPage;}
    @Override
    public String getPassword() {return this.password;}

    @Override
    public String getUsername() {
        return this.username;
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
        return getLoginPage().toLowerCase().equals(getRole().toLowerCase());
    }
}
