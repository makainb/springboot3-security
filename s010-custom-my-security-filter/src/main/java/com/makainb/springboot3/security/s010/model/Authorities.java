package com.makainb.springboot3.security.s010.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "t_authorities")
public class Authorities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String authority;
}
