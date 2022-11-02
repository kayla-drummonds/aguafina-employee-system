package com.michaeladrummonds.aguafina.models;

import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    @EqualsAndHashCode.Include
    private Integer id;

    @Column
    @EqualsAndHashCode.Include
    private String firstName;

    @Column
    @EqualsAndHashCode.Include
    private String lastName;

    @Column
    @EqualsAndHashCode.Include
    private String email;

    @Column
    @EqualsAndHashCode.Include
    private String address;

    @Column
    @EqualsAndHashCode.Include
    private String city;

    @Column
    @EqualsAndHashCode.Include
    private String state;

    @Column
    @EqualsAndHashCode.Include
    private String zipCode;

    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "employee", fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    private List<Order> orders;

}
