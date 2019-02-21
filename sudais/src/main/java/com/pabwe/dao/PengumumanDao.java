package com.pabwe.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pabwe.model.Pengumuman;
import com.pabwe.services.PengumumanService;

@Service
public class PengumumanDao implements PengumumanService{
	
	private EntityManagerFactory emf;
	
	@Autowired
	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	@Override
	public List<Pengumuman> listPengumuman() {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		return em.createQuery("from Pengumuman", Pengumuman.class).getResultList();
	}

	@Override
	public Pengumuman saveOrUpdate(Pengumuman pengumuman) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Pengumuman saved = em.merge(pengumuman);
		em.getTransaction().commit();
		return saved;
	}

	@Override
	public Pengumuman getPengumumanById(Integer pengumumanId) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		return em.find(Pengumuman.class, pengumumanId);
	}

	@Override
	public void deletePengumuman(Integer pengumumanId) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.find(Pengumuman.class, pengumumanId));
		em.getTransaction().commit();
	}
}
