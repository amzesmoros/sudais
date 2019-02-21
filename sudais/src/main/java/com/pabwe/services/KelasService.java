package com.pabwe.services;

import com.pabwe.model.Kelas;

import java.util.List;

public interface KelasService {
    List<Kelas> listKelas();
    Kelas saveOrUpdate(Kelas kelas);
    Kelas getKelasById(Integer kelasId);
    void deleteKelas(Integer kelasId);
}
