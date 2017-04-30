package com.controllers;

import com.dao.implementations.Exceptions.UserDaoImplException;
import com.model.User;
import com.services.abstracts.userService.UserService;
import com.services.implementations.userServiceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by alexeypavlenko on 29/04/2017.
 */
@Controller
@RequestMapping(value = "/")
public class HomeController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String printAdmin(ModelMap modelMap) {


        List<User> x = null;
        try {
            x = userService.getUsers();
        } catch (UserDaoImplException e) {
            e.printStackTrace();
        }

        modelMap.addAttribute("list", x);

        return "admin";
    }


}
