package com.controllers;

import com.dao.implementations.Exceptions.UserDaoImplException;
import com.model.User;
import com.services.abstracts.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value = "/admin/**")
public class AdminController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/admin/create", method = RequestMethod.GET)
    public String getCreatePage() {
        return "create";
    }

    @RequestMapping(value = "/admin/create", method = RequestMethod.POST)
    public String getAdminPage(@RequestParam("name") String name, @RequestParam("login") String login,
                               @RequestParam("password") String password, @RequestParam("role") String role,
                               ModelMap modelMap) {

        try {

            User user = new User(name, login, password, role);

            userService.addUser(user);

            List<User> x = userService.getUsers();

            modelMap.addAttribute("list", x);

        } catch (UserDaoImplException e) {
            e.printStackTrace();
        }


        return "admin";
    }


    @RequestMapping(value = "/admin/update", method = RequestMethod.GET)
    public String getUpdatePage() {
        return "update";
    }


    @RequestMapping(value = "/admin/update", method = RequestMethod.POST)
    public String getAdminPage(@RequestParam("id") long id, @RequestParam("name") String name, @RequestParam("login") String login,
                               @RequestParam("password") String password, @RequestParam("role") String role,
                               ModelMap modelMap) {

        try {

            User user = new User(id, name, login, password, role);

            userService.updateUser(user);

            List<User> x = userService.getUsers();

            modelMap.addAttribute("list", x);

        } catch (UserDaoImplException e) {
            e.printStackTrace();
        }


        return "admin";
    }


    @RequestMapping(value = "/admin/delete", method = RequestMethod.GET)
    public String getAdminPage() {
        return "admin";
    }

    @RequestMapping(value = "/admin/delete", method = RequestMethod.POST)
    public String getAdminPage(@RequestParam("id") long id, ModelMap modelMap) {


        try {
            userService.deleteUser(id);

            List<User> x = userService.getUsers();
            modelMap.addAttribute("list", x);

        } catch (UserDaoImplException e) {
            e.printStackTrace();
        }


        return "admin";
    }


}
