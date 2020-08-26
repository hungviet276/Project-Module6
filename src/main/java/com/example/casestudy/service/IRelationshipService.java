package com.example.casestudy.service;

import com.example.casestudy.model.Relationship;
import com.example.casestudy.model.Status;
import com.example.casestudy.model.User;
import org.springframework.stereotype.Service;

@Service
public interface IRelationshipService {
    Relationship saveRelationship(Relationship relationship);

    void deleteRelationship(Long id);

    Iterable<Relationship> findAllRelationship();

    Relationship findRelationshipById(Long id);

    Iterable<Relationship> findAllByRelatedUserIdAndStatus (Long id, Status status);

    Relationship findRelationshipByRelatingUserIdAndRelatedUserId (Long relatingUserId, Long relatedUserId);
    Iterable<Relationship> findAllByRelatingUserIdOrRelatedUserIdAndStatus (Long relatingUserId, Long relatedUserId ,Status status);

}
