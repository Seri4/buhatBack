package com.sleepAllDay.buhatBack.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "bar")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Bar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "address")
    private String address;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "average_price")
    private Double averagePrice;

}
