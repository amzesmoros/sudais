package com.pabwe.dao;

import com.pabwe.model.Subject;
import com.pabwe.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Service
public class SubjectDao implements SubjectService {

    private EntityManagerFactory emf;

    @Autowired
    public void setEmf(EntityManagerFactory emf){
        this.emf = emf;
    }

    @Override
    public List<Subject> listSubject() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("from Subject", Subject.class).getResultList();
    }

    @Override
    public Subject saveOrUpdate(Subject subject) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Subject saved = em.merge(subject);
        em.getTransaction().commit();
        return saved;
    }

    @Override
    public Subject getSubjectById(Integer subjectId) {
        EntityManager em = emf.createEntityManager();
        return em.find(Subject.class, subjectId);
    }

    @Override
    public void deleteSubject(Integer subjectId) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(Subject.class, subjectId));
        em.getTransaction().commit();
    }
}
