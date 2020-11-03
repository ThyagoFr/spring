package ufc.thyago.multipledatabases.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import ufc.thyago.multipledatabases.infrastructure.postgres.repository.LivroRepository;

import javax.sql.DataSource;

/**
 * Criado por : Thyago Freitas
 * Data :  02/11/2020
 * Projeto  : multiple-databases
 **/

@Configuration
@EnableJpaRepositories(
        entityManagerFactoryRef = "livroEntityManager",
        basePackageClasses = LivroRepository.class
)
public class LivroDBConfig {

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "livro.datasource")
    public DataSource livroDataSource(){
        return DataSourceBuilder
                .create()
                .build();
    }

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean livroEntityManager(
            EntityManagerFactoryBuilder builder,
            @Qualifier("livroDataSource") DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("ufc.thyago.multipledatabases.infrastructure.postgres.model")
                .build();
    }

}
