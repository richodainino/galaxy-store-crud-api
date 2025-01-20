package com.richodainino.galaxy_store.controller;

import com.richodainino.galaxy_store.dto.ApplicationDTO;
import com.richodainino.galaxy_store.handler.ResponseHandler;
import com.richodainino.galaxy_store.model.Application;
import com.richodainino.galaxy_store.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @GetMapping("/applications")
    public ResponseEntity<Object> getAllApplications(@RequestParam(required = false) String category) {
        List<Application> allApplications = new ArrayList<>();
        if (category != null) {
            allApplications = applicationService.getAllApplicationsByCategory(category);
        } else {
            allApplications = applicationService.getAllApplications();
        }

        // Mapping DTO
        List<ApplicationDTO> resDTO = new ArrayList<>();
        for (Application app : allApplications) {
            ApplicationDTO dto = new ApplicationDTO();
            dto.setId(app.getId());
            dto.setTitle(app.getTitle());
            dto.setPublisher(app.getPublisher());
            dto.setCategory(app.getCategory());
            dto.setPrice(app.getPrice());
            resDTO.add(dto);
        }

        String message = "Successfully retrieved all applications";
        return ResponseHandler.generateResponse(HttpStatus.OK, message, resDTO);
    }

    @GetMapping("/application/{applicationID}")
    public ResponseEntity<Object> getApplicationByID(@PathVariable String applicationID) {
        Application existingApplication = applicationService.getApplicationByID(applicationID);

        // Mapping DTO
        ApplicationDTO resDTO = new ApplicationDTO();
        resDTO.setId(existingApplication.getId());
        resDTO.setTitle(existingApplication.getTitle());
        resDTO.setPublisher(existingApplication.getPublisher());
        resDTO.setCategory(existingApplication.getCategory());
        resDTO.setDescription(existingApplication.getDescription());
        resDTO.setPrice(existingApplication.getPrice());
        resDTO.setCreatedAt(existingApplication.getCreatedAt());
        resDTO.setUpdatedAt(existingApplication.getUpdatedAt());

        String message = "Successfully retrieved the application";
        return ResponseHandler.generateResponse(HttpStatus.OK, message, resDTO);
    }

    @PostMapping("/application")
    public ResponseEntity<Object> addApplication(@RequestBody Application application) {
        Application newApplication = applicationService.addApplication(application);

        // Mapping DTO
        ApplicationDTO resDTO = new ApplicationDTO();
        resDTO.setId(newApplication.getId());
        resDTO.setTitle(newApplication.getTitle());
        resDTO.setPublisher(newApplication.getPublisher());
        resDTO.setCategory(newApplication.getCategory());
        resDTO.setDescription(newApplication.getDescription());
        resDTO.setPrice(newApplication.getPrice());

        String message = "Successfully created new application";
        return ResponseHandler.generateResponse(HttpStatus.CREATED, message, resDTO);
    }

    @PutMapping("/application/{applicationID}")
    public ResponseEntity<Object> updateApplication(@PathVariable String applicationID, @RequestBody Application application) {
        Application updatedApplication = applicationService.updateApplication(applicationID, application);

        // Mapping DTO
        ApplicationDTO resDTO = new ApplicationDTO();
        resDTO.setId(updatedApplication.getId());
        resDTO.setTitle(updatedApplication.getTitle());
        resDTO.setPublisher(updatedApplication.getPublisher());
        resDTO.setCategory(updatedApplication.getCategory());
        resDTO.setDescription(updatedApplication.getDescription());
        resDTO.setPrice(updatedApplication.getPrice());

        String message = "Successfully updated the application";
        return ResponseHandler.generateResponse(HttpStatus.OK, message, resDTO);
    }

    @DeleteMapping("/application/{applicationID}")
    public ResponseEntity<Object> deleteApplication(@PathVariable String applicationID) {
        applicationService.deleteApplication(applicationID);
        String message = "Successfully deleted the application";
        return ResponseHandler.generateResponse(HttpStatus.OK, message, null);
    }

}
