package com.sw.airport.airport.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Long id;
    private String name;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "mobile_num", nullable = false)
    private String mobileNum;
    @Column(name = "national_id", nullable = false, unique = true)
    private String nationalId;
    @OneToOne(cascade = CascadeType.ALL)//fetch = FetchType.LAZY
    @JoinColumn(name = "fk_user_luggage_id")
    private UserLuggage userLuggage;
    @OneToMany(mappedBy = "user")
    private List<Request> requests = new ArrayList<>();
    @OneToOne(mappedBy = "user")
    private UserExtraLuggage userExtraLuggage;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Flights>flights = new ArrayList<>();



}
