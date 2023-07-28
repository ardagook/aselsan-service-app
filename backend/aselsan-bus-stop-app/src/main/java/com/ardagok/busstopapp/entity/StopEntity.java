package com.ardagok.busstopapp.entity;

import com.bedatadriven.jackson.datatype.jts.serialization.GeometryDeserializer;
import com.bedatadriven.jackson.datatype.jts.serialization.GeometrySerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import org.locationtech.jts.geom.Point;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "stop_entity")
public class StopEntity {
    @Id
    @SequenceGenerator(
            name = "stop_sequence",
            sequenceName = "stop_sequence",
            allocationSize = 1,
            initialValue = 1000

    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "stop_sequence"
    )

    @Column(
            name = "id",
            updatable = false


    )
    private int id;
    @Column(
            name = "no",
            columnDefinition = "Text",
            updatable = false
    )
    private String no;

    @Column(
            name = "stop_name",
            columnDefinition = "Text"

    )
    private String stopName;


    @JsonSerialize(using = GeometrySerializer.class)
    @JsonDeserialize(using = GeometryDeserializer.class)
    @Column(name = "geometry", columnDefinition = "Geometry")
    private Point point;

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "StopEntity{" +
                "id=" + id +
                ", no='" + no + '\'' +
                ", stopName='" + stopName + '\'' +
                ", point=" + point+
                '}';
    }

    public StopEntity(String no, String stopName, Point point) {

        this.no = no;
        this.stopName = stopName;
        this.point= point;

    }

    public StopEntity() {


    }

    public String getStopName() {
        return stopName;
    }

    public void setStopName(String stopName) {
        this.stopName = stopName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

}


