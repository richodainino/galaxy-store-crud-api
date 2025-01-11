package com.richodainino.galaxy_store.service;

import com.richodainino.galaxy_store.model.Application;
import com.richodainino.galaxy_store.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    public List<Application> getAllApplications() {
        return applicationRepository.findAll(Sort.by(Sort.DEFAULT_DIRECTION,"createdAt"));
    }

    public Application getApplicationByID(UUID applicationID) {
        return applicationRepository.findById(applicationID).orElseThrow(() -> new RuntimeException("Application Not Found"));
    }

    public Application addApplication(Application application) {
        return applicationRepository.save(application);
    }

    public Application updateApplication(UUID applicationID, Application application) {
        Application existingApplication = applicationRepository.findById(applicationID).orElseThrow(() -> new RuntimeException("Application Not Found"));
        existingApplication.setTitle(application.getTitle());
        existingApplication.setPublisher(application.getPublisher());
        existingApplication.setDescription(application.getDescription());
        existingApplication.setPrice(application.getPrice());
        applicationRepository.save(existingApplication);
        return existingApplication;
    }

    public void deleteApplication(UUID applicationID) {
        Application existingApplication = applicationRepository.findById(applicationID).orElseThrow(() -> new RuntimeException("Application Not Found"));
        applicationRepository.delete(existingApplication);
    }

}
