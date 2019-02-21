package com.pabwe.dao;

import com.pabwe.model.UploadMateri;
import com.pabwe.services.UploadMateriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Service
public class UploadMateriDao implements UploadMateriService {

    private EntityManagerFactory emf;

    @Autowired
    public void setEmf(EntityManagerFactory emf){
        this.emf = emf;
    }

    @Override
    public List<UploadMateri> listUploadMateri() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("from UploadMateri", UploadMateri.class).getResultList();
    }

    @Override
    public UploadMateri saveOrUpdate(UploadMateri uploadMateri) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        UploadMateri saved = em.merge(uploadMateri);
        em.getTransaction().commit();
        return saved;
    }

    @Override
    public UploadMateri getUploadMateriById(Integer materiId) {
        EntityManager em = emf.createEntityManager();
        return em.find(UploadMateri.class, materiId);
    }

    @Override
    public void deleteMateri(Integer materiId) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(UploadMateri.class, materiId));
        em.getTransaction().commit();
    }
}
