package org.hiring.api.service.company;

import static org.assertj.core.api.Assertions.assertThat;

import org.hiring.api.common.AbstractServiceTest;
import org.hiring.api.entity.CompanyJpaEntity;
import org.hiring.api.repository.company.CompanyRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class RemoveCompanyServiceTest extends AbstractServiceTest {

    @Autowired
    private RemoveCompanyService removeCompanyService;

    @Autowired
    private CompanyRepository companyRepository;

    @Test
    @DisplayName("[정상 케이스] 회사 삭제 - 회사가 존재할 때")
    void remove_company_when_exists() {
        // given - 상황 만들기
        CompanyJpaEntity company = fixtureMonkey.giveMeBuilder(CompanyJpaEntity.class)
            .set("id", null)
            .set("jobs", null)
            .sample();
        companyRepository.save(company);

        Long companyId = company.getId();

        // when - 동작
        removeCompanyService.removeCompany(companyId);
        em.flush();
        em.clear();

        // then - 검증
        assertThat(companyRepository.existsById(companyId)).isFalse();
    }

}