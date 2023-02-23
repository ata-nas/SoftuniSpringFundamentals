package com.softuni.workshop.model.entity;

import com.softuni.workshop.model.enums.EngineEnum;
import com.softuni.workshop.model.enums.TransmissionEnum;

import jakarta.persistence.*;

import lombok.*;
import lombok.experimental.SuperBuilder;


import java.math.BigDecimal;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@Entity
@Table(name = "offers")
@ToString(callSuper = true)
public class OfferEntity extends BaseExtendedEntity {

    @Column
    private String description;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EngineEnum engine;

    @Column
    private String imageUrl;

    @Column(nullable = false)
    private Integer mileage;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TransmissionEnum transmission;

    @Column(nullable = false)
    private Integer year;

    @ManyToOne
    private ModelEntity model;

    @ManyToOne
    private UserEntity seller;

}
