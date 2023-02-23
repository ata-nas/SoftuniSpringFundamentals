package com.softuni.workshop.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@MappedSuperclass
@ToString(callSuper = true)
public abstract class BaseExtendedEntity extends BaseEntity {

    @Column
    private LocalDateTime created;

    @Column
    private LocalDateTime modified;

}
