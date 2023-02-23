package com.softuni.workshop.model.entity;

import com.softuni.workshop.model.enums.CategoryEnum;

import jakarta.persistence.*;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@Entity
@Table(name = "models")
@ToString(callSuper = true)
public class ModelEntity extends BaseExtendedEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CategoryEnum category;

    @Column(nullable = false)
    private String imageUrl;

    @Column(nullable = false)
    private Integer startYear;

    @Column
    private Integer endYear;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private BrandEntity brand;

}
