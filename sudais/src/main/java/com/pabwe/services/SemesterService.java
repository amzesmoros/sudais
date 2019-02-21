package com.pabwe.services;

import com.pabwe.model.Semester;

import java.util.List;

public interface SemesterService {
    List<Semester> listSemester();
    Semester saveOrUpdate(Semester semester);
    Semester getSemesterById(Integer semesterId);
    void deleteSemester(Integer semesterId);
}
