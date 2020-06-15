package com.schedule.schedule.api;

//import netscape.security.Principal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Base64;

@RestController
@CrossOrigin
public class UserController {

    @RequestMapping("/login")
    public boolean login(@RequestBody User user) {
        return
                user.getUsername().equals("user") && user.getPassword().equals("password");
    }

}