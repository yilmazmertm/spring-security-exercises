package app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class LoginController {

    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage(){

        return "fancy-login";
    }
    @GetMapping("/showMyLeadersPage")
    public String showMyLeadersPage(){

        return "leaders";
    }

    @GetMapping("/systems")
    public String showMySystemsPage(){

        return "systems";
    }

    @GetMapping("/access-denied")
    public String showAcsessDeniedPage(){

        return "access-denied";
    }

}
