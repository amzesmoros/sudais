package com.pabwe.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="jurusan")
public class Jurusan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_jurusan")
    private Integer id;

    @Column(name = "jurusan")
    private String jurusan;

    @Version
    private Integer version;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Siswa> siswas;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public List<Siswa> getSiswas() {
        return siswas;
    }

    public void setSiswas(List<Siswa> siswas) {
        this.siswas = siswas;
    }

}
