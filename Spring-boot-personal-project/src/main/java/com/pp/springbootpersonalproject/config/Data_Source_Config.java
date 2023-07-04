package com.pp.springbootpersonalproject.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class Data_Source_Config {
    @Bean
   public DataSource dataSource()
   {
       DataSourceBuilder<?>dataSourceBuilder=DataSourceBuilder.create();
       dataSourceBuilder.driverClassName("com.mysql.jdbc.Driver");
       dataSourceBuilder.url("jdbc:mySQL://localhost:3306/csdl_myblog");
       dataSourceBuilder.username("root");
       dataSourceBuilder.password("");

       return dataSourceBuilder.build();
   }
}
