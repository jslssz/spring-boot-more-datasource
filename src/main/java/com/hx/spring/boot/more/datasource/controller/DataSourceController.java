package com.hx.spring.boot.more.datasource.controller;

import com.hx.spring.boot.more.datasource.model.Dept;
import com.hx.spring.boot.more.datasource.service.impl.db01.DeptServiceImpl01;
import com.hx.spring.boot.more.datasource.service.impl.db02.DeptServiceImpl02;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jxlgcmh
 * @date 2019-10-25 17:52
 */
@RestController
public class DataSourceController {

    @Autowired
    private DeptServiceImpl01 deptServiceImpl01;
    @Autowired
    private DeptServiceImpl02 deptServiceImpl02;

    @RequestMapping("add1")
    public String add01() {
        Dept dept = new Dept();
        dept.setDeptno(111L);
        dept.setDname("db01");
        dept.setDbSource("db011");
        deptServiceImpl01.insert(dept);
        return "success";
    }

    @RequestMapping("add2")
    public String add02() {
        Dept dept = new Dept();
        dept.setDname("db02");
        dept.setDbSource("db022");
        deptServiceImpl02.insert(dept);
        return "success";
    }


}
