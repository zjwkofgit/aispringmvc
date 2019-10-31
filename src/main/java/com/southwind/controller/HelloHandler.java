package com.southwind.controller;

import com.southwind.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@Controller
@RequestMapping("/hello")
public class HelloHandler {


    @RequestMapping(value = "/index",method = RequestMethod.GET,params =   {"name","id=10"}) //跟客户端请求关联起来,访问index 映射到下面的方法
    //写一个业务方法，
    public String index(String name,int id ) {//可以自定义参数public String index(@RequestParam("name") String str,@RequestParam("id") int age)
        System.out.println(name);            // System.out.println(str);
        System.out.println(id);
        System.out.println("执行了index...");
        return "index";//这个方法返回逻辑视图，再结合springmvc.xml里的视图解析器，找到index.jsp
    }
    //一个请求进来 先被DispathcherServlet（web.xml里配置）捕获，然后去找映射（注解映射），/index请求对应写的业务方法，就直接进到方法里，方法调用
    //是由springmvc完成的，他首先实例化handler，然后去调index方法执行


    @RequestMapping("/rest/{name}/{id}")
    public String rest(@PathVariable("name") String name, @PathVariable("id") int id){
        System.out.println(name);
        System.out.println(id);
        return "index";
    }

    @RequestMapping("/cookie")
    public String cookie(@CookieValue(value = "JSESSIONID") String sessionId){
        System.out.println(sessionId);
        return "index";
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String save(User user){
        System.out.println(user);

      //  System.out.println(id);
        return "index";
    }

    @RequestMapping("forward")
    public String foward(){
        System.out.println("转发：一次请求，可以取请求数据，网址不变");
        return "forward:/index.jsp";
        //等同 renturn "index";
    }

    @RequestMapping("redirect")
    public String redirect(){
        System.out.println("重定向：二次请求，取不了请求数据，网址会变");
        return "redirect:/index.jsp";
    }






}

