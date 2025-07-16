package org.hiring.api.service.job.usecase;

import org.hiring.api.service.job.RemoveJobServiceRequest;

public interface RemoveJobUseCase {

    void removeJob(Long jobid);
}
