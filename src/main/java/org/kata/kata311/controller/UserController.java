package org.kata.kata311.controller;

import jakarta.validation.Valid;
import org.kata.kata311.model.User;
import org.kata.kata311.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String allUsers(Model model) {
        model.addAttribute("allUsersList", userService.getAll());
        return "allUsers";
    }

    @GetMapping("/addUser")
    public String addUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "addUser";
    }

    @PostMapping("/saveUser")
    public String saveUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addUser";
        } else {
            userService.addUser(user);
            return "redirect:/";
        }
    }

    @GetMapping("/updateUser")
    public String updateUser(@RequestParam(value = "id", required = false) Integer id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "updateUser";
    }

    @PostMapping("/saveUserAfterUpdate")
    public String saveUserAfterUpdate(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "updateUser";
        } else {
            userService.updateUser(user);
            return "redirect:/";
        }
    }

    @GetMapping("/deleteUser")
    public String deleteUser(@ModelAttribute("id") Integer id) {
        userService.deleteUserById(id);
        return "redirect:/";
    }
}
