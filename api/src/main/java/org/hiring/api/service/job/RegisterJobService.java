package org.hiring.api.service.job;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.hiring.api.entity.JobJpaEntity;
import org.hiring.api.mapper.JobMapper;
import org.hiring.api.repository.CompanyRepository;
import org.hiring.api.repository.JobRepository;
import org.hiring.api.service.job.usecase.RegisterJobUseCase;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterJobService implements RegisterJobUseCase {

    private final JobMapper jobMapper;
    private final JobRepository jobRepository;
    private final CompanyRepository companyRepository;

    @Override
    public void registerJob(RegisterJobServiceRequest request) {
        final var companyJpaEntity = companyRepository.findById(request.companyId())
            .orElseThrow(() -> new EntityNotFoundException("Company not found with ID: " + request.companyId()));

        final var jobJpaEntity = JobJpaEntity.builder()
            .company(companyJpaEntity)
            .title(request.title())
            .description(request.description())
            .city(request.city())
            .district(request.district())
            .employmentType(request.employmentType())
            .salaryMin(request.salaryMin())
            .salaryMax(request.salaryMax())
            .postedAt(request.postedAt())
            .deadline(request.deadline())
            .requirements(request.requirements())
            .benefits(request.benefits())
            .build();

        jobRepository.save(jobJpaEntity);
    }
}
