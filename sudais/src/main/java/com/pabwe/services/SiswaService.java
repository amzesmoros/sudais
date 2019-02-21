package com.pabwe.services;

import java.util.List;

import com.pabwe.model.*;

public interface SiswaService {
	
	List<Siswa> listSiswa();
	
	Siswa saveOrUpdate(Siswa siswa);
	
	Siswa getSiswaById(Integer siswaId);
	
	void deleteSiswa(Integer siswaId);

	void updateStatus(Integer status, Integer siswaId);
}
