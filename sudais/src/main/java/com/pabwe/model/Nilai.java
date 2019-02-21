package com.pabwe.model;

import javax.persistence.*;

@Entity
@Table(name = "nilai")
public class Nilai {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "kuis")
    private Integer kuis;

    @Column(name = "tugas")
    private Integer tugas;

    @Column(name = "uts")
    private Integer uts;

    @Column(name = "uas")
    private Integer uas;

    @Column(name = "nilai_akhir")
    private Float nilai_akhir;

    @Version
    private Integer version;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "semester_id")
    private Semester semester;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "siswa_id")
    private Siswa siswa;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getKuis() {
        return kuis;
    }

    public void setKuis(Integer kuis) {
        this.kuis = kuis;
    }

    public Integer getTugas() {
        return tugas;
    }

    public void setTugas(Integer tugas) {
        this.tugas = tugas;
    }

    public Integer getUts() {
        return uts;
    }

    public void setUts(Integer uts) {
        this.uts = uts;
    }

    public Integer getUas() {
        return uas;
    }

    public void setUas(Integer uas) {
        this.uas = uas;
    }

    public Float getNilai_akhir() {
        return nilai_akhir;
    }

    public void setNilai_akhir(Float nilai_akhir) {
        this.nilai_akhir = nilai_akhir;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Siswa getSiswa() {
        return siswa;
    }

    public void setSiswa(Siswa siswa) {
        this.siswa = siswa;
    }

}
