package edu.AnastasiiaTkachuk.spring.service;

import edu.AnastasiiaTkachuk.spring.database.entity.Company;
import edu.AnastasiiaTkachuk.spring.database.repository.CompanyRepository;
import edu.AnastasiiaTkachuk.spring.database.repository.CrudRepository;
import edu.AnastasiiaTkachuk.spring.database.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final CrudRepository<Integer, Company> companyRepository;

}
