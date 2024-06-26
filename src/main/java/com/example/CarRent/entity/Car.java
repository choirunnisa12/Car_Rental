package com.example.CarRent.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private String model;
    private int year;
    private int door;
    private int seats;
    private BigDecimal dayCost;

    public Car(long l, String bmw, String number, int i, int i1, int i2, BigDecimal bigDecimal) {
    }
}
