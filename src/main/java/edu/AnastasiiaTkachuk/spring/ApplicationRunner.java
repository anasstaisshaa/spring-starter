package edu.AnastasiiaTkachuk.spring;

import edu.AnastasiiaTkachuk.spring.database.pool.ConnectionPool;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationRunner {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        ConnectionPool connectionPool = context.getBean("pool1", ConnectionPool.class);
        System.out.println(connectionPool);

    }
}
