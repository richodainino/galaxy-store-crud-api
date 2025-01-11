package com.richodainino.galaxy_store.repository;

import com.richodainino.galaxy_store.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, String> {

    @Query(value = "SELECT * FROM application WHERE deleted_at IS NULL ORDER BY created_at", nativeQuery = true) /*Sort.by(Sort.DEFAULT_DIRECTION,"createdAt")*/
    List<Application> findAllNotDeleted();

    @Query(value = "SELECT * FROM application WHERE id = ?1 AND deleted_at IS NULL", nativeQuery = true)
    Application findNotDeletedByID(String applicationID);

}
