package org.hiring.api.service.company.usecase;


import org.hiring.api.service.company.RemoveCompanyServiceRequest;

public interface RemoveCompanyUseCase {

    void removeCompany(RemoveCompanyServiceRequest request);
}
