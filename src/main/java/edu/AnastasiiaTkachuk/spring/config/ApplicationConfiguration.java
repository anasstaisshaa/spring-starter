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
public class ApplicationConfiguration {
        @Bean
        public ConnectionPool pool2(@Value("${db.username}") String username){
                return new ConnectionPool(username, 20);
        }

        @Bean
        public ConnectionPool pool3(){
                return new ConnectionPool("test-pool", 25);
        }

        @Bean
        @Profile("prod|web")
        public UserRepository userRepository2(ConnectionPool pool2){
                return new UserRepository(pool2);
        }
        @Bean
        public UserRepository userRepository3(){
                return new UserRepository(pool3());
        }
}
