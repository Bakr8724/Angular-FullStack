package com.example.cooksys_website_backend.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@NoArgsConstructor
@Data
@ToString
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @ManyToMany(mappedBy = "companies")
    @ToString.Exclude
    private List<User> users;

    @OneToMany(mappedBy = "company")
    @ToString.Exclude
    private List<Team> teams;

    @OneToMany(mappedBy = "company")
    @ToString.Exclude
    private List<Announcement> announcements;
}
