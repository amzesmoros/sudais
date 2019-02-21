package com.pabwe.dao;

import com.pabwe.model.Nilai;
import com.pabwe.services.NilaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Service
public class NilaiDao implements NilaiService {

    private EntityManagerFactory emf;

    @Autowired
    public void setEmf(EntityManagerFactory emf){
        this.emf = emf;
    }

    @Override
    public List<Nilai> listNilai() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("from Nilai", Nilai.class).getResultList();
    }

    @Override
    public Nilai saveOrUpdate(Nilai nilai) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Nilai saved = em.merge(nilai);
        em.getTransaction().commit();
        return saved;
    }

    @Override
    public Nilai getNilaiById(Integer nilaiId) {
        EntityManager em = emf.createEntityManager();
        return em.find(Nilai.class, nilaiId);
    }

    @Override
    public void deleteNilai(Integer nilaiId) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(Nilai.class, nilaiId));
        em.getTransaction().commit();
    }
}
