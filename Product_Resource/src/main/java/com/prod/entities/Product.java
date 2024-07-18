package com.prod.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.prod.Enum.Category;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Product code is mandatory")
    @Column(unique = true)
    private String productCode;

    @NotNull(message = "Date of manufacturing is mandatory")
    private LocalDate dateOfManufacturing;

    @Enumerated(EnumType.STRING)
    private Category category;

    public Product(Long id, @NotBlank String name, @NotBlank String productCode,
                   @NotNull LocalDate dateOfManufacturing, Category category) {
        this.id = id;
        this.name = name;
        this.productCode = productCode;
        this.dateOfManufacturing = dateOfManufacturing;
        this.category = category;
    }
}
