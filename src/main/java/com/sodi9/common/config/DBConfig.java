package com.sodi9.common.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DBConfig {
//	@Bean
//	@Primary
//	@ConfigurationProperties(prefix = "spring.datasource.mysql")
//	public DataSource dataSourceMysql() {
//		return DataSourceBuilder.create().build();
//	}

//	@Bean
//	@ConfigurationProperties(prefix = "spring.datasource.oracle")
//	public DataSource dataSourceOracle() {
//		return DataSourceBuilder.create().build();
//	}
//
//	@Bean
//	@ConfigurationProperties(prefix = "spring.datasource.postgres")
//	public DataSource dataSourcePostgres() {
//		return DataSourceBuilder.create().build();
//	}
//
//	@Bean
//	@ConfigurationProperties(prefix = "spring.datasource.sqlserver")
//	public DataSource dataSourceSqlserver() {
//		return DataSourceBuilder.create().build();
//	}
}
