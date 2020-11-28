package com.epam.lab.serviceImplementation;

import com.epam.lab.DAO.UserDAO;
import com.epam.lab.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

/**
 * This class represents implementation of User Detail Service.
 * It is used to receive user data.
 */
@Service("userDetailsService")
public class UserDetailsServiceImplementation implements UserDetailsService {

    /**
     * This field represents DAO layer.
     */
    @Autowired
    private UserDAO userDAO;

    /**
     * This method describes logic for searching user.
     * @param login String in input
     * @return UserDetails
     * @throws UsernameNotFoundException e
     */
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {


        User user = null;
        try {
            user = userDAO.getUser(login);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (user != null) {

            String username = user.getLogin();
            String password = user.getPassword();



            Collection<GrantedAuthority> authorities = new ArrayList<>();

            authorities.add(new SimpleGrantedAuthority(user.getRole()));

            return new org.springframework.security.core.userdetails.User(
                    username, password, authorities);

        } else {
            throw new UsernameNotFoundException("User with such login is not found!");
        }
    }

}