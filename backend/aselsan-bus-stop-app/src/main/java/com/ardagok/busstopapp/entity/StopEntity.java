package com.ardagok.busstopapp.entity;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "stop_entity")
public class StopEntity {
    @Id
    @SequenceGenerator(
            name = "stop_sequence",
            sequenceName = "stop_sequence",
            allocationSize = 1
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

    public StopEntity(String no) {

        this.no = no;
    }

    public StopEntity() {

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
        return "StopEntity{" +
                "id=" + id +
                ", no='" + no + '\'' +
                '}';
    }
}


