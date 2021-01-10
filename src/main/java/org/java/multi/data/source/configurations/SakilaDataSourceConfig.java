package org.java.multi.data.source.configurations;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.java.multi.data.source.sakila.model.Actor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = {"org.java.multi.data.source.sakila.repository"},
        entityManagerFactoryRef = "sakilaDSFactory",
        transactionManagerRef = "sakilaDSTransactionManager"
)
public class SakilaDataSourceConfig {

    @Primary
    @Bean
    @ConfigurationProperties("spring.datasource1")
    public DataSourceProperties sakilaDSProperties(){
        return new DataSourceProperties();
    }

    @Primary
    @Bean
    public DataSource sakilaDS(@Qualifier("sakilaDSProperties") DataSourceProperties sakilaDSProperties){
        return sakilaDSProperties.initializeDataSourceBuilder().build();
    }

    @Primary
    @Bean
    public LocalContainerEntityManagerFactoryBean sakilaDSFactory(@Qualifier("sakilaDS") DataSource sakilaDS,
                                                                  EntityManagerFactoryBuilder builder){
        return builder.dataSource(sakilaDS).packages(Actor.class).build();
    }

    @Primary
    @Bean
    public PlatformTransactionManager sakilaDSTransactionManager(EntityManagerFactory sakilaDSFactory){
        return new JpaTransactionManager(sakilaDSFactory);
    }

}
