package com.example.casestudy.service;

import com.example.casestudy.model.Relationship;
import com.example.casestudy.model.Status;
import org.springframework.stereotype.Service;

@Service
public interface IStatusService {
    Status saveStatus(Status status);

    void deleteStatus(Long id);

    Iterable<Status> findAllStatus();

    Status findStatusById(Long id);
}
