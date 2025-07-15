package org.hiring.api.service.company.usecase;


import org.example.PagedResult;
import org.hiring.api.domain.Company;
import org.hiring.api.service.company.LoadCompaniesServiceRequest;
import org.hiring.api.service.company.LoadCompanyServiceRequest;

public interface LoadCompanyUseCase {
    PagedResult<Company> loadCompanies(LoadCompaniesServiceRequest request);
    Company loadCompany(LoadCompanyServiceRequest request);
}
