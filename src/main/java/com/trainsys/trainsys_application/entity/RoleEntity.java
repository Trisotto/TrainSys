package com.trainsys.trainsys_application.entity;

import com.trainsys.trainsys_application.config.database.DatabaseSchema;
import jakarta.persistence.*;

@Entity
@Table(name = "roles", schema = DatabaseSchema.DEV)
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;

    @Column(unique = true, nullable = false)
    @Enumerated(EnumType.STRING)
    private RoleEnum name;

    @Column(nullable = false)
    private String description;

    public Integer getId() {
        return id;
    }

    public RoleEnum getName() {
        return name;
    }

    public RoleEntity setName(RoleEnum name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public RoleEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public String toString() {
        return STR."Role{id=\{id}, name='\{name}\{'\''}, description='\{description}\{'}'}";
    }
}
