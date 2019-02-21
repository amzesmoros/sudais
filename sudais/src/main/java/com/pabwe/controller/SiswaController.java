package com.pabwe.controller;

import com.pabwe.services.JurusanService;
import com.pabwe.services.KelasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.pabwe.model.Siswa;
import com.pabwe.services.SiswaService;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SiswaController {

	private SiswaService siswaService;
	private KelasService kelasService;
	private JurusanService jurusanService;

	@Autowired
	public void setSiswaService(SiswaService siswaService, KelasService kelasService, JurusanService jurusanService) {
		this.siswaService = siswaService;
		this.kelasService = kelasService;
		this.jurusanService = jurusanService;
	}

	@RequestMapping("/dataAkademikSiswa")
	public String DataSiswaList(Model model) {
		model.addAttribute("siswa", siswaService.listSiswa());
		return "dataAkademikSiswa";
	}

//	@RequestMapping(value="/akademik/siswa/create", method = RequestMethod.GET)
//	public String addDataSiswa(Model model) {
//		model.addAttribute("siswa", new Siswa());
//		model.addAttribute("listJurusan", jurusanService.listJurusan());
//		model.addAttribute("listKelas", kelasService.listKelas());
//		return "/form/formAddDataAkademikSiswa";
//	}

//	@RequestMapping(value="/akademik/siswa/create", method = RequestMethod.POST)
//	public String saveDataSiswa(@RequestParam("idKelas") String idKelas, @RequestParam("idJurusan") String idJurusan, Model model, Siswa siswa) {
//		siswa.setKelas(kelasService.getKelasById(Integer.parseInt(idKelas)));
//		siswa.setJurusan(jurusanService.getJurusanById(Integer.parseInt(idJurusan)));
//		model.addAttribute("siswa", siswaService.saveOrUpdate(siswa));
//		return "redirect:/dataAkademikSiswa";
//	}

	@RequestMapping(value="/siswa/edit/{siswaId}", method = RequestMethod.GET)
	public String editDataSiswa(@PathVariable Integer siswaId, Model model) {
		model.addAttribute("listJurusan", jurusanService.listJurusan());
		model.addAttribute("listKelas", kelasService.listKelas());
		model.addAttribute("siswa", siswaService.getSiswaById(siswaId));
		return "form/formAddDataAkademikSiswa";
	}

	@RequestMapping(value="/siswa/delete/{siswaId}", method = RequestMethod.GET)
	public String deleteSiswa(@PathVariable Integer siswaId) {
		siswaService.deleteSiswa(siswaId);
		return "redirect:/dataAkademikSiswa";
	}

	@RequestMapping(value = "siswa/view/{siswaId}")
	public String viewSiswa(@PathVariable Integer siswaId, Model model){
		Siswa siswa = siswaService.getSiswaById(siswaId);
		model.addAttribute("siswa", siswaService.getSiswaById(siswaId));
		model.addAttribute("jurusan", jurusanService);
		model.addAttribute("kelas", kelasService);
		return "view/viewSiswa";
	}

    @RequestMapping("/request/siswa")
    public String request(Model model){
	    model.addAttribute("siswa", siswaService.listSiswa());
        return "/requestDataSiswa";
    }


    private ModelAndView getModelAndView(@RequestParam(name = "siswaId") Integer siswaId, int i){
		ModelAndView model = new ModelAndView();
		siswaService.updateStatus(i, siswaId);
		model.setViewName("redirect:/requestDataSiswa");
		return model;
	}

	@RequestMapping(value = {"/siswa/accept"}, method = RequestMethod.POST)
    public ModelAndView accept(@RequestParam(name = "siswaId") Integer siswaId){
	    return getModelAndView(siswaId, 1);
    }

    @RequestMapping(value = {"/siswa/reject"}, method = RequestMethod.POST)
    public ModelAndView reject(@RequestParam(name = "siswaId") Integer siswaId){
	    return getModelAndView(siswaId, 2);
    }

}
