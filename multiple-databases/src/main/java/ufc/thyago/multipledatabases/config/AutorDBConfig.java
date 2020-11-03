package ufc.thyago.multipledatabases.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import ufc.thyago.multipledatabases.infrastructure.mysql.repository.AutorRepository;

import javax.sql.DataSource;

/**
 * Criado por : Thyago Freitas
 * Data :  02/11/2020
 * Projeto  : multiple-databases
 **/

@Configuration
@EnableJpaRepositories(
        entityManagerFactoryRef = "autorEntityManager",
        basePackageClasses = AutorRepository.class
)
public class AutorDBConfig {

    @Bean
    @ConfigurationProperties(prefix = "autor.datasource")
    public DataSource autorDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean autorEntityManager(
            EntityManagerFactoryBuilder builder,
            @Qualifier("autorDataSource") DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("ufc.thyago.multipledatabases.infrastructure.mysql.model")
                .build();
    }

}
