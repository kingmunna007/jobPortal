package com.kingmunna.Jobs.service;

import com.kingmunna.Jobs.model.User;
import com.kingmunna.Jobs.model.UserPrincipal;
import com.kingmunna.Jobs.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepo repo ;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = repo.findByName(username);
        if(user == null){
            System.out.println("user not found");
            throw new UsernameNotFoundException("404");
        }
        return new UserPrincipal(user);
    }
}
