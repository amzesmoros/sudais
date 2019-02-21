package com.pabwe.dao;

import com.pabwe.model.Semester;
import com.pabwe.services.SemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Service
public class SemesterDao implements SemesterService {

    private EntityManagerFactory emf;

    @Autowired
    public void setEmf(EntityManagerFactory emf){
        this.emf = emf;
    }

    @Override
    public List<Semester> listSemester() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("from Semester", Semester.class).getResultList();
    }

    @Override
    public Semester saveOrUpdate(Semester semester) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Semester saved = em.merge(semester);
        em.getTransaction().commit();
        return saved;
    }

    @Override
    public Semester getSemesterById(Integer semesterId) {
        EntityManager em = emf.createEntityManager();
        return em.find(Semester.class, semesterId);
    }

    @Override
    public void deleteSemester(Integer semesterId) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(Semester.class, semesterId));
        em.getTransaction().commit();
    }
}
