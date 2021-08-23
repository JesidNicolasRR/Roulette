/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Masiv.Roulette.config;

/**
 *
 * @author Usuario
 */
import java.util.Properties;
 
import javax.sql.DataSource;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

 
@EnableJpaRepositories("com.Masiv.Roulette.config")
@EnableTransactionManagement
@ComponentScan("com.Masiv.Roulette.config")
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class SpringConfiguracion {
 
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(oracle.jdbc.driver.OracleDriver.class.getName());
        dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
        dataSource.setUsername("Roulette");
        dataSource.setPassword("admin");
        return dataSource;
    }
 
    @Bean
    LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
 
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource);
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setPackagesToScan("com.Masiv.Roulette.entity");
 
        Properties jpaProperties = new Properties();
 
        jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
 
        entityManagerFactoryBean.setJpaProperties(jpaProperties);
 
        return entityManagerFactoryBean;
         
    }
     
    @Bean public PlatformTransactionManager transactionManager() {
         
        JpaTransactionManager txManager= new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory(dataSource()).getObject());
        return txManager;
         
    }
}