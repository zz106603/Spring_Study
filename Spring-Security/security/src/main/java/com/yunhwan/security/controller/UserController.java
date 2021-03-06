package com.yunhwan.security.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yunhwan.security.dto.UserInfoDto;
import com.yunhwan.security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;

    @GetMapping("/")
    public String openMain(){
        return "main";
    }
    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }
    @GetMapping("/admin")
    public String adminPage(){
        return "admin";
    }
    @GetMapping("/signup")
    public String signupPage(){
        return "signup";
    }

    @PostMapping("/user")
    public String signup(UserInfoDto infoDto) { // 회원 추가
        userService.save(infoDto);
        return "redirect:/login";
    }

    @GetMapping(value = "/logout")
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
        return "redirect:/login";
    }

}
