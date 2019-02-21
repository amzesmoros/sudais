package com.pabwe.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="kelas")
public class Kelas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="nama_kelas")
	private String kelas;

	@Version
	private Integer version;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Guru> gurus;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Siswa> siswas;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getKelas() {
		return kelas;
	}

	public void setKelas(String kelas) {
		this.kelas = kelas;
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

	public List<Siswa> getSiswas() {
		return siswas;
	}

	public void setSiswas(List<Siswa> siswas) {
		this.siswas = siswas;
	}

}
