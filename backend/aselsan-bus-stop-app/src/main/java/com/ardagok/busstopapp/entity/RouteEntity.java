package com.ardagok.busstopapp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.locationtech.jts.geom.LineString;

import java.util.Set;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Setter
@Getter
@ToString
@Table(name = "route_entity")
@Entity
public class RouteEntity {
    @Id
    @SequenceGenerator(
            name = "route_sequence",
            sequenceName = "route_sequence",
            allocationSize = 1,
            initialValue = 100000

    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "route_sequence"
    )
    @Column(name = "id")
    private int id;

    @Column(name = "route", columnDefinition = "Geometry")

    private LineString lineString;


    @ManyToOne
    @JoinColumn(name = "bus_id")
    private BusEntity bus;

}
