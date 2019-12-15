package com.sdn.controller;

import com.sdn.biz.userBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class userController {
    @Autowired
    userBiz biz;
    @RequestMapping("/getAll")
    public String getAll(Model model){
        model.addAttribute("list",biz.getAll());
        return "user/userlist";
    }
}
