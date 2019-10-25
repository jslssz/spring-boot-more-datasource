package com.hx.spring.boot.more.datasource.service.impl.db02;

import com.hx.spring.boot.more.datasource.mapper.db02.DeptMapper02;
import com.hx.spring.boot.more.datasource.model.Dept;
import com.hx.spring.boot.more.datasource.service.db02.DeptService02;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author jxlgcmh
 * @date 2019-10-25 16:54
 */
@Service
public class DeptServiceImpl02 implements DeptService02 {

    @Resource
    private DeptMapper02 deptMapper02;

    @Override
    public int deleteByPrimaryKey(Long deptno) {
        return deptMapper02.deleteByPrimaryKey(deptno);
    }

    @Override
    public int insert(Dept record) {
        return deptMapper02.insert(record);
    }

    @Override
    public int insertSelective(Dept record) {
        return deptMapper02.insertSelective(record);
    }

    @Override
    public Dept selectByPrimaryKey(Long deptno) {
        return deptMapper02.selectByPrimaryKey(deptno);
    }

    @Override
    public int updateByPrimaryKeySelective(Dept record) {
        return deptMapper02.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Dept record) {
        return deptMapper02.updateByPrimaryKey(record);
    }

}
