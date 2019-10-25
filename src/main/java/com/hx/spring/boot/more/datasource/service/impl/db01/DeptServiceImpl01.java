package com.hx.spring.boot.more.datasource.service.impl.db01;

import com.hx.spring.boot.more.datasource.mapper.db01.DeptMapper01;
import com.hx.spring.boot.more.datasource.service.db01.DeptService01;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.hx.spring.boot.more.datasource.model.Dept;

/**
 * @author jxlgcmh
 * @date 2019-10-25 16:54
 */
@Service
public class DeptServiceImpl01 implements DeptService01 {

    @Resource
    private DeptMapper01 deptMapper01;

    @Override
    public int deleteByPrimaryKey(Long deptno) {
        return deptMapper01.deleteByPrimaryKey(deptno);
    }

    @Override
    public int insert(Dept record) {
        return deptMapper01.insert(record);
    }

    @Override
    public int insertSelective(Dept record) {
        return deptMapper01.insertSelective(record);
    }

    @Override
    public Dept selectByPrimaryKey(Long deptno) {
        return deptMapper01.selectByPrimaryKey(deptno);
    }

    @Override
    public int updateByPrimaryKeySelective(Dept record) {
        return deptMapper01.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Dept record) {
        return deptMapper01.updateByPrimaryKey(record);
    }

}
