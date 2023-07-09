package com.itheima.springbootrequestresponse.controller;

import com.itheima.springbootrequestresponse.pojo.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RestController
public class RequestController {
    /**
     * 简单参数-原始接收
     */
    @RequestMapping("/simpleParam1")
    public String simpleParam1(HttpServletRequest request) {
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        int ageInt = Integer.parseInt(age);
        System.out.println("参数是：name =" + name + "age =" + ageInt);
        return "简单参数1";
    }

    /**
     * 简单参数-KEY_VALUE 常用（推荐）
     */
    @RequestMapping("/simpleParam2")
    public String simpleParam2(String name, Integer age) {
        System.out.println("参数是：name =" + name + "age =" + age);
        return "简单参数2";
    }

    /**
     * 简单参数-别名 常用（推荐）
     */
    @RequestMapping("/simpleParam3")
    public String simpleParam3(@RequestParam(name = "name1") String name,
                               @RequestParam(name = "userAge") Integer age) {
        System.out.println("参数是：name =" + name + "age =" + age);
        return "简单参数3";
    }

    /**
     * 实体参数-封装  常用
     */
    @RequestMapping("/pojoParam1")
    public String pojoParam(User user) {
        System.out.println("参数是：name =" + user.getName() + "age =" + user.getAge());
        return "pojoParam1";
    }

    /**
     * 实体参数-嵌套
     */
    @RequestMapping("/pojoParam2")
    public String pojoParam2(User user) {
        System.out.println("实体参数是：" + user);
        return "pojoParam2";
    }

    /**
     * 数组参数
     */
    @RequestMapping("/arrParam")
    public String arrParam(String[] hobby) {
        System.out.println(Arrays.toString(hobby));
        return "arrParam";
    }

    /**
     * 集合参数
     */
    @RequestMapping("/listParam")
    public String listParam(@RequestParam List<String> hobby) {
        System.out.println(hobby);
        return "listParam";
    }

    /**
     * 日期参数
     */
    @RequestMapping("/dataParam")
    public String dataParam(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime birthday) {
        System.out.println(birthday);
        return "dataParam";
    }

    @RequestMapping("/jsonParam")
    public String jsonParam(@RequestBody User user) {
        System.out.println(user);
        return "jsonParam";
    }

    /**
     * 路径参数
     */
    @RequestMapping("/pathParam/{id}/{id2}")
    public String pathParam(@PathVariable String id,
                            @PathVariable String id2) {
        System.out.println(id);
        System.out.println(id2);
        return "pathParam";
    }
}
