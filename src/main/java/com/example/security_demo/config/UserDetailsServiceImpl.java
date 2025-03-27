package com.example.security_demo.config;

import com.example.security_demo.entity.User;
import com.example.security_demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        User user = userMapper.findByUserId(userId);
        // ログインアカウントが見つからない場合
        if (user == null) {
            throw new UsernameNotFoundException("User not found with user_id: " + userId);
        }
        // ログインアカウントが存在する場合
        List<GrantedAuthority> authorities = user.getAuthorities().stream()
                .map(auth -> new SimpleGrantedAuthority(auth.getAuthority()))
                .collect(Collectors.toList());
        return new org.springframework.security.core.userdetails.User(user.getUserId(), user.getPassword(), user.isEnabled(),
                true, true, true, authorities);
    }
}
