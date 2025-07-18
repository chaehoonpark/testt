package org.hiring.api.service.company.usecase;

import lombok.RequiredArgsConstructor;
import org.hiring.api.entity.CompanyJpaEntity;
import org.hiring.api.repository.company.CompanyRepository;
import org.hiring.api.service.company.RegisterCompanyServiceRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterCompanyService implements RegisterCompanyUseCase {

    private final CompanyRepository companyRepository;

    @Override
    public void registerCompany(RegisterCompanyServiceRequest request) {
        CompanyJpaEntity companyEntity = CompanyJpaEntity.builder()
            .name(request.name())
            .industry(request.industry())
            .description(request.description())
            .employeeCount(request.employeeCount())
            .foundedYear(request.foundedYear())
            .logoUrl(request.logoUrl())
            .websiteUrl(request.websiteUrl())
            .address(request.address())
            .build();

        companyRepository.save(companyEntity);
    }
}
