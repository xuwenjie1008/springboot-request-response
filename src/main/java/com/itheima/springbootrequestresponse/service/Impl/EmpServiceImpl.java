package com.itheima.springbootrequestresponse.service.Impl;

import com.itheima.springbootrequestresponse.dao.Dao;
import com.itheima.springbootrequestresponse.pojo.Emp;
import com.itheima.springbootrequestresponse.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class EmpServiceImpl implements EmpService {
    @Autowired
    private Dao dao;
    @Override
    public List<Emp> list() {
        List<Emp> empList = dao.list();

        empList.stream().forEach(emp -> {
            //处理 gender 1: 男, 2: 女
            String gender = emp.getGender();
            if("1".equals(gender)){
                emp.setGender("男");
            }else if("2".equals(gender)){
                emp.setGender("女");
            }
            //处理job - 1: 讲师, 2: 班主任 , 3: 就业指导
            String job = emp.getJob();
            if("1".equals(job)){
                emp.setJob("讲师");
            }else if("2".equals(job)){
                emp.setJob("班主任");
            }else if("3".equals(job)){
                emp.setJob("就业指导");
            }
        });

        return empList;
    }
}
