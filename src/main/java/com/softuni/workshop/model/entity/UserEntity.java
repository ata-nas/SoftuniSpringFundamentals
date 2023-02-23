package com.softuni.workshop.model.entity;

import jakarta.persistence.*;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@Entity
@Table(name = "users")
@ToString(callSuper = true)
public class UserEntity extends BaseExtendedEntity {

    @Column(nullable = false)
    private String email;

    @Column
    private String password;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private Boolean isActive;

    @ManyToMany
    private List<UserRoleEntity> userRoles;

    @Column
    private String imageUrl;

    public UserEntity addRole(UserRoleEntity role) {
        userRoles.add(role);
        return this;
    }

}
