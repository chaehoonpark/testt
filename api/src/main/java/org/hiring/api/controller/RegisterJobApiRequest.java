package org.hiring.api.controller;

import org.hiring.api.service.job.RegisterJobServiceRequest;

public record RegisterJobApiRequest() {

    public RegisterJobServiceRequest toServiceRequest() {
        return null;
    }
}
