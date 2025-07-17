package org.hiring.api.common;

import org.hiring.api.mapper.CompanyMapper;
import org.hiring.api.mapper.JobMapper;
import org.hiring.api.service.company.LoadCompanyService;
import org.hiring.api.service.company.ModifyCompanyService;
import org.hiring.api.service.company.RemoveCompanyService;
import org.hiring.api.service.company.usecase.RegisterCompanyService;
import org.hiring.api.service.job.LoadJobService;
import org.hiring.api.service.job.ModifyJobService;
import org.hiring.api.service.job.RegisterJobService;
import org.hiring.api.service.job.RemoveJobService;
import org.springframework.context.annotation.Import;

@Import({
    // Company 관련 서비스 및 매퍼
    RegisterCompanyService.class,
    LoadCompanyService.class,
    ModifyCompanyService.class,
    RemoveCompanyService.class,
    CompanyMapper.class,

    // Job 관련 서비스 및 매퍼
    RegisterJobService.class,
    LoadJobService.class,
    ModifyJobService.class,
    RemoveJobService.class,
    JobMapper.class
})
public abstract class AbstractServiceTest extends AbstractJpaTest{

}
