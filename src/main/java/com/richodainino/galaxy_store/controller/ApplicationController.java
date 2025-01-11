package com.richodainino.galaxy_store.controller;

import com.richodainino.galaxy_store.model.Application;
import com.richodainino.galaxy_store.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @GetMapping("/applications")
    public ResponseEntity<List<Application>> getAllApplications() {
        List<Application> allApplications = applicationService.getAllApplications();
        return new ResponseEntity<>(allApplications, HttpStatus.OK);
    }

    @GetMapping("/application/{applicationID}")
    public ResponseEntity<Application> getApplicationByID(@PathVariable String applicationID) {
        Application existingApplication = applicationService.getApplicationByID(applicationID);
        return new ResponseEntity<>(existingApplication, HttpStatus.OK);
    }

    @PostMapping("/application")
    public ResponseEntity<Application> addApplication(@RequestBody Application application) {
        Application newApplication = applicationService.addApplication(application);
        return new ResponseEntity<>(newApplication, HttpStatus.CREATED);
    }

    @PutMapping("/application/{applicationID}")
    public ResponseEntity<Application> updateApplication(@PathVariable String applicationID, @RequestBody Application application) {
        Application updatedApplication = applicationService.updateApplication(applicationID, application);
        return new ResponseEntity<>(updatedApplication, HttpStatus.OK);
    }

    @DeleteMapping("/application/{applicationID}")
    public ResponseEntity<Application> deleteApplication(@PathVariable String applicationID) {
        applicationService.deleteApplication(applicationID);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
