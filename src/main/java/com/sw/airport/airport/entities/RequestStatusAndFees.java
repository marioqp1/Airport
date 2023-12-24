package com.sw.airport.airport.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "request_status_fees")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class RequestStatusAndFees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "fees")
    private float fees;

    @ManyToOne
    @JoinColumn(name = "request_id")
    private Request request;
}
