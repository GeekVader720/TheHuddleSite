package com.javalec.spring.TheHuddleSite.config;

import com.javalec.spring.TheHuddleSite.model.User;
import com.javalec.spring.TheHuddleSite.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class StartupRunner implements ApplicationRunner {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private User user;

    @Autowired
    public StartupRunner(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;

    }


    @Override
    public void run(ApplicationArguments args) {
        User user = new User();
      user.setUsername("user2");
        user.setPassword(passwordEncoder.encode("password2"));
        userRepository.save(user);

        User user2 = new User();
        user2.setUsername("user");
        user2.setPassword(passwordEncoder.encode("password"));
        userRepository.save(user2);
    }
}
