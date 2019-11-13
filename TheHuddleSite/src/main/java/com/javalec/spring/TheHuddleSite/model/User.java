package com.javalec.spring.TheHuddleSite.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String email;

    private String password;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

/*public class PasswordAuthentication {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private PasswordEncoder passwordEncoder;


    public User registerNewUserAccount(UserDto accountDto) throws EmailExistsException {
        if (emailExist(accountDto.getEmail())) {
            throw new EmailExistsException(
                    "There is an account with that email adress:" + accountDto.getEmail());
        }
        User user = new User();
        user.setFirstName(accountDto.getFirstName());
        user.setLastName(accountDto.getLastName());

        user.setPassword(passwordEncoder.encode(accountDto.getPassword()));

        user.setEmail(accountDto.getEmail());
        user.setRole(new Role(Integer.valueOf(1), user));
        return repository.save(user);
    }
    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public DaoAuthenticationProvider authProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(encoder());
        return authProvider;
    }

    @Configuration
    @ComponentScan(basePackages = { "org.baeldung.security" })
    @EnableWebSecurity
    public class SecSecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.authenticationProvider(authProvider());
        }

        <authentication-manager>
        <authentication-provider ref="authProvider" />
        </authentication-manager>
    }
}*/