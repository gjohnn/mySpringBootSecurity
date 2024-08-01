package com.security_john.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "subjects", uniqueConstraints = {@UniqueConstraint(columnNames = {"name"})})
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    @Column
    public String name;
    @Column
    public boolean status;

    @Column(updatable = false)
    private Date createdAt;

    @Column
    private Date updatedAt;
}
