package it.objectmethod.generaXml;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DBConfig{

       @Bean
       public DataSource dataSource(){
          DriverManagerDataSource dataSource = new DriverManagerDataSource();
          dataSource.setDriverClassName("com.sybase.jdbc3.jdbc.SybDriver");
          dataSource.setUrl("jdbc:sybase:Tds:192.168.10.99:2638/asteroid");
          dataSource.setUsername( "cometa" );
          dataSource.setPassword( "cometa" );
          return dataSource;
       }

}
