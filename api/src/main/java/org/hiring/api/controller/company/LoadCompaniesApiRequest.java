package org.hiring.api.controller.company;

import jakarta.validation.constraints.Min;
import java.util.List;
import org.hiring.api.service.company.LoadCompaniesServiceRequest;

public record LoadCompaniesApiRequest(
    String name,
    String location,
    String industry,
    String[] keywords,
    @Min(1) int page,
    @Min(1) int size
) {

    public LoadCompaniesServiceRequest toServiceRequest() {
        return new LoadCompaniesServiceRequest(
            name,
            location,
            industry,
            keywords != null ? List.of(keywords) : List.of(),
            page,
            size
        );
    }
}