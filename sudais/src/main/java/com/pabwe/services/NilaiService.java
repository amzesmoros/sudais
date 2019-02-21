package com.pabwe.services;

import com.pabwe.model.Nilai;

import java.util.List;

public interface NilaiService {

    List<Nilai> listNilai();

    Nilai saveOrUpdate(Nilai nilai);

    Nilai getNilaiById(Integer nilaiId);

    void deleteNilai(Integer nilaiId);
}
