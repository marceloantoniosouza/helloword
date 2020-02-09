package com.souza.config;


import java.util.List;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @author William Suane for DevDojo on 6/27/17.
 */
@Component
public class CustomUserDetailService implements UserDetailsService {
//    private final UserRepository userRepository;

//    @Autowired
//    public CustomUserDetailService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User userbd = new User();
       userbd.setAdmin(true);
       userbd.setName("Marcelo Antonio de Souza");
       userbd.setPassword("$2a$10$ruHeEKX0rHBnn.wQXfY3veAeCtUdC5cNE09MeUNwQCtI5W1AsUJCW");
       userbd.setUsername(username);
   
//       User user = Optional.ofNullable(userRepository.findByUsername(username))
//                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
       
       User user = Optional.ofNullable(userbd)
             .orElseThrow(() -> new UsernameNotFoundException("User not found"));
       
       
        List<GrantedAuthority> authorityListAdmin = AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_ADMIN");
        List<GrantedAuthority> authorityListUser = AuthorityUtils.createAuthorityList("ROLE_USER");
        return new org.springframework.security.core.userdetails.User
                (user.getUsername(), user.getPassword(), user.isAdmin() ? authorityListAdmin : authorityListUser);

    }
}
