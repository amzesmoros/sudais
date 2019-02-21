package com.pabwe.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "mapel")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "mapel")
    private String mapel;

    @Version
    private Integer version;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Guru> gurus;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Nilai> nilais;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMapel() {
        return mapel;
    }

    public void setMapel(String mapel) {
        this.mapel = mapel;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public List<Guru> getGurus() {
        return gurus;
    }

    public void setGurus(List<Guru> gurus) {
        this.gurus = gurus;
    }

    public List<Nilai> getNilais() {
        return nilais;
    }

    public void setNilais(List<Nilai> nilais) {
        this.nilais = nilais;
    }
}
