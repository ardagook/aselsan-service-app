package com.ardagok.busstopapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Getter
@Setter

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

    @ManyToMany
    @JoinTable(
            name = "bus_stops",
            joinColumns = @JoinColumn(name="bus_id"),
            inverseJoinColumns = @JoinColumn(name = "stop_id")
    )


    private Set<StopEntity> busStop;

}
