package com.example.CarRent.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "rent")
public class Rent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate rentDay;
    private LocalDate rentEnd;
    @ManyToOne
    @JoinColumn(name = "client_Id")
    private Client client;
    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;
    }