package ru.digitalleague.spring_data.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "taxi_drive_info")
public class TaxiDriveInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long driver_id;

    @Column
    private String last_name;

    @Column
    private String first_name;

    @Column
    private String middle_name;

    @Column
    private Integer level;

    @Column
    private String car_model;

    @Column
    private Date create_dttm;
}
