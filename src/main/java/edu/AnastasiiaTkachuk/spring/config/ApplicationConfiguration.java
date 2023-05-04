package edu.AnastasiiaTkachuk.spring.config;

import edu.AnastasiiaTkachuk.spring.database.pool.ConnectionPool;
import edu.AnastasiiaTkachuk.spring.database.repository.CrudRepository;
import edu.AnastasiiaTkachuk.spring.database.repository.UserRepository;
import edu.AnastasiiaTkachuk.web.config.WebConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

@Import(WebConfiguration.class)
@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages ="edu.AnastasiiaTkachuk.spring",
        useDefaultFilters = false,
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Component.class),
                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = CrudRepository.class),
                @ComponentScan.Filter(type = FilterType.REGEX, pattern = "edu\\..+Repository")
        })
public class ApplicationConfiguration {
        @Bean
        public ConnectionPool pool2(@Value("${db.username}") String username){
                return new ConnectionPool(username, 20);
        }

        @Bean
        public UserRepository userRepository2(ConnectionPool pool2){
                return new UserRepository(pool2);
        }
}
