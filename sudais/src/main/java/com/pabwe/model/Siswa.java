package com.pabwe.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="siswa")
public class Siswa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name="nisn")
	private String nisn;
	
	@Column(name="nama")
	private String name;
	
	@Column(name="tempat_lahir")
	private String birthPlace;
	
	@Column(name="tanggal_lahir")
	private Date birthTime;

	@NotBlank
	@Column(name="jk")
	private String gender;
	
	@Column(name="agama")
	private String religion;
	
	@Column(name="nama_ayah")
	private String namaAyah;
	
	@Column(name="nama_ibu")
	private String namaIbu;
	
	@Column(name="alamat")
	private String address;

	@Version
	private Integer version;

	@Column(name = "no_hp")
	private String phoneNumber;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "kelas_id")
	private Kelas kelas;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "jurusan_id")
	private Jurusan jurusan;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Nilai> nilais;

	@Column(name = "status")
    private Integer status=0;

	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	private User user;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "siswa_role", joinColumns = @JoinColumn(name = "siswa_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNisn() {
		return nisn;
	}

	public void setNisn(String nisn) {
		this.nisn = nisn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	public Date getBirthTime() {
		return birthTime;
	}

	public void setBirthTime(Date birthTime) {
		this.birthTime = birthTime;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getNamaAyah() {
		return namaAyah;
	}

	public void setNamaAyah(String namaAyah) {
		this.namaAyah = namaAyah;
	}

	public String getNamaIbu() {
		return namaIbu;
	}

	public void setNamaIbu(String namaIbu) {
		this.namaIbu = namaIbu;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Kelas getKelas() {
		return kelas;
	}

	public void setKelas(Kelas kelas) {
		this.kelas = kelas;
	}

	public Jurusan getJurusan() {
		return jurusan;
	}

	public void setJurusan(Jurusan jurusan) {
		this.jurusan = jurusan;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<Nilai> getNilais() {
		return nilais;
	}

	public void setNilais(List<Nilai> nilais) {
		this.nilais = nilais;
	}

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
