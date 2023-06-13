package com.example.TokoKu.entity;


import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Categories")
public class Categories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private Long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Description")
    private String description;

    @Column(name = "img")
    private String img;

    public Categories(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
