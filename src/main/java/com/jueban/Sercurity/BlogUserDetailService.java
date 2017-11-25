package com.jueban.Sercurity;

import com.jueban.Entity.User;
import com.jueban.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import java.util.Collections;

@Component
public class BlogUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = userRepository.findByName(name);
        if(user == null){
            throw new UsernameNotFoundException("Cannot find user");
        }
        GrantedAuthority authority = new SimpleGrantedAuthority(user.getType().toString());
        return new org.springframework.security.core.userdetails.User(user.getName(),user.getPassword(), Collections.singletonList(authority));

    }
}
