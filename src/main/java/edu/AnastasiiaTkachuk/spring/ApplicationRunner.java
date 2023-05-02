package edu.AnastasiiaTkachuk.spring;

import edu.AnastasiiaTkachuk.spring.database.pool.ConnectionPool;
import edu.AnastasiiaTkachuk.spring.database.repository.CompanyRepository;
import edu.AnastasiiaTkachuk.spring.database.repository.CrudRepository;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationRunner {
    public static void main(String[] args) {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml")) {

            ConnectionPool connectionPool = context.getBean("pool1", ConnectionPool.class);
            System.out.println(connectionPool);

            CrudRepository companyRepository = context.getBean("companyRepository", CrudRepository.class);
            System.out.println(companyRepository.findById(1));
        }
    }
}
