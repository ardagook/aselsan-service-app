package com.ardagok.busstopapp.entity;

import com.bedatadriven.jackson.datatype.jts.serialization.GeometryDeserializer;
import com.bedatadriven.jackson.datatype.jts.serialization.GeometrySerializer;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
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
    @JsonSerialize(using = GeometrySerializer.class)
    @JsonDeserialize(using = GeometryDeserializer.class)
    @Column(name = "route", columnDefinition = "Geometry")

    private LineString lineString;


    @ManyToOne


    @JoinColumn(name = "bus_id")
    private BusEntity bus;

}
