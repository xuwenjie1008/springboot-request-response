package com.itheima.springbootrequestresponse.dao.Impl;

import com.itheima.springbootrequestresponse.dao.Dao;
import com.itheima.springbootrequestresponse.pojo.Emp;
import com.itheima.springbootrequestresponse.utils.XmlParserUtils;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class DaoImpl implements Dao {
    @Override
    public List<Emp> list() {
        String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
        List<Emp> empList = XmlParserUtils.parse(file, Emp.class);
        return empList;
    }
}
