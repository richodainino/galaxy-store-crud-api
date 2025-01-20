package com.richodainino.galaxy_store.repository;

import com.richodainino.galaxy_store.model.Application;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, String> {

    List<Application> findAllByDeletedAtIsNull(Pageable pageable);

    @NativeQuery(value = "SELECT * FROM application WHERE category = :category AND deleted_at IS NULL ORDER BY created_at")
    List<Application> findAllByCategory(@Param("category") String category);

    Application findByIdAndDeletedAtIsNull(String applicationID);

}
