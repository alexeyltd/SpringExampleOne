package com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/user/**")
public class UserController {

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome() {
        return "user";
    }

}
