package com.pabwe.dao;

import com.pabwe.model.Jurusan;
import com.pabwe.services.JurusanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Service
public class JurusanDao implements JurusanService {

    private EntityManagerFactory emf;

    @Autowired
    public void setEmf(EntityManagerFactory emf){
        this.emf = emf;
    }

    @Override
    public List<Jurusan> listJurusan() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("from Jurusan", Jurusan.class).getResultList();
    }

    @Override
    public Jurusan saveOrUpdate(Jurusan jurusan) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Jurusan saved = em.merge(jurusan);
        em.getTransaction().commit();
        return saved;
    }

    @Override
    public Jurusan getJurusanById(Integer jurusanId) {
        EntityManager em = emf.createEntityManager();
        return em.find(Jurusan.class, jurusanId);
    }

    @Override
    public void deleteJurusan(Integer jurusanId) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(Jurusan.class, jurusanId));
        em.getTransaction().commit();
    }
}
