package com.richodainino.galaxy_store.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.Instant;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApplicationDTO {

    private String id;
    private String title;
    private String publisher;
    private String description;
    private int price;
    private Instant createdAt;
    private Instant updatedAt;

}
