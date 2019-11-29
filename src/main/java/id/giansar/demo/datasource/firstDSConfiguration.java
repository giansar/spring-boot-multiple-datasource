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
import org.springframework.context.annotation.Primary;
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
public class firstDSConfiguration {

    @Primary
    @Bean
    @ConfigurationProperties("datasource.first")
    public DataSourceProperties firstDSProperties() {
        return new DataSourceProperties();
    }

    @Primary
    @Bean("firstDS")
    @ConfigurationProperties("datasource.first")
    public HikariDataSource firstDS() {
        return (HikariDataSource) firstDSProperties().initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }

    @Primary
    @Bean(name = "jdbcTemplateFirstDS")
    public NamedParameterJdbcTemplate jdbcTemplateFirstDS(@Qualifier("firstDS") HikariDataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Primary
    @Bean("firstTransactionManager")
    public PlatformTransactionManager firstTransactionManager(@Qualifier("firstDS") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
