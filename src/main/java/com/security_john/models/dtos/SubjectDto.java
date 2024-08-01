package com.security_john.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Data
@AllArgsConstructor
public class SubjectDto {
    public String name;
    public boolean status;
    private Date updatedAt;

    @Builder
    public SubjectDto() {
        this.updatedAt = Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());
    }
}

