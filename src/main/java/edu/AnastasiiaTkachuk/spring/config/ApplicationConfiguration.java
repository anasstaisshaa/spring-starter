package edu.AnastasiiaTkachuk.spring.config;

import edu.AnastasiiaTkachuk.spring.database.repository.CrudRepository;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


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
}
