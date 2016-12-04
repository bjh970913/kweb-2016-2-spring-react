package com.kweb.model.Abstract;

import com.kweb.model.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Created by bjh970913 on 05/12/2016.
 * spring-board
 */
public abstract class UserDetailsAbstract implements UserDetails {
    public abstract String getEmail();

    public abstract String getPasswordHash();

    public abstract Set<Role> getUserRoles();

    @Override
    @Transient
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Role role : getUserRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.getName().toString()));
        }
        return authorities;
    }

    @Override
    @Transient
    public String getPassword() {
        return getPasswordHash();
    }

    @Override
    @Transient
    public String getUsername() {
        return getEmail();
    }

    @Override
    @Transient
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @Transient
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @Transient
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @Transient
    public boolean isEnabled() {
        return true;
    }
}
