package com.hx.spring.boot.more.datasource.conf;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author jxlgcmh
 * @date 2019-10-25 17:02
 */
@Configuration
@MapperScan(basePackages = "com.hx.spring.boot.more.datasource.mapper.db02", sqlSessionTemplateRef = "sqlSessionTemplate02")
public class DataSource02Config {

    /**
     * 创建数据源02
     *
     * @return
     */
    @Bean("dataSource02")
    @ConfigurationProperties(prefix = "spring.datasource02")
    public DataSource dataSource02() {
        return DataSourceBuilder.create().build();
    }

    /**
     * 创建工厂
     *
     * @param dataSource
     * @return
     * @throws Exception
     */

    @Bean("dataSource02Factory")
    public SqlSessionFactory dataSource02Factory(@Qualifier("dataSource02") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        // 使用的是同一套mapper
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/db02/*.xml"));
        return bean.getObject();
    }

    /**
     * 事物
     *
     * @param dataSource
     * @return
     */
    @Bean("dataSource02TransactionManager")
    public DataSourceTransactionManager dataSourceTransactionManager(@Qualifier("dataSource02") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean("sqlSessionTemplate02")
    public SqlSessionTemplate sqlSessionTemplate02(@Qualifier("dataSource02Factory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }


}
