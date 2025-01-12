package com.richodainino.galaxy_store.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@Entity
@Table(name = "application")
@EntityListeners(AuditingEntityListener.class)
@Data
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String id;

    @NotNull(message = "Title is required")
    @Column(name = "title")
    private String title;

    @NotNull(message = "Publisher is required")
    @Column(name = "publisher")
    private String publisher;

    @NotNull(message = "Description is required")
    @Column(name = "description")
    private String description;

    @Column(name = "price") // Price can be null for free apps (0 rupiah)
    private int price;

    @CreatedDate
    @Column(name = "created_at", nullable = false)
    @JsonProperty("created_at")
    private Instant createdAt;

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false)
    @JsonProperty("updated_at")
    private Instant updatedAt;

    @Column(name = "deleted_at")
    @JsonProperty("deleted_at")
    private Instant deletedAt;

}
