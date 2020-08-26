package com.example.casestudy.service;

import com.example.casestudy.model.Status;
import com.example.casestudy.repository.IStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusService implements IStatusService {
    @Autowired
    private IStatusRepository iStatusRepository;

    @Override
    public Status saveStatus(Status status) {
        return iStatusRepository.save(status);
    }

    @Override
    public void deleteStatus(Long id) {
        iStatusRepository.deleteById(id);
    }

    @Override
    public Iterable<Status> findAllStatus() {
        return iStatusRepository.findAll();
    }

    @Override
    public Status findStatusById(Long id) {
        return iStatusRepository.findById(id).get();
    }
}
