package com.example.demo.controller;

import com.example.demo.pojo.user;
import com.example.demo.service.userService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TestPageHelper {
    @Autowired
    private userService userService;
    //开始分页显示
    @GetMapping("/selectByPageHelper")
    public String  selectByPageTest(Model model, @RequestParam(value = "currPage",defaultValue = "1") int currPage ){

//        int totalcount=userService.findUsers().size(); //获取数据的总长度即可
        int pageSize=5;
        PageHelper.startPage(currPage,pageSize);
        //紧跟着的第一个select方法会被分页
        List<user> users=userService.findUsers();
        //用PageInfo对结果进行包装
        PageInfo<user> p=new PageInfo<>(users);

        model.addAttribute("users",users);
        model.addAttribute("page",p);
////        model.addAttribute("users",userService.findUsers());

        return "itemslisthelper"; //forward,地址不变化
    }
}
