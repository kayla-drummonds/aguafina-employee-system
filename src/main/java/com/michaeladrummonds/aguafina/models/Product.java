package com.michaeladrummonds.aguafina.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    @NotNull
    private String code;

    @Column
    @NotNull
    private String variety;

    @Column
    @NotNull
    private int size;

    @Column
    @NotNull
    private double price;

    @Column
    @NotNull
    private String status;

    @Column
    @NotNull
    private String image;
}
