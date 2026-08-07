package com.placement.PC_Management.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "recruiters")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Recruiter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recruiterId;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    @Column(nullable = false, length = 150)
    private String companyName;

    @Column(length = 500)
    private String companyDescription;

    @Column(length = 255)
    private String companyWebsite;

    @Column(length = 100)
    private String companyLocation;

    @Column(length = 100)
    private String contactPerson;

    @Column(length = 20)
    private String contactNumber;
}