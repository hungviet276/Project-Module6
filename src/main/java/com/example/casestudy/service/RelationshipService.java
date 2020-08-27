package com.example.casestudy.service;

import com.example.casestudy.model.Relationship;
import com.example.casestudy.model.Status;
import com.example.casestudy.repository.IRelationshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RelationshipService implements IRelationshipService{
    @Autowired
    private IRelationshipRepository iRelationshipRepository;
    @Override
    public Relationship saveRelationship(Relationship relationship) {
        return iRelationshipRepository.save(relationship);
    }

    @Override
    public void deleteRelationship(Long id) {
        iRelationshipRepository.deleteById(id);
    }

    @Override
    public Iterable<Relationship> findAllRelationship() {
        return iRelationshipRepository.findAll();
    }

    @Override
    public Relationship findRelationshipById(Long id) {
        return iRelationshipRepository.findById(id).get();
    }

    @Override
    public Iterable<Relationship> findAllByRelatedUserIdAndStatus(Long id, Status status) {
        return iRelationshipRepository.findAllByRelatedUserIdAndStatus(id,status);
    }

    @Override
    public Relationship findRelationshipByRelatingUserIdAndRelatedUserId(Long relatingId, Long relatedId) {
        return iRelationshipRepository.findRelationshipByRelatingUserIdAndRelatedUserId(relatingId,relatedId);
    }

    @Override
    public Iterable<Relationship> findAllByRelatingUserIdOrRelatedUserIdAndStatus(Long relatingUserId, Long relatedUserId, Status status) {
        return iRelationshipRepository.findAllByRelatingUserIdOrRelatedUserIdAndStatus(relatingUserId,relatedUserId,status);
    }


}

