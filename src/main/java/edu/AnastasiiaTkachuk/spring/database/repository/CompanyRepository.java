package edu.AnastasiiaTkachuk.spring.database.repository;

import edu.AnastasiiaTkachuk.spring.database.bpp.InjectBean;
import edu.AnastasiiaTkachuk.spring.database.bpp.Transaction;
import edu.AnastasiiaTkachuk.spring.database.entity.Company;
import edu.AnastasiiaTkachuk.spring.database.pool.ConnectionPool;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Transaction
public class CompanyRepository implements CrudRepository<Integer, Company>{
    @InjectBean
    private ConnectionPool connectionPool;

    @PostConstruct
    private void init(){
        System.out.println("Init company repository");
    }

    @Override
    public Optional<Company> findById(Integer id) {
        System.out.println("findById method...");
        return Optional.of(new Company(id));
    }

    @Override
    public void delete(Company entity) {
        System.out.println("delete method...");
    }
}
