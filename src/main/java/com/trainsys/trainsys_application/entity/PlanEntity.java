package com.trainsys.trainsys_application.entity;

import com.trainsys.trainsys_application.config.database.DatabaseSchema;
import jakarta.persistence.*;

@Entity
@Table(name = "plans", schema = DatabaseSchema.DEV)
public class PlanEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "students_limit", nullable = false)
    private Short studentsLimit;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Short getStudentsLimit() {
        return studentsLimit;
    }

    public void setStudentsLimit(Short studentsLimit) {
        this.studentsLimit = studentsLimit;
    }
}
