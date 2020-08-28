package com.example.casestudy.controller;

import com.example.casestudy.model.Relationship;
import com.example.casestudy.model.Status;
import com.example.casestudy.model.User;
import com.example.casestudy.service.relationship.IRelationshipService;
import com.example.casestudy.service.status.IStatusService;

import com.example.casestudy.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/relationship")
public class RelatioshipController {
    @Autowired
    private IRelationshipService relationshipService;
    @Autowired
    private IStatusService statusService;
    @Autowired
    private IUserService userService;
    @ModelAttribute("statusList")
    public Iterable<Status> statusList() {
        return statusService.findAllStatus();
    }
    @GetMapping("/")
    public ResponseEntity<Iterable<Relationship>> findAll() {
        return new ResponseEntity<>(relationshipService.findAllRelationship(), HttpStatus.OK);
    }
    @PostMapping("/create/{relatingId}/{relatedId}")
    public ResponseEntity<Relationship> addInviteFriend(@PathVariable Long relatingId,@PathVariable Long relatedId){
        Relationship relationship = this.checkRelationship(relatingId,relatedId);
        if (relationship==null){
            Relationship relationship1 = new Relationship(relatingId,relatedId);
            Status status = statusService.findStatusById(1L);
            relationship1.setStatus(status);
            relationshipService.saveRelationship(relationship1);
        }else {relationship.setStatus(statusService.findStatusById(1l));
            relationshipService.saveRelationship(relationship);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/edit/{relationshipId}/{statusId}")
    public ResponseEntity<Relationship> acceptInviteFriend(@PathVariable Long relationshipId,@PathVariable Long statusId){
        Relationship relationship = relationshipService.findRelationshipById(relationshipId);
        relationship.setStatus(statusService.findStatusById(statusId));
        return new ResponseEntity<>(relationshipService.saveRelationship(relationship), HttpStatus.OK);
    }

    @GetMapping("/listFriend/{userId}")
    public ResponseEntity<Iterable<User>> findAllFriend(@PathVariable Long userId) {
        Iterable<Relationship> relationships = relationshipService.findAllByRelatingUserIdOrRelatedUserIdAndStatus(userId,userId,statusService.findStatusById(2l));

        List<User> users = new ArrayList<>();
        for (Relationship relationship:relationships
             ) {if (relationship.getRelatingUserId().equals(userId)){
                 users.add(userService.findUserById(relationship.getRelatedUserId()));
        }else users.add(userService.findUserById(relationship.getRelatingUserId()));

        }

        return new ResponseEntity<Iterable<User>>(users, HttpStatus.OK);
    }
    @GetMapping("/listPending/{userId}")
    public ResponseEntity<Iterable<User>> findPending(@PathVariable Long userId){
        Iterable<Relationship> relationships = relationshipService.findAllByRelatedUserIdAndStatus(userId,statusService.findStatusById(1L));

        List<User> users = new ArrayList<>();
        for (Relationship relationship:relationships
        ) {
            users.add(userService.findUserById(relationship.getRelatingUserId()));
        }

        return new ResponseEntity<Iterable<User>>(users, HttpStatus.OK);
    }

    public Relationship checkRelationship(Long relatingId, Long relatedId){
        Relationship relationship ;
        if (relationshipService.findRelationshipByRelatingUserIdAndRelatedUserId(relatingId,relatedId)!=null){
            relationship = relationshipService.findRelationshipByRelatingUserIdAndRelatedUserId(relatingId,relatedId);
        }else if (relationshipService.findRelationshipByRelatingUserIdAndRelatedUserId(relatedId,relatingId)!=null){
            relationship = relationshipService.findRelationshipByRelatingUserIdAndRelatedUserId(relatedId,relatingId);
        }else relationship = null;
        return relationship;
    }


}