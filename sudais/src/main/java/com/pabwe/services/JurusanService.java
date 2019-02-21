package com.pabwe.services;

import com.pabwe.model.Jurusan;

import java.util.List;

public interface JurusanService {
    List<Jurusan> listJurusan();
    Jurusan saveOrUpdate(Jurusan jurusan);
    Jurusan getJurusanById(Integer jurusanId);
    void deleteJurusan(Integer jurusanId);
}
