package edu.AnastasiiaTkachuk.spring.service;

import edu.AnastasiiaTkachuk.spring.database.entity.Company;
import edu.AnastasiiaTkachuk.spring.database.repository.CrudRepository;
import edu.AnastasiiaTkachuk.spring.dto.CompanyReadDto;
import edu.AnastasiiaTkachuk.spring.listener.entity.AccessType;
import edu.AnastasiiaTkachuk.spring.listener.entity.EntityEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CrudRepository<Integer, Company> companyRepository;
    private final UserService userService;
    private final ApplicationEventPublisher eventPublisher;


    public Optional<CompanyReadDto> findById(Integer id){
        return companyRepository.findById(id)
                .map(entity -> {
                    eventPublisher.publishEvent(new EntityEvent(entity, AccessType.READ));
                    return new CompanyReadDto(entity.id());
                });
    }

}
