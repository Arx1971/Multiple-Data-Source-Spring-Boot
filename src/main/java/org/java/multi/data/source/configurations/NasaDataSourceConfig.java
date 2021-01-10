package org.java.multi.data.source.configurations;

import org.java.multi.data.source.nasa.model.Astronaut;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = {"org.java.multi.data.source.nasa.repository"},
        entityManagerFactoryRef = "nasaDSFactory",
        transactionManagerRef = "nasaDSTransactionManager"
)
public class NasaDataSourceConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource2")
    public DataSourceProperties nasaDSProperties(){
        return new DataSourceProperties();
    }

    @Bean
    public DataSource nasaDS(@Qualifier("nasaDSProperties") DataSourceProperties nasaDSProperties ){
        return nasaDSProperties.initializeDataSourceBuilder().build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean nasaDSFactory(@Qualifier("nasaDS") DataSource nasaDS,
                                                                EntityManagerFactoryBuilder builder) {
        return builder.dataSource(nasaDS).packages("org.java.multi.data.source.nasa.model").build();
    }

    @Bean
    public PlatformTransactionManager nasaDSTransactionManager(@Qualifier("nasaDSFactory") EntityManagerFactory nasaDSFactory) {
        return new JpaTransactionManager(nasaDSFactory);
    }
}
