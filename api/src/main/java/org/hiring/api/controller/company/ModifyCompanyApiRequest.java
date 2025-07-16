package org.hiring.api.controller.company;

import org.hiring.api.service.company.ModifyCompanyServiceRequest;

public record ModifyCompanyApiRequest(
    String name,
    String industry,
    String description,
    String employeeCount,
    Integer foundedYear,
    String logoUrl,
    String websiteUrl,
    String address
) {
    public ModifyCompanyServiceRequest toServiceRequest(Long companyId) {
        return new ModifyCompanyServiceRequest(
            companyId, name, industry, description, employeeCount,
            foundedYear, logoUrl, websiteUrl, address
        );
    }
}