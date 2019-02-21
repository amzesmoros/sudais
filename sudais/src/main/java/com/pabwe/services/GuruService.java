package com.pabwe.services;

import java.util.List;

import com.pabwe.model.*;

public interface GuruService {
	
	List<Guru> listGuru();
	
	Guru saveOrUpdate(Guru guru);
	
	Guru getGuruById(Integer guruId);
	
	void deleteGuru(Integer guruId);
}
