package com.southwind.controller;

import com.southwind.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("/view")
public class ViewHandler {

    @RequestMapping("/map")
    public String map(Map<String,User> map){
        User user =new User();
        user.setId(1L);
        user.setName("张三");
        map.put("auser",user); //auser(可改) 传到view.jsp -> ${requestScope.auser}
        return "view";
    }

    @RequestMapping("/model")
    public String model(Model model){
        User user =new User();
        user.setId(2L);
        user.setName("张三");
        model.addAttribute("muser",user);
        return "view";
    }

    @RequestMapping("/modelAndView")
    public ModelAndView modelAndView(){
        User user =new User();
        user.setId(3L);
        user.setName("张三");
        ModelAndView modelAndView =new ModelAndView();
        modelAndView.addObject("mvuser",user);
        modelAndView.setViewName("view");
        return modelAndView;


    }
}
