package edu.AnastasiiaTkachuk.spring.integration.service;

import edu.AnastasiiaTkachuk.spring.ApplicationRunner;
import edu.AnastasiiaTkachuk.spring.database.entity.Company;
import edu.AnastasiiaTkachuk.spring.dto.CompanyReadDto;
import edu.AnastasiiaTkachuk.spring.listener.entity.EntityEvent;
import edu.AnastasiiaTkachuk.spring.service.CompanyService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.ConfigDataApplicationContextInitializer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

//@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = ApplicationRunner.class,
//    initializers = ConfigDataApplicationContextInitializer.class)
@SpringBootTest
public class CompanyServiceIT {
    private static final Integer COMPANY_ID = 1;
    @Autowired
    private CompanyService companyService;


    @Test
    void findById(){
        Optional<CompanyReadDto> actualResult = companyService.findById(COMPANY_ID);

        assertTrue(actualResult.isPresent());

        CompanyReadDto expectedResult = new CompanyReadDto(COMPANY_ID);
        actualResult.ifPresent(actual -> assertEquals(expectedResult, actual));

    }
}
