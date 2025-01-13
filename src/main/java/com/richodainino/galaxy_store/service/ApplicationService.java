package com.richodainino.galaxy_store.service;

import com.richodainino.galaxy_store.exception.ResourceNotFoundException;
import com.richodainino.galaxy_store.model.Application;
import com.richodainino.galaxy_store.repository.ApplicationRepository;
import com.richodainino.galaxy_store.utils.ErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    public List<Application> getAllApplications() {
        return applicationRepository.findByDeletedAtIsNullOrderByCreatedAt();
    }

    public Application getApplicationByID(String applicationID) {
        Application application = applicationRepository.findByIdAndDeletedAtIsNull(applicationID);
        if (application == null) {
            throw new ResourceNotFoundException(ErrorMessage.ERROR_APPLICATION_NOT_FOUND);
        }
        return application;
    }

    public Application addApplication(Application application) {
        return applicationRepository.save(application);
    }

    public Application updateApplication(String applicationID, Application application) {
        Application existingApplication = applicationRepository.findByIdAndDeletedAtIsNull(applicationID);
        if (existingApplication == null) {
            throw new ResourceNotFoundException(ErrorMessage.ERROR_APPLICATION_NOT_FOUND);
        }
        existingApplication.setTitle(application.getTitle());
        existingApplication.setPublisher(application.getPublisher());
        existingApplication.setDescription(application.getDescription());
        existingApplication.setPrice(application.getPrice());
        applicationRepository.save(existingApplication);
        return existingApplication;
    }

    public void deleteApplication(String applicationID) {
        Application existingApplication = applicationRepository.findByIdAndDeletedAtIsNull(applicationID);
        if (existingApplication == null) {
            throw new ResourceNotFoundException(ErrorMessage.ERROR_APPLICATION_NOT_FOUND);
        }
        existingApplication.setDeletedAt(Instant.now());
        applicationRepository.save(existingApplication);
    }

}
