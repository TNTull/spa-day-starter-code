//Teresa Tull worked on this on 10-24-2022 java ch 14 studio in class

package org.launchcode.spaday.controllers;

import org.launchcode.spaday.data.UserData;
import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("add")
    public static String displayAddUserForm(@ModelAttribute User user) {
        return "user/add";
    }

    @GetMapping("{id}")
    public String displayUser(Model model, @PathVariable int id) {
        User user = UserData.getById(id);
        model.addAttribute("user", user);
        return "user/display";
    }

    @PostMapping("add")
    public String processAddUserForm(@ModelAttribute @Valid User user,
                                     BindingResult result,
                                     @RequestParam String verify) {
        if (!result.hasErrors() && user.getPassword().equals(verify)) {
            UserData.add(user);
            return "redirect:/user";
        }
        return "user/add";
    }

    @GetMapping
    public String allUsers(Model model) {
        model.addAttribute("allUsers", UserData.getAll());
        return "user/index";
    }

}
