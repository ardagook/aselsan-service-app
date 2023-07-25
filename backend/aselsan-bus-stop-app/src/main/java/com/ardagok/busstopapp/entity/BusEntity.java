package com.ardagok.busstopapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "bus_entity")
@Entity
public class BusEntity {
    @Id
    @Column(name = "id", updatable = false)
    private int id;
    @Column(name = "no", nullable = false)
    private String no;

    public BusEntity(int id, String no) {
        this.id = id;
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
