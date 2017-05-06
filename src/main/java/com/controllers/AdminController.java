package com.controllers;

import com.model.Role;
import com.model.User;
import com.services.abstracts.RoleService;
import com.services.abstracts.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping(value = "/admin/**")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String getAdmin(ModelMap modelMap) {

        List<User> x = userService.getAllUser();

        modelMap.addAttribute("list", x);

        return "adminBoot";
    }

    @RequestMapping(value = "/admin/create", method = RequestMethod.GET)
    public String getCreatePage() {
        return "create";
    }

    @RequestMapping(value = "/admin/create", method = RequestMethod.POST)
    public String getAdminPage(@RequestParam("login") String login, @RequestParam("password") String password,
                               @RequestParam("role") String role, ModelMap modelMap) {


           if ("ADMIN".equalsIgnoreCase(role)) {
               User admin = new User();
               admin.setLogin(login);
               admin.setPassword(password);
               Set<Role> adminRoles = new HashSet<>(roleService.getAllRoles());
               admin.setRoles(adminRoles);

               userService.addUser(admin);


           }
           else if ("USER".equalsIgnoreCase(role)) {

               User user = new User();
               user.setLogin(login);
               user.setPassword(password);
               Set<Role> userRoles = new HashSet<>();
               userRoles.add(roleService.getRoleByRoleName(role));
               user.setRoles(userRoles);

               userService.addUser(user);

           }

            List<User> x = userService.getAllUser();

            modelMap.addAttribute("list", x);



        return "adminBoot";
    }


    @RequestMapping(value = "/admin/update", method = RequestMethod.GET)
    public String getUpdatePage() {
        return "update";
    }


    @RequestMapping(value = "/admin/update", method = RequestMethod.POST)
    public String getAdminPage(@RequestParam("idUser") long id, @RequestParam("login") String login,
                               @RequestParam("password") String password, @RequestParam("role") String role,
                               ModelMap modelMap) {


            User user = userService.getUserById(id);
            user.setLogin(login);
            user.setPassword(password);


            Role newRole = roleService.getRoleByRoleName(role);
            Set<Role> userRoles = new HashSet<>();
            userRoles.add(newRole);

            if ("ADMIN".equalsIgnoreCase(role)) {
                Role userRole = roleService.getRoleByRoleName("USER");
                userRoles.add(userRole);
            }

            user.setRoles(userRoles);

            userService.updateUser(user);



            List<User> x = userService.getAllUser();

            modelMap.addAttribute("list", x);


        return "adminBoot";
    }


    @RequestMapping(value = "/admin/delete", method = RequestMethod.GET)
    public String getAdminPage() {
        return "admin";
    }

    @RequestMapping(value = "/admin/delete", method = RequestMethod.POST)
    public String getAdminPage(@RequestParam("id") long id, ModelMap modelMap) {


            userService.deleteUserById(id);

            List<User> x = userService.getAllUser();
            modelMap.addAttribute("list", x);


        return "adminBoot";
    }


}
