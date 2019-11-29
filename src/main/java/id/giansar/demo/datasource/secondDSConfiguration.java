/*
 * Demo | Spring Boot | Multiple Datasource
 */
package id.giansar.demo.datasource;

import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author giansar pratiknya
 */
@Configuration
@EnableTransactionManagement
public class secondDSConfiguration {

    @Bean
    @ConfigurationProperties("datasource.second")
    public DataSourceProperties secondDSProperties() {
        return new DataSourceProperties();
    }

    @Bean("secondDS")
    @ConfigurationProperties("datasource.second")
    public HikariDataSource secondDS() {
        return (HikariDataSource) secondDSProperties().initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }

    @Bean(name = "jdbcTemplateSecondDS")
    public NamedParameterJdbcTemplate jdbcTemplateSecondDS(@Qualifier("secondDS") HikariDataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Bean("secondTransactionManager")
    public PlatformTransactionManager secondTransactionManager(@Qualifier("secondDS") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
