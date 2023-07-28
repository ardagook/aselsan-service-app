package com.ardagok.busstopapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.lang.reflect.Array;
import java.util.List;

@Getter
@Setter
@ToString
@Table(name = "bus_entity")
@Entity
public class BusEntity {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "no")
    private String no;

    @Column(name = "name")
    private String name;

    @Column(name = "busstops")
    private List<StopEntity> route= new Array[2];

}
