package ru.digitalleague.spring_data.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CityQueue")
public class CityQueue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long city_id;

    @Column
    private String name;

    @Column
    private String queue;
}
