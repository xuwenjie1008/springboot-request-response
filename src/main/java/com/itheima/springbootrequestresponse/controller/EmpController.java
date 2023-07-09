package com.itheima.springbootrequestresponse.controller;

import com.itheima.springbootrequestresponse.pojo.Emp;
import com.itheima.springbootrequestresponse.service.EmpService;
import com.itheima.springbootrequestresponse.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class EmpController {
    //@Autowired
    //@Qualifier("empServiceImplB")
    @Resource(name = "empServiceImplB")
    private EmpService empService;
    @RequestMapping("/listEmp")
    public Result list(){

        List<Emp> empList = empService.list();

        return Result.success(empList);
    }
}