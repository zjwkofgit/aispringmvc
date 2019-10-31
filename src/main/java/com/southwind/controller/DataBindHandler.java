package com.southwind.controller;

import com.southwind.entity.User;
import com.southwind.entity.UserList;
import com.southwind.entity.UserMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;


//@Controller
@RestController   //@RestController=@Controller+@ResponseBody
@RequestMapping("/data")
public class DataBindHandler {

    @RequestMapping("body")
    public String body(){
        System.out.println("返回body");
        return "加@ResponseBody，直接返回body";  //之前加了过滤器，返回会导致乱码
    }

    @RequestMapping("/packageType")
    public String packageType(@RequestParam(value = "num",required = false,defaultValue = "0") Integer id){
        return id+"";
    }
    //requried 设置参数是否必填项，默认false，可省略； defaultValue 设置缺省的默认值


    @RequestMapping("/array")
    public String array(String[] name){
        String str = Arrays.toString(name);
        return str;
    }



    @RequestMapping("/list")
    public String list(UserList userList){
        System.out.println("list");
        StringBuffer str = new StringBuffer();
        for(User user:userList.getUsers()){
            str.append(user);
        }
        return str.toString();
    }

    @RequestMapping("/map")
    public String map(UserMap userMap){
        StringBuffer str= new StringBuffer();
        for (String key:userMap.getUsers().keySet()){
            User user=userMap.getUsers().get(key);
            str.append(user);
        }
        return str.toString();
    }


    @RequestMapping("/json")
    public User json(@RequestBody User user){
        System.out.println(user);
        user.setId(6);
        user.setName("张六");
        return user;
    }



}
