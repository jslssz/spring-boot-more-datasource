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
@MapperScan(basePackages = "com.hx.spring.boot.more.datasource.mapper.db01", sqlSessionTemplateRef = "sqlSessionTemplate01")
public class DataSource01Config {

    /**
     * 创建数据源01
     *
     * @return
     */
    @Bean("dataSource01")
    @ConfigurationProperties(prefix = "spring.datasource02")
    @Primary
    public DataSource dataSource01() {
        return DataSourceBuilder.create().build();
    }

    /**
     * 创建工厂
     *
     * @param dataSource
     * @return
     * @throws Exception
     */

    @Bean("dataSource01Factory")
    @Primary
    public SqlSessionFactory dataSource01Factory(@Qualifier("dataSource01") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/db01/*.xml"));
        return bean.getObject();
    }

    /**
     * 事物
     *
     * @param dataSource
     * @return
     */
    @Bean("dataSource01TransactionManager")
    public DataSourceTransactionManager dataSourceTransactionManager(@Qualifier("dataSource01") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean("sqlSessionTemplate01")
    @Primary
    public SqlSessionTemplate sqlSessionTemplate01(@Qualifier("dataSource01Factory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }


}
