package com.pabwe.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "semester")
public class Semester {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_semester")
    private Integer id;

    @Column(name = "nama_semester")
    private String semester;

    @Version
    private Integer version;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UploadMateri> uploadMateris;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Nilai> nilais;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public List<UploadMateri> getUploadMateris() {
        return uploadMateris;
    }

    public void setUploadMateris(List<UploadMateri> uploadMateris) {
        this.uploadMateris = uploadMateris;
    }

    public List<Nilai> getNilais() {
        return nilais;
    }

    public void setNilais(List<Nilai> nilais) {
        this.nilais = nilais;
    }
}
