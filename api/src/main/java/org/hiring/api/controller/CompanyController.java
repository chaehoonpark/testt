package org.hiring.api.controller;

import lombok.RequiredArgsConstructor;
import org.hiring.api.service.company.usecase.LoadCompanyUseCase;
import org.hiring.api.service.company.usecase.ModifyCompanyUseCase;
import org.hiring.api.service.company.usecase.RegisterCompanyUseCase;
import org.hiring.api.service.company.usecase.RemoveCompanyUseCase;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/companies")
@RequiredArgsConstructor
public class CompanyController {

    private final RegisterCompanyUseCase registerCompanyUseCase;
    private final ModifyCompanyUseCase modifyCompanyUseCase;
    private final LoadCompanyUseCase loadCompanyUseCase;
    private final RemoveCompanyUseCase removeCompanyUseCase;


}
