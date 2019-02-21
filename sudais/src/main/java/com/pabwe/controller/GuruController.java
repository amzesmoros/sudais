package com.pabwe.controller;

import com.pabwe.model.Guru;
import com.pabwe.services.GuruService;
import com.pabwe.services.KelasService;
import com.pabwe.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GuruController {

	private GuruService guruService;
	private SubjectService subjectService;
	private KelasService kelasService;

	@Autowired
	public void setGuruService(GuruService guruService, SubjectService subjectService, KelasService kelasService) {
		this.guruService = guruService;
		this.subjectService = subjectService;
		this.kelasService = kelasService;
	}

	@RequestMapping("/dataAkademikGuru")
	public String DataGuruList(Model model) {
		model.addAttribute("guru", guruService.listGuru());
		return "dataAkademikGuru";
	}

//	@RequestMapping(value="/akademik/guru/create", method = RequestMethod.GET)
//	public String addDataGuru(Model model) {
//		model.addAttribute("guru", new Guru());
//		model.addAttribute("listSubject", subjectService.listSubject());
//		model.addAttribute("listKelas", kelasService.listKelas());
//		return "/form/formAddDataAkademikGuru";
//	}

//	@RequestMapping(value="/akademik/guru/create", method = RequestMethod.POST)
//	public String saveDataGuru(@RequestParam("idSubject") String idSubject, @RequestParam("idKelas") String idKelas, Model model, Guru guru) {
//		guru.setSubject(subjectService.getSubjectById(Integer.parseInt(idSubject)));
//		guru.setKelas(kelasService.getKelasById(Integer.parseInt(idKelas)));
//		model.addAttribute("guru", guruService.saveOrUpdate(guru));
//		return "redirect:/dataAkademikGuru";
//	}

	@RequestMapping(value="/guru/edit/{guruId}", method = RequestMethod.GET)
	public String editDataGuru(@PathVariable Integer guruId, Model model) {
		model.addAttribute("listSubject", subjectService.listSubject());
		model.addAttribute("listKelas", kelasService.listKelas());
		model.addAttribute("guru", guruService.getGuruById(guruId));
		return "form/formAddDataAkademikGuru";
	}

	@RequestMapping(value="/guru/delete/{guruId}", method = RequestMethod.GET)
	public String deleteGuru(@PathVariable Integer guruId) {
		guruService.deleteGuru(guruId);
		return "redirect:/dataAkademikGuru";
	}

	@RequestMapping(value = "/guru/view/{guruId}")
	public String viewGuru(@PathVariable Integer guruId, Model model){
		Guru guru = guruService.getGuruById(guruId);
		model.addAttribute("guru", guruService.getGuruById(guruId));
		model.addAttribute("subject", subjectService);
		model.addAttribute("kelas", kelasService);
		return "view/viewGuru";
	}

}
