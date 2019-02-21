package com.pabwe.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pabwe.model.Siswa;
import com.pabwe.services.SiswaService;

@Service
public class SiswaDao implements SiswaService{
	
	private EntityManagerFactory emf;
	
	@Autowired
	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public List<Siswa> listSiswa() {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		return em.createQuery("from Siswa", Siswa.class).getResultList();
	}

	@Override
	public Siswa saveOrUpdate(Siswa siswa) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Siswa saved = em.merge(siswa);
		em.getTransaction().commit();
		return saved;
	}

	@Override
	public Siswa getSiswaById(Integer siswaId) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		return em.find(Siswa.class, siswaId);
	}

	@Override
	public void deleteSiswa(Integer siswaId) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.find(Siswa.class, siswaId));
		em.getTransaction().commit();
	}

	@Override
	public void updateStatus(Integer status, Integer siswaId) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Siswa siswa = em.find(Siswa.class, siswaId);
		siswa.setStatus(status);
		em.merge(siswa);
		em.getTransaction().commit();
	}

}
