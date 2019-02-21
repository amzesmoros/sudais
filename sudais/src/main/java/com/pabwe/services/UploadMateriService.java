package com.pabwe.services;

import com.pabwe.model.UploadMateri;

import java.util.List;

public interface UploadMateriService {

    List<UploadMateri> listUploadMateri();

    UploadMateri saveOrUpdate(UploadMateri uploadMateri);

    UploadMateri getUploadMateriById(Integer materiId);

    void deleteMateri(Integer materiId);
}
