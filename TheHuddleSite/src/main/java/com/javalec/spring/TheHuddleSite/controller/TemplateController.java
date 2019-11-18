package com.javalec.spring.TheHuddleSite.controller;

import com.javalec.spring.TheHuddleSite.model.User;
/*import com.javalec.spring.TheHuddleSite.model.UserDto;*/
import com.javalec.spring.TheHuddleSite.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
/*import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;*/
import org.springframework.web.bind.annotation.*;
/*import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.annotation.ModelAndViewResolver;*/
import org.springframework.web.servlet.view.RedirectView;

/*import javax.validation.Valid;*/
import java.util.Map;

@Controller
public class TemplateController {


    private UserRepository userRepository;

    @Autowired
    public TemplateController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    @GetMapping
    public String getRoot() {
        return "login";
    }

    @GetMapping("/main")
    public String getMain() { return "main"; }

    @GetMapping("/chatroom")
    public String getChat() { return "chatroom"; }

    @GetMapping("/signup")
    public String getSignup() { return "signup"; }

    @PostMapping(value = "/signup")
    public RedirectView postSignup(@ModelAttribute User user) {
        userRepository.save(user);
        return new RedirectView("login");
    }

    @PostMapping(value = "/login")
    public RedirectView postLogin(@RequestBody Map<String, Object> body) {
        return new RedirectView("login");
    }

    @GetMapping("/user")
    public @ResponseBody User getUser() {
        return userRepository.findAll().get(0);
    }

 /*   @RequestMapping(value = "/user/registration", method = RequestMethod.GET)
    public String showRegistrationForm(WebRequest request, Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "registration";
    }
    @RequestMapping(value = "/user/registration", method = RequestMethod.POST)
    public ModelAndView registerUserAccount
            (@ModelAttribute("user") @Valid UserDto accountDto,
             BindingResult result, WebRequest request, Errors errors) {
        User registered = new User();
        if (!result.hasErrors()) {
            registered = createUserAccount(accountDto, result);
        }
        if (registered == null) {
            result.rejectValue("email", "message.regError");
        }
        // rest of the implementation
    }
    private User createUserAccount(UserDto accountDto, BindingResult result) {
        User registered = null;
        try {
            registered = service.registerNewUserAccount(accountDto);
        } catch (EmailExistsException e) {
            return null;
        }
        return registered;
    }*/

}