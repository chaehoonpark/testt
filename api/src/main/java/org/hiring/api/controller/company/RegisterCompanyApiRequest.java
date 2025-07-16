package org.hiring.api.controller.company;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.hiring.api.service.company.RegisterCompanyServiceRequest;

public record RegisterCompanyApiRequest(
    @NotBlank String name,
    @NotBlank String industry,
    String description,
    @NotBlank String employeeCount,
    @NotNull @Positive Integer foundedYear,
    @NotBlank String logoUrl,
    @NotBlank String websiteUrl,
    @NotBlank String address
) {
    public RegisterCompanyServiceRequest toServiceRequest() {
        return new RegisterCompanyServiceRequest(
            name, industry, description, employeeCount,
            foundedYear, logoUrl, websiteUrl, address
        );
    }
}