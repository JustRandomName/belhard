package com.howtodoinjava.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "book")
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column
    private String name;

    @ManyToOne(fetch = EAGER, cascade = ALL)
    @JoinColumn(name = "empl_id", nullable = false, referencedColumnName="id")
    private Employee employee;

}
