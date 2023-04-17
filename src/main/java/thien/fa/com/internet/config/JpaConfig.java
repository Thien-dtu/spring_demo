package thien.fa.com.internet.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
@EnableJpaRepositories(basePackages = "thien.fa.com.internet.repositories")
public class JpaConfig {

  @Bean
  public DataSource dataSource() {
     DriverManagerDataSource dataSource = new DriverManagerDataSource();
     dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
     dataSource.setUrl("jdbc:sqlserver://localhost:1433;databaseName=springmvc_demo;encrypt=true;trustServerCertificate=true;sendTimeAsDateTime=false");
     dataSource.setUsername("thien");
     dataSource.setPassword("123456");
     return dataSource;
  }

  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
     HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
     vendorAdapter.setGenerateDdl(true);

     LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
     factory.setJpaVendorAdapter(vendorAdapter);
     factory.setDataSource(dataSource());
     factory.setPackagesToScan("thien.fa.com.internet.entities");

     Properties jpaProperties = new Properties();
     jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.SQLServerDialect");
     jpaProperties.put("hibernate.show_sql", "true");
     jpaProperties.put("hibernate.hbm2ddl.auto", "update");
     jpaProperties.put("hibernate.show_sql", "true");
     jpaProperties.put("hibernate.enable_lazy_load_no_trans", "true");
     jpaProperties.put("hibernate.format_sql", "true");
     factory.setJpaProperties(jpaProperties);

     return factory;
  }

  @Bean
  public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
     JpaTransactionManager transactionManager = new JpaTransactionManager();
     transactionManager.setEntityManagerFactory(entityManagerFactory);
     return transactionManager;
  }

}
