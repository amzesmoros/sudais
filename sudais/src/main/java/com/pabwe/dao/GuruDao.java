package com.pabwe.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pabwe.model.Guru;
import com.pabwe.services.GuruService;

@Service
public class GuruDao implements GuruService{
	
	private EntityManagerFactory emf;
	
	@Autowired
	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	@Override
	public List<Guru> listGuru() {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		return em.createQuery("from Guru", Guru.class).getResultList();
	}


	@Override
	public Guru saveOrUpdate(Guru guru) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Guru saved = em.merge(guru);
		em.getTransaction().commit();
		return saved;
	}

	@Override
	public Guru getGuruById(Integer guruId) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		return em.find(Guru.class, guruId);
	}

	@Override
	public void deleteGuru(Integer guruId) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.find(Guru.class, guruId));
		em.getTransaction().commit();
	}
	
}
