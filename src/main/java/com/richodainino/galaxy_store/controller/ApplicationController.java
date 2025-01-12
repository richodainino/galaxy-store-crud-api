package com.richodainino.galaxy_store.controller;

import com.richodainino.galaxy_store.handler.ResponseHandler;
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
    public ResponseEntity<Object> getAllApplications() {
        List<Application> allApplications = applicationService.getAllApplications();
        String message = "Successfully retrieved all applications";
        return ResponseHandler.generateResponse(HttpStatus.OK, message, allApplications);
    }

    @GetMapping("/application/{applicationID}")
    public ResponseEntity<Object> getApplicationByID(@PathVariable String applicationID) {
        Application existingApplication = applicationService.getApplicationByID(applicationID);
        String message = "Successfully retrieved the application";
        return ResponseHandler.generateResponse(HttpStatus.OK, message, existingApplication);
    }

    @PostMapping("/application")
    public ResponseEntity<Object> addApplication(@RequestBody Application application) {
        Application newApplication = applicationService.addApplication(application);
        String message = "Successfully created new application";
        return ResponseHandler.generateResponse(HttpStatus.CREATED, message, newApplication);
    }

    @PutMapping("/application/{applicationID}")
    public ResponseEntity<Object> updateApplication(@PathVariable String applicationID, @RequestBody Application application) {
        Application updatedApplication = applicationService.updateApplication(applicationID, application);
        String message = "Successfully updated the application";
        return ResponseHandler.generateResponse(HttpStatus.OK, message, updatedApplication);
    }

    @DeleteMapping("/application/{applicationID}")
    public ResponseEntity<Object> deleteApplication(@PathVariable String applicationID) {
        applicationService.deleteApplication(applicationID);
        String message = "Successfully deleted the application";
        return ResponseHandler.generateResponse(HttpStatus.OK, message, null);
    }

}
