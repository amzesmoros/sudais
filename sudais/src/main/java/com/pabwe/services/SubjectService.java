package com.pabwe.services;

import com.pabwe.model.Subject;

import java.util.List;

public interface SubjectService {
    List<Subject> listSubject();
    Subject saveOrUpdate(Subject subject);
    Subject getSubjectById(Integer subjectId);
    void deleteSubject(Integer subjectId);
}
