package com.example.cooksys_website_backend.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import jakarta.persistence.Id;

import java.util.List;

@Entity
@NoArgsConstructor
@Data
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String first;
    private String last;
    private String email;
    private String phone;
    private Boolean active;
    private Boolean admin;
    private String status;

    @ManyToMany
    @JoinTable(
            name = "user_team",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "team_id")
    )
    @ToString.Exclude
    private List<Team> teams;

    @ManyToMany
    @JoinTable(
            name = "user_company",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "company_id")
    )
    @ToString.Exclude
    private List<Company> companies;

    @OneToMany(mappedBy = "author")
    @ToString.Exclude
    private List<Announcement> announcements;
}
