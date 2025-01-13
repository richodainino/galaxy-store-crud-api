package com.richodainino.galaxy_store.repository;

import com.richodainino.galaxy_store.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, String> {

    List<Application> findByDeletedAtIsNullOrderByCreatedAt();

    Application findByIdAndDeletedAtIsNull(String applicationID);

}
