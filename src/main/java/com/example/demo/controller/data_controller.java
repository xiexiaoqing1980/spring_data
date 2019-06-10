package com.example.demo.controller;

import com.example.demo.pojo.user;
import com.example.demo.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class data_controller {


    @Autowired
    private userService userService;

    @GetMapping("/user/{id}")
    public user selectUsers(@PathVariable("id") Integer id){
        user user=userService.findUserById(id);
        return user;
        
    }
    @GetMapping("/userlist")
    public String  selectUsers(Model model){

        model.addAttribute("users",userService.findUsers());
        return "itemslist"; //forward
    }
//    @GetMapping("/adduser")
//    public String  adduser (){
//        userService.adduser(user);
//        return "newuser";
//
//    }

    @PostMapping ("/login")
    public  String login(user user, Model model, HttpSession session){
        if (user!=null&&user.getId()!=null){
            user user2=userService.findUserById(user.getId());
            if (user2!=null){
                model.addAttribute("user2",user2);
                session.setAttribute("login_user",user2);
                return "redirect:/userlist";
//                return "/userlist";这样是直接
            }else {

                return "redirect:/login.html";
            }
        }else {
            return "redirect:/login.html";
        }




    }

}
