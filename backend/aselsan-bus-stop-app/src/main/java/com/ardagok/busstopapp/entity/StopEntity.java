package com.ardagok.busstopapp.entity;

import com.bedatadriven.jackson.datatype.jts.serialization.GeometryDeserializer;
import com.bedatadriven.jackson.datatype.jts.serialization.GeometrySerializer;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.locationtech.jts.geom.Point;

import java.util.Set;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Getter
@Setter

@Entity
@Table(name = "stop_entity")
public class StopEntity {
    @Id
    @SequenceGenerator(name = "stop_sequence", sequenceName = "stop_sequence", allocationSize = 1, initialValue = 1000)
    @GeneratedValue(strategy = SEQUENCE, generator = "stop_sequence")
    @Column(name = "id", updatable = false)
    private int id;

    @Column(name = "no", columnDefinition = "Text", unique = true)
    private String no;

    @Column(name = "stop_name", columnDefinition = "Text")
    private String stopName;

    @JsonSerialize(using = GeometrySerializer.class)
    @JsonDeserialize(using = GeometryDeserializer.class)
    @Column(name = "geometry", columnDefinition = "Geometry")
    private Point point;

    @JsonBackReference
    @ManyToMany(mappedBy = "busStop")
    Set<BusEntity> busList;

    @JsonBackReference
    @ManyToMany(mappedBy = "busStop2")
    Set<BusEntity> busList2;


}


