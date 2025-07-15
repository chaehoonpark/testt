package org.hiring.api.service.job;

import org.example.PagedResult;
import org.hiring.api.domain.Job;
import org.hiring.api.service.job.usecase.LoadJobUseCase;

public class LoadJobService implements LoadJobUseCase {

    @Override
    public Job loadJob(Long jobId) {
        return null;
    }

    @Override
    public PagedResult<Job> loadJobs(LoadJobsServiceRequest request) {
        return null;
    }
}
