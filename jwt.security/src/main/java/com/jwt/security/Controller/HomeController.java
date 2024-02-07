package com.jwt.security.Controller;

import com.jwt.security.model.user;
import com.jwt.security.services.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
@Data
@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private UserService userService;

@GetMapping("/users")
public List<user> getUser(){

return userService.getallUser();
}

 @GetMapping("/currentuser")
    public String getloggedinUser(Principal principal){
    return principal.getName();
 }
}
