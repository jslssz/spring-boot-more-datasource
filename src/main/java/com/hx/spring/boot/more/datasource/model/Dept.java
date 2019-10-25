package com.hx.spring.boot.more.datasource.model;

import lombok.Data;

/**
 * @author jxlgcmh
 * @date 2019-10-25 16:54
 */
@Data
public class Dept {
    private Long deptno;

    private String dname;

    private String dbSource;
}