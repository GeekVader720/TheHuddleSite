package com.javalec.spring.TheHuddleSite.model;

/*import com.sun.deploy.security.ValidationState;
import com.sun.org.apache.xerces.internal.impl.xs.identity.Field;
import com.sun.tools.classfile.Annotation;
import com.sun.xml.internal.bind.v2.model.runtime.RuntimeNonElement;
import org.hibernate.annotations.Type;
import org.hibernate.validator.internal.constraintvalidators.bv.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;*/

import javax.persistence.*;
/*import javax.validation.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.lang.annotation.*;
import java.util.regex.Matcher;


import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.lang.annotation.*;*/


@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String email;

    private String username;

    private String password;

    private boolean enabled;

    public User() {
        super();
        this.enabled = false;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}

/*
    public class PasswordAuthentication {
            @Bean
            public PasswordEncoder passwordEncoder() {
                return new BCryptPasswordEncoder();
            }

            @Autowired
            private PasswordEncoder passwordEncoder;

            public User registerNewUserAccount(UserDto accountDto) throws EmailExistsException {
                if (emailExist(accountDto.getEmail())) {
                    throw new EmailExistsException(
                            "There is an account with that email address:" + accountDto.getEmail());
                }
                User user = new User();
                user.setEmail(accountDto.getEmail());

                user.setPassword(passwordEncoder.encode(accountDto.getPassword()));

                user.setRole(new Role(Integer.valueOf(1), user));
                return repository.save(user);
            }

            public ModelAndView registerUserAccount(
                    @ModelAttribute("user") @Valid UserDto accountDto,
                    BindingResult result, WebRequest request, Errors errors) {
            }

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
        @ComponentScan(basePackages = {"org.baeldung.security"})
        @EnableWebSecurity
        public class SecSecurityConfig extends WebSecurityConfigurerAdapter {

            protected void configure(AuthenticationManagerBuilder auth) throws Exception {
                auth.authenticationProvider(authProvider());
            }

            protected AuthenticationManager authenticationManager() throws Exception {
                return super.authenticationManager();

            }
        }
    }
}*/
