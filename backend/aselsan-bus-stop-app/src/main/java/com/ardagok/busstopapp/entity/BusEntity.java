package com.ardagok.busstopapp.entity;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.SEQUENCE;


@Table(name = "bus_entity")
@Entity
public class BusEntity {
    @Id
    @SequenceGenerator(
            name = "bus_sequence",
            sequenceName = "bus_sequence",
            allocationSize = 1,
            initialValue = 100
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "bus_sequence"
    )
    @Column(name = "id", updatable = false)
    private int id;
    @Column(name = "no", nullable = false)
    private String no;

    public BusEntity(String no) {

        this.no = no;
    }


    public BusEntity() {

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

    @Override
    public String toString() {
        return "BusEntity{" + "id=" + id + ", no='" + no + '\'' + '}';
    }
}
