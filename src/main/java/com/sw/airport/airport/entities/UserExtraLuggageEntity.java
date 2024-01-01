package com.sw.airport.airport.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "user_extra_luggage")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class UserExtraLuggageEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Long id;
    @Column(name = "extra_weight")
    private Integer extraWeight;
}
