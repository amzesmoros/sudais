package com.pabwe.services;

import java.util.List;

import com.pabwe.model.Pengumuman;

public interface PengumumanService {
	
	List<Pengumuman> listPengumuman();
	
	Pengumuman saveOrUpdate(Pengumuman pengumuman);
	
	Pengumuman getPengumumanById(Integer pengumumanId);
	
	void deletePengumuman(Integer pengumumanId);

}
