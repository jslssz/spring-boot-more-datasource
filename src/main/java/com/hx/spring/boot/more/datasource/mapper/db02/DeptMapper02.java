package com.hx.spring.boot.more.datasource.mapper.db02;

import com.hx.spring.boot.more.datasource.model.Dept;

/**
 * @author jxlgcmh
 * @date 2019-10-25 16:54
 */
public interface DeptMapper02 {
    int deleteByPrimaryKey(Long deptno);

    int insert(Dept record);

    int insertSelective(Dept record);

    Dept selectByPrimaryKey(Long deptno);

    int updateByPrimaryKeySelective(Dept record);

    int updateByPrimaryKey(Dept record);
}