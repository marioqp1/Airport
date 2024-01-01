package com.sw.airport.airport.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "flights")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FlightsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "airport_id")
    private Long airportId;

    @Column(name = "destination")
    private String destination;

    @Column(name = "origin")
    private String origin;

    @Column(name = "arrives_at")
    private LocalTime arrivesAt;

    @Column(name = "depart_at")
    private LocalTime departAt;

    @Column(name = "airport_name")
    private String airportName;

}
