package com.goplanner.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Data
@AllArgsConstructor
public class CategoryDto {
    private String name;
    private boolean status;
    private Date updatedAt;

    @Builder
    public CategoryDto() {
        this.updatedAt = Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());
    }

}
