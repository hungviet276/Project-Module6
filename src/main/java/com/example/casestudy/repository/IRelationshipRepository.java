package com.example.casestudy.repository;

import com.example.casestudy.model.Relationship;
import com.example.casestudy.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface IRelationshipRepository extends JpaRepository<Relationship,Long> {
    Iterable<Relationship> findAllByRelatedUserIdAndStatus (Long id, Status status);
    Relationship findRelationshipByRelatingUserIdAndRelatedUserId (Long relatingUserId, Long relatedUserId);
    Iterable<Relationship> findAllByRelatingUserIdOrRelatedUserIdAndStatus (Long relatingUserId, Long relatedUserId ,Status status);
}
