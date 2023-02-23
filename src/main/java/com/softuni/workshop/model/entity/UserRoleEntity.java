package com.softuni.workshop.model.entity;

import com.softuni.workshop.model.enums.UserRoleEnum;

import jakarta.persistence.*;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@Entity
@Table(name = "user_roles")
@ToString(callSuper = true)
public class UserRoleEntity extends BaseEntity {

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRoleEnum role;

}
