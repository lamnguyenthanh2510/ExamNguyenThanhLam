package com.example.hello.controller;

import com.example.hello.entity.UserEntity;
import com.example.hello.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class WebController {

    @Autowired
    UserService userService;

    @GetMapping({"/","index"})
    public String index(Model model){
        String mes = "Welcome";
        model.addAttribute("message", mes);
        return  "index";
    }

    @GetMapping("/adduser")
    public String addUser(Model model){
        UserEntity userEntity = new UserEntity();
        model.addAttribute("user", userEntity);
        return "adduser";
    }

    @GetMapping("/listuser")
    public String listUser(Model model){
        List<UserEntity> users  = userService.getAll();
        model.addAttribute("users", users);
        return "listuser";
    }


    @GetMapping("/index/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("index", userService.findOne(id));
        return "form";
    }

    @PostMapping("/index/save")
    public String save(@Validated UserEntity userEntity, BindingResult result, RedirectAttributes redirect) {
        if (result.hasErrors()) {
            return "form";
        }
        userService.save(userEntity);
        redirect.addFlashAttribute("success", "Saved employee successfully!");
        return "redirect:/index";
    }

    @GetMapping("/index/{id}/delete")
    public String delete(@PathVariable long id, RedirectAttributes redirect) {
        UserEntity emp = userService.findOne((int) id);
        userService.delete(emp);
        redirect.addFlashAttribute("success", "Deleted employee successfully!");
        return "redirect:/index";
    }
}
