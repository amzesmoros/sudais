package com.pabwe.dao;

import com.pabwe.model.Kelas;
import com.pabwe.services.KelasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Service
public class KelasDao implements KelasService {

    private EntityManagerFactory emf;

    @Autowired
    public void setEmf(EntityManagerFactory emf){
        this.emf = emf;
    }

    @Override
    public List<Kelas> listKelas() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("from Kelas", Kelas.class).getResultList();
    }

    @Override
    public Kelas saveOrUpdate(Kelas kelas) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Kelas saved = em.merge(kelas);
        em.getTransaction().commit();
        return saved;
    }

    @Override
    public Kelas getKelasById(Integer kelasId) {
        EntityManager em = emf.createEntityManager();
        return em.find(Kelas.class, kelasId);
    }

    @Override
    public void deleteKelas(Integer kelasId) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(Kelas.class, kelasId));
        em.getTransaction().commit();
    }
}
