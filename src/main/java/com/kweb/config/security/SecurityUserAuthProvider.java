package com.kweb.config.security;

import com.kweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.token.Sha512DigestUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bjh970913 on 05/12/2016.
 * spring-board
 */
@Component
public class SecurityUserAuthProvider implements AuthenticationProvider {
    private UserService userService;

    @Autowired
    public SecurityUserAuthProvider(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String id = (String) authentication.getPrincipal();
        String pwPlain = (String) authentication.getCredentials();
        String pw = Sha512DigestUtils.shaHex(pwPlain);

        UserDetails details = this.getLoginUserDetails(id, pw);
        if (details == null) {
            throw new UsernameNotFoundException("아이디와 패스워드를 재확인 해주세요");
        }
        if (!details.isAccountNonExpired())
            throw new AccountExpiredException("이 계정은 회원탈퇴 절차중에 있습니다.");
        if (!details.isAccountNonLocked())
            throw new LockedException("이 계정은 잠겼습니다.");
        if (!details.isEnabled())
            throw new DisabledException("해당 계정은 비활성화 되어있습니다.");

        List<GrantedAuthority> roles = new ArrayList<>();
        roles.addAll(details.getAuthorities());

        UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(details, pw, roles);
        result.setDetails(details);
        return result;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

    UserDetails getLoginUserDetails(String email, String passwordHash) {
        return userService.getUserByEmailAndPasswordHash(email, passwordHash);
    }
}
