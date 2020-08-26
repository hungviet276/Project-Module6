package com.example.casestudy.controller;

import com.example.casestudy.model.Relationship;
import com.example.casestudy.model.Status;
import com.example.casestudy.model.User;
import com.example.casestudy.service.IRelationshipService;
import com.example.casestudy.service.IStatusService;
import com.example.casestudy.service.IUserService;
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
    @ModelAttribute("statuses")
    public Iterable<Status> provinces() {
        return statusService.findAllStatus();
    }
    @GetMapping("/")
    public ResponseEntity<Iterable<Relationship>> findAll() {
        return new ResponseEntity<>(relationshipService.findAllRelationship(), HttpStatus.OK);
    }
    @PostMapping("/create/{relatingId}/{relatedId}")
    public ResponseEntity<Relationship> addInviteFriend(@PathVariable Long relatingId,@PathVariable Long relatedId){
        Relationship relationship = new Relationship();
        relationship.setRelatingUserId(relatingId);
        relationship.setRelatedUserId(relatedId);
        relationship.setStatus(statusService.findStatusById(1l));
        return new ResponseEntity<>(relationshipService.saveRelationship(relationship), HttpStatus.OK);
    }

    @PutMapping("/create/{relationshipId}/{statusId}")
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
             ) {if (relationship.getRelatingUserId()==userId){
                 users.add(userService.findUserById(relationship.getRelatedUserId()));
        }else users.add(userService.findUserById(relationship.getRelatingUserId()));

        }

        return new ResponseEntity<Iterable<User>>(users, HttpStatus.OK);
    }


}
