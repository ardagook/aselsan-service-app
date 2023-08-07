package com.ardagok.busstopapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter

@Table(name = "bus_entity")
@Entity
public class BusEntity {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "no", unique = true)
    private String no;

    @Column(name = "name")
    private String name;

    @ManyToMany
    @JoinTable(
            name = "bus_stops",
            joinColumns = @JoinColumn(name = "bus_id"),
            inverseJoinColumns = @JoinColumn(name = "stop_id")
    )
    private Set<StopEntity> busStop;

    @ManyToMany
    @JoinTable(
            name = "bus_stops2",
            joinColumns = @JoinColumn(name = "bus_id"),
            inverseJoinColumns = @JoinColumn(name = "stop_id")
    )
    private Set<StopEntity> busStop2;

    @OneToMany(mappedBy = "bus")
    @JsonIgnore
    private Set<RouteEntity> routes;
}
