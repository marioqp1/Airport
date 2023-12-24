package com.sw.airport.airport.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Entity
@Table(name = "user_luggage")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserLuggage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_luggage_id", nullable = false)
    private Long id;
    @OneToOne(mappedBy = "userLuggage")
    private UserEntity user;
    @Column(name = "weight", nullable = false)
    private int weight;

}
