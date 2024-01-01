package com.sw.airport.airport.entities;

import lombok.*;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Long id;
    private String name;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "password",nullable = false)
    private String password;
    @Column(name = "mobile_num", nullable = false)
    private String mobileNum;
    @Column(name = "national_id", nullable = false, unique = true)
    private String nationalId;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "luggage_id", referencedColumnName = "id")
    private UserLuggageEntity userLuggageEntity;
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "extra_luggage_id", referencedColumnName = "id")
    private UserExtraLuggageEntity userExtraLuggageEntity;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "user_id")
    private List<RequestEntity> requestEntities = new LinkedList<>();
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "user_id")
    private List<FlightsEntity>flights = new LinkedList<>();

}
