package org.hiring.api.common;

import jakarta.persistence.EntityManager;
import org.hiring.api.service.company.LoadCompanyService;
import org.hiring.api.service.company.ModifyCompanyService;
import org.hiring.api.service.company.RemoveCompanyService;
import org.hiring.api.service.company.usecase.RegisterCompanyService;
import org.hiring.api.service.job.LoadJobService;
import org.hiring.api.service.job.ModifyJobService;
import org.hiring.api.service.job.RegisterJobService;
import org.hiring.api.service.job.RemoveJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SpringBootTest
@ActiveProfiles("test")
public abstract class AbstractServiceTest {

    @Autowired
    protected EntityManager em;

}
