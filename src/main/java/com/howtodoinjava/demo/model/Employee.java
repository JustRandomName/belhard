package com.howtodoinjava.demo.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "EMPLOYEES")
@Getter
@Setter
public class Employee {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email", nullable = false, length = 200)
    private String email;
//
//    @OneToMany(mappedBy = "employee")
//    private List<Book> books = new ArrayList<>();

    @Override
    public String toString() {
        return "Employee [id=" + id + ", firstName=" + firstName +
                ", lastName=" + lastName + ", email=" + email + "]";
    }
}