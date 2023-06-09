package edu.AnastasiiaTkachuk.spring.database.repository;

import edu.AnastasiiaTkachuk.spring.database.bpp.Auditing;
import edu.AnastasiiaTkachuk.spring.database.bpp.InjectBean;
import edu.AnastasiiaTkachuk.spring.database.bpp.Transaction;
import edu.AnastasiiaTkachuk.spring.database.entity.Company;
import edu.AnastasiiaTkachuk.spring.database.pool.ConnectionPool;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Slf4j
@Transaction
@Repository
@Scope(BeanDefinition.SCOPE_SINGLETON)
@Auditing
@RequiredArgsConstructor
public class CompanyRepository implements CrudRepository<Integer, Company>{
    private final ConnectionPool pool1;
    private final List<ConnectionPool> pools;
    @Value("${db.pool.size}")
    private final Integer poolSize;

    @PostConstruct
    private void init(){
        log.info("Init company repository");
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
