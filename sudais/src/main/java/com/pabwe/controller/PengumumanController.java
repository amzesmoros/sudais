package com.pabwe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pabwe.model.Pengumuman;
import com.pabwe.services.PengumumanService;

@Controller
public class PengumumanController {
	
	private PengumumanService pengumumanService;
	
	@Autowired
	public void setPengumumanService(PengumumanService pengumumanService) {
		this.pengumumanService = pengumumanService;
	}
	
	@RequestMapping("/pengumuman")
	public String PengumumanList(Model model) {
		model.addAttribute("pengumuman", pengumumanService.listPengumuman());
		return "pengumuman";
	}

	@RequestMapping(value ="/pengumuman/create", method = RequestMethod.GET)
	public String addPengumuman(Model model) {
		model.addAttribute("pengumuman", new Pengumuman());
		return "/form/formAddPengumuman";
	}
	
	@RequestMapping(value="/pengumuman/create", method = RequestMethod.POST)
	public String savePengumuman(Model model, Pengumuman pengumuman) {
		model.addAttribute("pengumuman", pengumumanService.saveOrUpdate(pengumuman));
		return "redirect:/pengumuman";
	}
	
	@RequestMapping(value="/pengumuman/edit/{pengumumanId}", method = RequestMethod.GET)
	public String editPengumuman(@PathVariable Integer pengumumanId, Model model) {
		model.addAttribute("pengumuman", pengumumanService.getPengumumanById(pengumumanId));
		return "form/formAddPengumuman";
	}
	
	@RequestMapping(value="/pengumuman/delete/{pengumumanId}", method = RequestMethod.GET)
	public String deletePengumuman(@PathVariable Integer pengumumanId) {
		pengumumanService.deletePengumuman(pengumumanId);
		return "redirect:/pengumuman";
	}

	@RequestMapping(value="/pengumuman/view/{pengumumanId}")
	public String viewPengumuman(@PathVariable Integer pengumumanId, Model model){
		Pengumuman pengumuman = pengumumanService.getPengumumanById(pengumumanId);
		model.addAttribute("pengumuman", pengumumanService.getPengumumanById(pengumumanId));
		return "view/viewPengumuman";
	}
}
