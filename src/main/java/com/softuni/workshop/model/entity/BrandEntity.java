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
@Table(name = "brands")
@ToString(callSuper = true)
public class BrandEntity extends BaseExtendedEntity {

    @Column(nullable = false)
    private String name;

    @OneToMany(
            mappedBy = "brand",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<ModelEntity> models;

}
